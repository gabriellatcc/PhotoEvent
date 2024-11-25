package view;

import controllers.BordaPadraoController;
import controllers.GerenciadorSessaoController;

import javax.swing.*;
import java.awt.*;

public class TelaMenuAssistente extends JFrame
{
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaMenuAssistente()
    {
        initComponents();
        setTitle("PhotoEvent - Menu");
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


        JLabel titleEventos=new JLabel("Eventos");
        titleEventos.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleEventos.setForeground(new Color(0xf0ece6));
        titleEventos.setOpaque(false);
        titleEventos.setHorizontalAlignment(SwingConstants.CENTER);
        titleEventos.setVerticalAlignment(SwingConstants.CENTER);
        titleEventos.setBounds(423,321,314,65);
        jPanelBase.add(titleEventos);

        JButton adicionarEvento=new JButton("+");
        adicionarEvento.setFont(new Font("Calibre", Font.BOLD, 50));
        adicionarEvento.setBackground(new Color(0xf2f2f2));
        adicionarEvento.setForeground(new Color(0x262626));
        adicionarEvento.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        adicionarEvento.setHorizontalAlignment(SwingConstants.CENTER);
        adicionarEvento.setVerticalAlignment(SwingConstants.CENTER);
        adicionarEvento.setBounds(520, 501, 122, 110);
        adicionarEvento.setFocusPainted(false);
        jPanelBase.add(adicionarEvento);

        JButton verEvento=new JButton("Ver total de eventos");
        verEvento.setFont(new Font("SansSerif", Font.BOLD, 30));
        verEvento.setBackground(new Color(0xf2f2f2));
        verEvento.setForeground(new Color(0x262626));
        verEvento.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verEvento.setHorizontalAlignment(SwingConstants.CENTER);
        verEvento.setVerticalAlignment(SwingConstants.CENTER);
        verEvento.setBounds(441, 420, 278, 60);
        verEvento.setFocusPainted(false);
        verEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardEvento");
            }
        });
        jPanelBase.add(verEvento);

        JLabel titleClientes=new JLabel("Clientes");
        titleClientes.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleClientes.setForeground(new Color(0xf0ece6));
        titleClientes.setOpaque(false);
        titleClientes.setHorizontalAlignment(SwingConstants.CENTER);
        titleClientes.setVerticalAlignment(SwingConstants.CENTER);
        titleClientes.setBounds(48,321,314,65);
        jPanelBase.add(titleClientes);

        JButton cadastrarCliente=new JButton("+");
        cadastrarCliente.setFont(new Font("Calibre", Font.BOLD, 50));
        cadastrarCliente.setBackground(new Color(0xf2f2f2));
        cadastrarCliente.setForeground(new Color(0x262626));
        cadastrarCliente.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        cadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
        cadastrarCliente.setVerticalAlignment(SwingConstants.CENTER);
        cadastrarCliente.setBounds(144, 501, 122, 110);
        cadastrarCliente.setFocusPainted(false);
        jPanelBase.add(cadastrarCliente);


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

        getContentPane().add(jPanelBase, "cardMenu");

        getContentPane().add(new TelaFolhaAdmin(this), "cardPerfil");
        getContentPane().add(new TelaEvento(this), "cardEvento");
        getContentPane().add(new TelaCliente(this), "cardCliente");
        getContentPane().add(new TelaCalendario(this), "cardCalendario");
        getContentPane().add(new TelaFolhaFuncionarios(this), "cardFolha");

        pack();

    }
    public void mostrarCard(String card) {
        cardLayout.show(getContentPane(), card);
    }
}
