package view;

import controllers.BordaAprController;
import controllers.BordaNegController;
import controllers.BordaPadraoController;
import controllers.CadastroSucesso;
import models.UsuarioCRUD;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaSolicitacoes extends JPanel {
    private TelaMenuAdmin telaMenuAdmin;
    private JPanel listaSolicitacoesPanel;
    private JScrollPane scrollPane;
    private UsuarioCRUD usuarioCRUD;

    public TelaSolicitacoes(TelaMenuAdmin telaMenuAdmin) {
        this.telaMenuAdmin = telaMenuAdmin;
        this.usuarioCRUD = new UsuarioCRUD();

        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBackground(new Color(255,255,255));

        BordaPadraoController bordaPadraoController = new BordaPadraoController(10);

        JButton voltarC = new JButton("⬅");
        voltarC.setForeground(new Color(0x393536));
        voltarC.setBackground(new Color(0xffffff));
        voltarC.setFocusable(false);
        voltarC.setFocusPainted(false);
        voltarC.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        voltarC.setFont(new Font("Calibre", Font.BOLD, 35));
        voltarC.setHorizontalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(10, 10, 70, 55);
        voltarC.addActionListener(evt -> telaMenuAdmin.mostrarCard("cardMenuAdmin"));
        add(voltarC);

        JLabel title=new JLabel("Solicitações");
        title.setFont(new Font("Open Sans", Font.BOLD, 52));
        title.setForeground(new Color(0x393536));
        title.setOpaque(false);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setBounds(526,85,500,76);
        add(title);

        listaSolicitacoesPanel = new JPanel();
        listaSolicitacoesPanel.setLayout(new BoxLayout(listaSolicitacoesPanel, BoxLayout.Y_AXIS));
        listaSolicitacoesPanel.setBackground(new Color(0xf2f2f2));

        scrollPane = new JScrollPane(listaSolicitacoesPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(317, 200, 900, 520);
        add(scrollPane);

        List<String[]> solicitacoes = obterSolicitacoesPendentes();
        carregarSolicitacoes(solicitacoes);
    }

    public void carregarSolicitacoes(List<String[]> solicitacoes) {
        listaSolicitacoesPanel.removeAll();

        if (solicitacoes == null || solicitacoes.isEmpty()) {
            JLabel mensagem = new JLabel("Nenhuma solicitação pendente.");
            mensagem.setFont(new Font("Calibre", Font.BOLD, 18));
            mensagem.setForeground(new Color(0x393536));
            mensagem.setHorizontalAlignment(SwingConstants.CENTER);
            listaSolicitacoesPanel.add(mensagem);
        } else {
            for (String[] solicitacao : solicitacoes) {
                JPanel card = criarCardSolicitacao(solicitacao);
                card.setAlignmentX(Component.CENTER_ALIGNMENT);
                listaSolicitacoesPanel.add(card);
                listaSolicitacoesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        listaSolicitacoesPanel.revalidate();
        listaSolicitacoesPanel.repaint();
    }

    public JPanel criarCardSolicitacao(String[] solicitacao) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(new Color(0xf2f2f2));
        card.setBorder(BorderFactory.createLineBorder(new Color(0x393536), 1));

        JLabel nomeLabel = new JLabel("Nome: " + solicitacao[0] + " " + solicitacao[1]);
        nomeLabel.setFont(new Font("Open Sans", Font.PLAIN, 25));
        nomeLabel.setBounds(10, 10, 400, 20);
        card.add(nomeLabel);

        JLabel emailLabel = new JLabel("Email: " + solicitacao[2]);
        emailLabel.setBounds(10, 40, 400, 20);
        card.add(emailLabel);

        JLabel cargoLabel = new JLabel("Cargo: " + solicitacao[3]);
        cargoLabel.setBounds(10, 70, 400, 20);
        card.add(cargoLabel);

        BordaAprController bordaAprController=new BordaAprController(10);
        JButton aprovarBtn = new JButton("Aprovar");
        aprovarBtn.setBackground(new Color(0xadd6be));
        aprovarBtn.setForeground(new Color(0x393536));
        aprovarBtn.setBorder(BorderFactory.createCompoundBorder(
                bordaAprController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        aprovarBtn.setBounds(560, 20, 100, 30);
        aprovarBtn.addActionListener(evt -> aprovarSolicitacao(solicitacao));
        card.add(aprovarBtn);

        BordaNegController bordaNegController=new BordaNegController(10);
        JButton rejeitarBtn = new JButton("Rejeitar");
        rejeitarBtn.setBackground(new Color(0xecb1b9));
        rejeitarBtn.setForeground(new Color(0x393536));
        rejeitarBtn.setBorder(BorderFactory.createCompoundBorder(
                bordaNegController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        rejeitarBtn.setBounds(680, 20, 100, 30);
        rejeitarBtn.addActionListener(evt -> rejeitarSolicitacao(solicitacao));
        card.add(rejeitarBtn);

        return card;
    }

    private void aprovarSolicitacao(String[] solicitacao) {
        String nome = solicitacao[0];
        String sobrenome = solicitacao[1];
        String email = solicitacao[2];
        String cargo = solicitacao[3];
        String senha = solicitacao[4];

        CadastroSucesso cadastro = new CadastroSucesso(nome, sobrenome, email, senha, cargo);
        if (cadastro.registrarUsuario()) {
            JOptionPane.showMessageDialog(this, "Solicitação aprovada e usuário cadastrado: " + email, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            atualizarStatusSolicitacao(email, "ativo");
            carregarSolicitacoes(obterSolicitacoesPendentes());
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao aprovar solicitação: " + email, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rejeitarSolicitacao(String[] solicitacao) {
        String email = solicitacao[2];
        atualizarStatusSolicitacao(email, "rejeitado");
        carregarSolicitacoes(obterSolicitacoesPendentes());
        JOptionPane.showMessageDialog(this, "Solicitação rejeitada: " + email, "Rejeitado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarStatusSolicitacao(String email, String novoStatus) {
        usuarioCRUD.atualizarStatusSolicitacao(email, novoStatus);
    }

    public List<String[]> obterSolicitacoesPendentes() {
        List<String[]> solicitacoesPendentes = new ArrayList<>();

        try {
            List<Document> documentos = usuarioCRUD.obterSolicitacoesPendentes();

            for (Document doc : documentos) {
                String[] solicitacao = {
                        doc.getString("nome"),
                        doc.getString("sobrenome"),
                        doc.getString("email"),
                        doc.getString("cargo"),
                        doc.getString("senha")
                };
                solicitacoesPendentes.add(solicitacao);
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter solicitações pendentes: " + e.getMessage());
        }

        return solicitacoesPendentes;
    }


}
