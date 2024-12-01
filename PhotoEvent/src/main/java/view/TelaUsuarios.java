package view;

import controllers.BordaNegController;
import controllers.BordaPadraoController;
import models.UsuarioCRUD;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaUsuarios extends JPanel {
    private TelaMenuAdmin telaMenuAdmin;
    private JPanel listaUsuariosPanel;
    private JScrollPane scrollPane;
    private UsuarioCRUD usuarioCRUD;

    public TelaUsuarios(TelaMenuAdmin telaMenuAdmin) {
        this.telaMenuAdmin = telaMenuAdmin;
        this.usuarioCRUD = new UsuarioCRUD();

        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        BordaPadraoController bordaPadraoController = new BordaPadraoController(10);

        JButton voltarBtn = new JButton("⬅");
        voltarBtn.setForeground(new Color(0x393536));
        voltarBtn.setBackground(new Color(0xffffff));
        voltarBtn.setFocusable(false);
        voltarBtn.setFocusPainted(false);
        voltarBtn.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        voltarBtn.setFont(new Font("Calibre", Font.BOLD, 35));
        voltarBtn.setHorizontalAlignment(SwingConstants.CENTER);
        voltarBtn.setBounds(10, 10, 70, 55);
        voltarBtn.addActionListener(evt -> telaMenuAdmin.mostrarCard("cardMenu"));
        add(voltarBtn);

        JLabel title = new JLabel("Usuários Ativos");
        title.setFont(new Font("Open Sans", Font.BOLD, 52));
        title.setForeground(new Color(0x393536));
        title.setOpaque(false);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setBounds(526, 85, 500, 76);
        add(title);

        listaUsuariosPanel = new JPanel();
        listaUsuariosPanel.setLayout(new BoxLayout(listaUsuariosPanel, BoxLayout.Y_AXIS));
        listaUsuariosPanel.setBackground(new Color(0xf2f2f2));

        scrollPane = new JScrollPane(listaUsuariosPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(317, 200, 900, 520);
        add(scrollPane);

        List<String[]> usuarios = obterUsuariosAtivos();
        carregarUsuarios(usuarios);
    }

    public void carregarUsuarios(List<String[]> usuarios) {
        listaUsuariosPanel.removeAll();

        if (usuarios == null || usuarios.isEmpty()) {
            JLabel mensagem = new JLabel("Nenhum usuário ativo encontrado.");
            mensagem.setFont(new Font("Calibre", Font.BOLD, 18));
            mensagem.setForeground(new Color(0x393536));
            mensagem.setHorizontalAlignment(SwingConstants.CENTER);
            listaUsuariosPanel.add(mensagem);
        } else {
            for (String[] usuario : usuarios) {
                JPanel card = criarCardUsuario(usuario);
                card.setAlignmentX(Component.CENTER_ALIGNMENT);
                listaUsuariosPanel.add(card);
                listaUsuariosPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        listaUsuariosPanel.revalidate();
        listaUsuariosPanel.repaint();
    }

    public JPanel criarCardUsuario(String[] usuario) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(new Color(0xf2f2f2));
        card.setBorder(BorderFactory.createLineBorder(new Color(0x393536), 1));

        JLabel nomeLabel = new JLabel("Nome: " + usuario[0] + " " + usuario[1]);
        nomeLabel.setFont(new Font("Open Sans", Font.PLAIN, 25));
        nomeLabel.setBounds(10, 10, 400, 20);
        card.add(nomeLabel);

        JLabel emailLabel = new JLabel("Email: " + usuario[2]);
        emailLabel.setBounds(10, 40, 400, 20);
        card.add(emailLabel);

        JLabel cargoLabel = new JLabel("Cargo: " + usuario[3]);
        cargoLabel.setBounds(10, 70, 400, 20);
        card.add(cargoLabel);

        BordaNegController bordaNegController = new BordaNegController(10);
        JButton excluirBtn = new JButton("Excluir");
        excluirBtn.setBackground(new Color(0xecb1b9));
        excluirBtn.setForeground(new Color(0x393536));
        excluirBtn.setBorder(BorderFactory.createCompoundBorder(
                bordaNegController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        excluirBtn.setBounds(560, 20, 100, 30);
        excluirBtn.addActionListener(evt -> excluirUsuario(usuario));
        card.add(excluirBtn);

        return card;
    }

    private void excluirUsuario(String[] usuario) {
        String email = usuario[2];

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir o usuário: " + email + "?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            if (usuarioCRUD.excluirUsuario(email)) {
                JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                carregarUsuarios(obterUsuariosAtivos());
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<String[]> obterUsuariosAtivos() {
        List<String[]> usuariosAtivos = new ArrayList<>();

        try {
            List<Document> documentos = usuarioCRUD.obterUsuariosAtivos();

            for (Document doc : documentos) {
                String[] usuario = {
                        doc.getString("nome"),
                        doc.getString("sobrenome"),
                        doc.getString("email"),
                        doc.getString("cargo")
                };
                usuariosAtivos.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter usuários ativos: " + e.getMessage());
        }

        return usuariosAtivos;
    }
}