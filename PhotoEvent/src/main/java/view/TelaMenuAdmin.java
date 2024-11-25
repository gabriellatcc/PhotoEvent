package view;

import controllers.BordaPadraoController;
import controllers.GerenciadorSessaoController;

import javax.swing.*;
import java.awt.*;

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

        JLabel frasemenu=new JLabel("O que você quer gerenciar hoje?");
        frasemenu.setFont(new Font("Calibre", Font.BOLD, 60));
        frasemenu.setForeground(new Color(0x393536));
        frasemenu.setOpaque(false);
        frasemenu.setHorizontalAlignment(SwingConstants.CENTER);
        frasemenu.setVerticalAlignment(SwingConstants.CENTER);
        frasemenu.setBounds(227,135,1080,100);
        jPanelBase.add(frasemenu);

        BordaPadraoController BordaPadraoController = new BordaPadraoController(10);

        ImageIcon backsy = new ImageIcon(getClass().getResource("/images/ilExit48px.png"));
        JButton sair = new JButton("Sair",backsy);
        sair.setFont(new Font("SansSerif", Font.BOLD, 30));
        sair.setBackground(new Color(0xf2f2f2));
        sair.setForeground(new Color(0x262626));
        sair.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        sair.setHorizontalTextPosition(SwingConstants.LEFT);
        sair.setVerticalTextPosition(SwingConstants.CENTER);
        sair.setHorizontalAlignment(SwingConstants.RIGHT);
        sair.setVerticalAlignment(SwingConstants.CENTER);
        sair.setFocusPainted(false);
        sair.setBounds(10, 10, 150, 50);
        sair.addActionListener(e -> {
            GerenciadorSessaoController.clearSession();
            dispose();
            new TelaInicial().setVisible(true);
        });

        jPanelBase.add(sair);

        JButton perfil = new JButton("Minha Conta");
        perfil.setFont(new Font("SansSerif", Font.BOLD, 30));
        perfil.setBackground(new Color(255, 255, 255));
        perfil.setForeground(new Color(0x393536));
        perfil.setHorizontalTextPosition(SwingConstants.RIGHT);
        perfil.setVerticalTextPosition(SwingConstants.CENTER);
        perfil.setHorizontalAlignment(SwingConstants.LEFT);
        perfil.setVerticalAlignment(SwingConstants.CENTER);
        perfil.setBounds(1335, 0, 250, 50);
        perfil.setOpaque(false);
        perfil.setFocusPainted(false);
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardPerfil");
            }
        });
        jPanelBase.add(perfil);


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
                BordaPadraoController,
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

        JLabel titleClientes=new JLabel("Clientes");
        titleClientes.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleClientes.setForeground(new Color(0xf0ece6));
        titleClientes.setOpaque(false);
        titleClientes.setHorizontalAlignment(SwingConstants.CENTER);
        titleClientes.setVerticalAlignment(SwingConstants.CENTER);
        titleClientes.setBounds(48,321,314,65);
        jPanelBase.add(titleClientes);

        JButton verClientes=new JButton("Ver total de clientes");
        verClientes.setFont(new Font("SansSerif", Font.BOLD, 30));
        verClientes.setBackground(new Color(0xf2f2f2));
        verClientes.setForeground(new Color(0x262626));
        verClientes.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verClientes.setHorizontalAlignment(SwingConstants.CENTER);
        verClientes.setVerticalAlignment(SwingConstants.CENTER);
        verClientes.setBounds(67, 420, 278, 60);
        verClientes.setFocusPainted(false);
        verClientes.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cardLayout.show(getContentPane(), "cardCliente");
                    }
                }
        );
        jPanelBase.add(verClientes);

        JLabel titleCalendario=new JLabel("Calendário");
        titleCalendario.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleCalendario.setForeground(new Color(0xf0ece6));
        titleCalendario.setOpaque(false);
        titleCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        titleCalendario.setVerticalAlignment(SwingConstants.CENTER);
        titleCalendario.setBounds(796,321,321,65);
        jPanelBase.add(titleCalendario);

        JButton verCalendario=new JButton("<html><div style='text-align: center;'>Visualizar calendário</div></html>");
        verCalendario.setFont(new Font("SansSerif", Font.BOLD, 30));
        verCalendario.setBackground(new Color(0xf2f2f2));
        verCalendario.setForeground(new Color(0x262626));
        verCalendario.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        verCalendario.setVerticalAlignment(SwingConstants.CENTER);
        verCalendario.setBounds(837, 420, 240, 100);
        verCalendario.setFocusPainted(false);
        verCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardCalendario");
            }
        });
        jPanelBase.add(verCalendario);

        JLabel titleFolha = new JLabel("<html><div style='text-align: center;'>Folha de pagamento</div></html>");
        titleFolha.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleFolha.setForeground(new Color(0xf0ece6));
        titleFolha.setOpaque(false);
        titleFolha.setHorizontalAlignment(SwingConstants.CENTER);
        titleFolha.setVerticalAlignment(SwingConstants.CENTER);
        titleFolha.setBounds(1194,321,268,130);
        jPanelBase.add(titleFolha);

        JButton verFolha=new JButton("<html><div style='text-align: center;'>Consultar pagamentos</div></html>s");
        verFolha.setFont(new Font("SansSerif", Font.BOLD, 30));
        verFolha.setBackground(new Color(0xf2f2f2));
        verFolha.setForeground(new Color(0x262626));
        verFolha.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verFolha.setHorizontalAlignment(SwingConstants.CENTER);
        verFolha.setVerticalAlignment(SwingConstants.CENTER);
        verFolha.setBounds(1189, 485, 278, 100);
        verFolha.setFocusPainted(false);
        verFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardFolha");
            }
        });
        jPanelBase.add(verFolha);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/telaMenuAdmin.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelBase.add(background);

        getContentPane().add(jPanelBase, "cardMenuAdmin");

        getContentPane().add(new TelaSolicitacoes(this), "cardSolicitacoes");

        pack();
    }
    public void mostrarCard(String card) {
        cardLayout.show(getContentPane(), card);
    }
}
