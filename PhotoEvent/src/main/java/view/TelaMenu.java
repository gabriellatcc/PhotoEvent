package view;

import controllers.StatusLogin;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaMenu() {
        initComponents();
        setTitle("PhotoEvent - Menu");
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe48px.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // Inicializa o layout do JFrame como CardLayout
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        // Define jPanelBase e configurações de layout
        jPanelBase = new JPanel(null);
        jPanelBase.setPreferredSize(new Dimension(1920, 1080));

        //botoes coisos
        JLabel frasemenu=new JLabel("O que você quer gerenciar hoje?");
        frasemenu.setFont(new Font("Calibre", Font.BOLD, 60));
        frasemenu.setForeground(new Color(0x262626));
        frasemenu.setOpaque(false);
        frasemenu.setHorizontalAlignment(SwingConstants.CENTER);
        frasemenu.setVerticalAlignment(SwingConstants.CENTER);
        frasemenu.setBounds(227,102,1080,100);  //1535
        jPanelBase.add(frasemenu);

        ImageIcon backsy = new ImageIcon(getClass().getResource("/images/ilExit48px.png"));
        JButton sair = new JButton("Sair",backsy);
        sair.setFont(new Font("SansSerif", Font.BOLD, 30));
        sair.setBackground(new Color(255, 255, 255));
        sair.setForeground(new Color(0x262626));
        sair.setHorizontalTextPosition(SwingConstants.RIGHT);
        sair.setVerticalTextPosition(SwingConstants.CENTER);
        sair.setHorizontalAlignment(SwingConstants.LEFT);
        sair.setVerticalAlignment(SwingConstants.CENTER);
        sair.setBounds(-16, 0, 200, 50);
        sair.setBorderPainted(false);
        sair.setFocusPainted(false);
        sair.setOpaque(false);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Fechar a TelaMenu
                TelaMenu tm = (TelaMenu) SwingUtilities.getWindowAncestor(sair);
                tm.dispose(); // Fecha a janela do menu

                // Atualizar o status de login para "deslogado"
                StatusLogin statusLogin = new StatusLogin(false);

                // Abrir a tela inicial novamente
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true); // Abre a tela de início
            }
        });
        jPanelBase.add(sair);

        JButton perfil = new JButton("Minha Conta");
        perfil.setFont(new Font("SansSerif", Font.BOLD, 30));
        perfil.setBackground(new Color(255, 255, 255));
        perfil.setForeground(new Color(0x262626));
        perfil.setHorizontalTextPosition(SwingConstants.RIGHT);
        perfil.setVerticalTextPosition(SwingConstants.CENTER);
        perfil.setHorizontalAlignment(SwingConstants.LEFT);
        perfil.setVerticalAlignment(SwingConstants.CENTER);
        perfil.setBounds(1335, 0, 250, 50);
        perfil.setBorderPainted(false);
        perfil.setFocusPainted(false);
        perfil.setOpaque(false);
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardPerfil");
            }
        });
        jPanelBase.add(perfil);


        JLabel titleEventos=new JLabel("Eventos");
        titleEventos.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleEventos.setForeground(new Color(0x262626));
        titleEventos.setOpaque(false);
        titleEventos.setHorizontalAlignment(SwingConstants.CENTER);
        titleEventos.setVerticalAlignment(SwingConstants.CENTER);
        titleEventos.setBounds(100,248,590,65);
        jPanelBase.add(titleEventos);

        JButton adicionarEvento=new JButton("Adicionar evento");
        adicionarEvento.setFont(new Font("SansSerif", Font.BOLD, 30));
        adicionarEvento.setBackground(new Color(0xd9d3c7));
        adicionarEvento.setForeground(new Color(0x262626));
        adicionarEvento.setHorizontalAlignment(SwingConstants.CENTER);
        adicionarEvento.setVerticalAlignment(SwingConstants.CENTER);
        adicionarEvento.setBounds(150, 325, 490, 75);
        adicionarEvento.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 4, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        adicionarEvento.setFocusPainted(false);
        adicionarEvento.setOpaque(true);
        jPanelBase.add(adicionarEvento);

        JButton verEvento=new JButton("Ver total de eventos");
        verEvento.setFont(new Font("SansSerif", Font.BOLD, 30));
        verEvento.setBackground(new Color(0xd9d3c7));
        verEvento.setForeground(new Color(0x262626));
        verEvento.setHorizontalAlignment(SwingConstants.CENTER);
        verEvento.setVerticalAlignment(SwingConstants.CENTER);
        verEvento.setBounds(150, 422, 490, 75);
        verEvento.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 4, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        verEvento.setFocusPainted(false);
        verEvento.setOpaque(true);
        verEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardEvento");
            }
        });
        jPanelBase.add(verEvento);

        JLabel titleClientes=new JLabel("Clientes");
        titleClientes.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleClientes.setForeground(new Color(0x262626));
        titleClientes.setOpaque(false);
        titleClientes.setHorizontalAlignment(SwingConstants.CENTER);
        titleClientes.setVerticalAlignment(SwingConstants.CENTER);
        titleClientes.setBounds(78,554,626,65);
        jPanelBase.add(titleClientes);

        JButton cadastrarCliente=new JButton("Cadastrar cliente ");
        cadastrarCliente.setFont(new Font("SansSerif", Font.BOLD, 30));
        cadastrarCliente.setBackground(new Color(0xd9d3c7));
        cadastrarCliente.setForeground(new Color(0x262626));
        cadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
        cadastrarCliente.setVerticalAlignment(SwingConstants.CENTER);
        cadastrarCliente.setBounds(150, 633, 490, 75);
        cadastrarCliente.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 4, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        cadastrarCliente.setFocusPainted(false);
        cadastrarCliente.setOpaque(true);
        jPanelBase.add(cadastrarCliente);

        JButton verClientes=new JButton("Ver total de clientes");
        verClientes.setFont(new Font("SansSerif", Font.BOLD, 30));
        verClientes.setBackground(new Color(0xd9d3c7));
        verClientes.setForeground(new Color(0x262626));
        verClientes.setHorizontalAlignment(SwingConstants.CENTER);
        verClientes.setVerticalAlignment(SwingConstants.CENTER);
        verClientes.setBounds(150, 730, 490, 75);
        verClientes.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 4, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        verClientes.setFocusPainted(false);
        verClientes.setOpaque(true);
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
        titleCalendario.setForeground(new Color(0x262626));
        titleCalendario.setOpaque(false);
        titleCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        titleCalendario.setVerticalAlignment(SwingConstants.CENTER);
        titleCalendario.setBounds(980,249,321,65);
        jPanelBase.add(titleCalendario);

        JButton verCalendario=new JButton("Visualizar calendário");
        verCalendario.setFont(new Font("SansSerif", Font.BOLD, 30));
        verCalendario.setBackground(new Color(0xd9d3c7));
        verCalendario.setForeground(new Color(0x262626));
        verCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        verCalendario.setVerticalAlignment(SwingConstants.CENTER);
        verCalendario.setBounds(873, 363, 535, 75);
        verCalendario.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 4, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        verCalendario.setFocusPainted(false);
        verCalendario.setOpaque(true);
        verCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardCalendario");
            }
        });
        jPanelBase.add(verCalendario);

        JLabel titleFolha=new JLabel("Folha de pagamento");
        titleFolha.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleFolha.setForeground(new Color(0x262626));
        titleFolha.setOpaque(false);
        titleFolha.setHorizontalAlignment(SwingConstants.CENTER);
        titleFolha.setVerticalAlignment(SwingConstants.CENTER);
        titleFolha.setBounds(863,554,554,65);
        jPanelBase.add(titleFolha);

        JButton verFolha=new JButton("Ver folha de pagamento");
        verFolha.setFont(new Font("SansSerif", Font.BOLD, 30));
        verFolha.setBackground(new Color(0xd9d3c7));
        verFolha.setForeground(new Color(0x262626));
        verFolha.setHorizontalAlignment(SwingConstants.CENTER);
        verFolha.setVerticalAlignment(SwingConstants.CENTER);
        verFolha.setBounds(873, 664, 535, 75);
        verFolha.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 4, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        verFolha.setFocusPainted(false);
        verFolha.setOpaque(true);
        verFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardFolha");
            }
        });
        jPanelBase.add(verFolha);

        //1535x840
        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/ilBGMvf1535px.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelBase.add(background);

        // Adiciona o jPanelBase ao JFrame
        getContentPane().add(jPanelBase, "cardBackground");

        // Instancia e adiciona os cards usando suas classes específicas
        jPanelBase.add(new TelaCliente(), "cardCliente");//
        jPanelBase.add(new TelaCalendario(), "cardCalendario");
        jPanelBase.add(new TelaFolha(), "cardFolha");
        jPanelBase.add(new TelaEvento(), "cardEvento");
        jPanelBase.add(new TelaPerfil(), "cardPerfil");

        pack();

    }

    // Métodos para alternar entre os cards
    public void mostrarCard(String card) {
        cardLayout.show(jPanelBase, card);
    }
}
