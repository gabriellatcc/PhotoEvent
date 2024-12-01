package view;

import controllers.BordaPadraoController;
import controllers.GerenciadorSessaoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TelaMenuAdmin extends JFrame
{
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaMenuAdmin()
    {
        initComponents();
        setTitle("PhotoEvent - Menu Admin");
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void initComponents()
    {
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        jPanelBase = new JPanel(null);

        BordaPadraoController bordaPadraoController=new BordaPadraoController(10);

        JButton sair = new JButton("Sair");
        sair.setFont(new Font("SansSerif", Font.BOLD, 30));
        sair.setBackground(new Color(0xf2f2f2));
        sair.setForeground(new Color(0x262626));
        sair.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        sair.setHorizontalAlignment(SwingConstants.CENTER);
        sair.setVerticalAlignment(SwingConstants.CENTER);
        sair.setFocusPainted(false);
        sair.setBounds(10, 10, 100, 50);
        sair.addActionListener(e -> {
            GerenciadorSessaoController.clearSession();
            dispose();
            new TelaInicial().setVisible(true);
        });
        jPanelBase.add(sair);

        JLabel frasemenu=new JLabel("O que você quer gerenciar hoje?");
        frasemenu.setFont(new Font("Calibre", Font.BOLD, 60));
        frasemenu.setForeground(new Color(0xf2f2f2));
        frasemenu.setOpaque(false);
        frasemenu.setHorizontalAlignment(SwingConstants.CENTER);
        frasemenu.setVerticalAlignment(SwingConstants.CENTER);
        frasemenu.setBounds(227,135,1080,100);
        jPanelBase.add(frasemenu);

        JLabel subfrase=new JLabel("Aqui você pode:");
        subfrase.setFont(new Font("Open Sans", Font.BOLD, 20));
        subfrase.setForeground(new Color(0x393536));
        subfrase.setOpaque(false);
        subfrase.setHorizontalAlignment(SwingConstants.CENTER);
        subfrase.setVerticalAlignment(SwingConstants.CENTER);
        subfrase.setBounds(227,256,1080,23);
        jPanelBase.add(subfrase);

        JLabel titleUsuarios =new JLabel("Usuários");
        titleUsuarios.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleUsuarios.setForeground(new Color(0xf2f2f2));
        titleUsuarios.setOpaque(false);
        titleUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        titleUsuarios.setVerticalAlignment(SwingConstants.CENTER);
        titleUsuarios.setBounds(48,321,314,65);
        jPanelBase.add(titleUsuarios);

        JButton usuariosbtn =new JButton("Visualizar");
        usuariosbtn.setFont(new Font("SansSerif", Font.BOLD, 30));
        usuariosbtn.setBackground(new Color(0xf2f2f2));
        usuariosbtn.setForeground(new Color(0x393536));
        usuariosbtn.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        usuariosbtn.setHorizontalAlignment(SwingConstants.CENTER);
        usuariosbtn.setVerticalAlignment(SwingConstants.CENTER);
        usuariosbtn.setBounds(67, 420, 278, 60);
        usuariosbtn.setFocusPainted(false);
        usuariosbtn.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cardLayout.show(getContentPane(), "cardUsuarios");
                    }
                }
        );
        jPanelBase.add(usuariosbtn);

        JLabel usuariosDescricao = new JLabel("<html><div style='text-align: center;'>Visualizar e deletar usuários.</div></html>");
        usuariosDescricao.setFont(new Font("Open Sans", Font.BOLD, 20));
        usuariosDescricao.setFocusable(false);
        usuariosDescricao.setForeground(new Color(0x393536));
        usuariosDescricao.setBounds(95, 500, 210, 50);
        jPanelBase.add(usuariosDescricao);

        JLabel titleSolicitacoes =new JLabel("Solicitações");
        titleSolicitacoes.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleSolicitacoes.setForeground(new Color(0xf0ece6));
        titleSolicitacoes.setOpaque(false);
        titleSolicitacoes.setHorizontalAlignment(SwingConstants.CENTER);
        titleSolicitacoes.setVerticalAlignment(SwingConstants.CENTER);
        titleSolicitacoes.setBounds(410,321,314,65);
        jPanelBase.add(titleSolicitacoes);

        JButton verSolicitacoes =new JButton("Visualizar");
        verSolicitacoes.setFont(new Font("SansSerif", Font.BOLD, 30));
        verSolicitacoes.setBackground(new Color(0xf2f2f2));
        verSolicitacoes.setForeground(new Color(0x262626));
        verSolicitacoes.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verSolicitacoes.setHorizontalAlignment(SwingConstants.CENTER);
        verSolicitacoes.setVerticalAlignment(SwingConstants.CENTER);
        verSolicitacoes.setBounds(441, 420, 278, 60);
        verSolicitacoes.setFocusPainted(false);
        verSolicitacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardSolicitacoes");
            }
        });
        jPanelBase.add(verSolicitacoes);

        JLabel solicitacaoDescricao = new JLabel("<html><div style='text-align: center;'>Administrar solicitações de cadastro e de alteração de cargo.</div></html>");
        solicitacaoDescricao.setFont(new Font("Open Sans", Font.BOLD, 20));
        solicitacaoDescricao.setFocusable(false);
        solicitacaoDescricao.setForeground(new Color(0x393536));
        solicitacaoDescricao.setBounds(460, 500, 239, 80);
        jPanelBase.add(solicitacaoDescricao);

        JLabel titlePrecificao =new JLabel("Precificação");
        titlePrecificao.setFont(new Font("SansSerif", Font.BOLD, 40));
        titlePrecificao.setForeground(new Color(0xf0ece6));
        titlePrecificao.setOpaque(false);
        titlePrecificao.setHorizontalAlignment(SwingConstants.CENTER);
        titlePrecificao.setVerticalAlignment(SwingConstants.CENTER);
        titlePrecificao.setBounds(800,321,314,65);
        jPanelBase.add(titlePrecificao);

        JButton verPrecificacaoes =new JButton("Consultar");
        verPrecificacaoes.setFont(new Font("SansSerif", Font.BOLD, 30));
        verPrecificacaoes.setBackground(new Color(0xf2f2f2));
        verPrecificacaoes.setForeground(new Color(0x262626));
        verPrecificacaoes.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verPrecificacaoes.setHorizontalAlignment(SwingConstants.CENTER);
        verPrecificacaoes.setVerticalAlignment(SwingConstants.CENTER);
        verPrecificacaoes.setBounds(817, 420, 278, 60);
        verPrecificacaoes.setFocusPainted(false);
        verPrecificacaoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardPrecificacao");
            }
        });
        jPanelBase.add(verPrecificacaoes);

        JLabel precificacaoDescricao = new JLabel("<html><div style='text-align: center;'>Ver e editar valores de serviço e pagamentos.</div></html>");
        precificacaoDescricao.setFont(new Font("Open Sans", Font.BOLD, 20));
        precificacaoDescricao.setFocusable(false);
        precificacaoDescricao.setForeground(new Color(0x393536));
        precificacaoDescricao.setBounds(848, 500, 210, 80);
        jPanelBase.add(precificacaoDescricao);

        JLabel titleSistema =new JLabel("Sistema");
        titleSistema.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleSistema.setForeground(new Color(0xf0ece6));
        titleSistema.setOpaque(false);
        titleSistema.setHorizontalAlignment(SwingConstants.CENTER);
        titleSistema.setVerticalAlignment(SwingConstants.CENTER);
        titleSistema.setBounds(1172,321,314,65);
        jPanelBase.add(titleSistema);

        String[] cargos = {"Assistente geral", "Fotógrafo", "Videomaker", "Editor de Fotos", "Editor de Vídeos"};
        JComboBox<String> comboBox = new JComboBox<>(cargos);
        comboBox.setBorder(bordaPadraoController);
        comboBox.setFont(new Font("SansSerif", Font.BOLD, 25));
        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
        comboBox.setBounds(1183, 420, 290, 60);
        comboBox.addActionListener(e -> {
            String selecionado = (String) comboBox.getSelectedItem();
            JFrame frameAtual = (JFrame) SwingUtilities.getWindowAncestor(comboBox);
            switch (selecionado) {
                case "Assistente geral":
                    new TelaMenuAssistente().setVisible(true);
                    frameAtual.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Seleção inválida.");
                    break;
            }
        });
        jPanelBase.add(comboBox);

        JLabel sistemaDescricao = new JLabel("<html><div style='text-align: center;'>Ver a tela de outros usuários.</div></html>");
        sistemaDescricao.setFont(new Font("Open Sans", Font.BOLD, 20));
        sistemaDescricao.setFocusable(false);
        sistemaDescricao.setForeground(new Color(0x393536));
        sistemaDescricao.setBounds(1220, 500, 210, 50);
        jPanelBase.add(sistemaDescricao);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/telaMenuAdmin.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelBase.add(background);

        getContentPane().add(jPanelBase, "cardMenu");

        getContentPane().add(new TelaSolicitacoes(this), "cardSolicitacoes");
        getContentPane().add(new TelaUsuarios(this), "cardUsuarios");
        getContentPane().add(new TelaPrecificacao(this), "cardPrecificacao");

        pack();
    }
    public void mostrarCard(String card) {
        cardLayout.show(getContentPane(), card);
    }
}
