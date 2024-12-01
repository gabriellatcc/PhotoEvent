package view;

import controllers.BordaPadraoController;
import controllers.GerenciadorSessaoController;

import javax.swing.*;
import java.awt.*;

public class TelaMenuAssistente extends JFrame implements TelaMenuBase
{
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaMenuAssistente()
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

        JButton verClientes =new JButton("Ver");
        verClientes.setFont(new Font("SansSerif", Font.BOLD, 30));
        verClientes.setBackground(new Color(0xf2f2f2));
        verClientes.setForeground(new Color(0x393536));
        verClientes.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verClientes.setHorizontalAlignment(SwingConstants.CENTER);
        verClientes.setVerticalAlignment(SwingConstants.CENTER);
        verClientes.setBounds(107, 420, 278, 60);
        verClientes.setFocusPainted(false);
        verClientes.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cardLayout.show(getContentPane(), "cardCliente");
                    }
                }
        );
        jPanelBase.add(verClientes);

        JButton verArquivos =new JButton("Visualizar");
        verArquivos.setFont(new Font("SansSerif", Font.BOLD, 30));
        verArquivos.setBackground(new Color(0xf2f2f2));
        verArquivos.setForeground(new Color(0x262626));
        verArquivos.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verArquivos.setHorizontalAlignment(SwingConstants.CENTER);
        verArquivos.setVerticalAlignment(SwingConstants.CENTER);
        verArquivos.setBounds(465, 420, 278, 60);
        verArquivos.setFocusPainted(false);
        verArquivos.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cardLayout.show(getContentPane(), "cardArquivos");
                    }
                }
        );
        jPanelBase.add(verArquivos);


        JButton verCalendario =new JButton("Visualizar");
        verCalendario.setFont(new Font("SansSerif", Font.BOLD, 30));
        verCalendario.setBackground(new Color(0xf2f2f2));
        verCalendario.setForeground(new Color(0x262626));
        verCalendario.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verCalendario.setHorizontalAlignment(SwingConstants.CENTER);
        verCalendario.setVerticalAlignment(SwingConstants.CENTER);
        verCalendario.setBounds(806, 420, 278, 60);
        verCalendario.setFocusPainted(false);
        verCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardCalendario");
            }
        });
        jPanelBase.add(verCalendario);

        JButton verFolha =new JButton("Consultar");
        verFolha.setFont(new Font("SansSerif", Font.BOLD, 30));
        verFolha.setBackground(new Color(0xf2f2f2));
        verFolha.setForeground(new Color(0x262626));
        verFolha.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        verFolha.setHorizontalAlignment(SwingConstants.CENTER);
        verFolha.setVerticalAlignment(SwingConstants.CENTER);
        verFolha.setBounds(1143, 484, 278, 60);
        verFolha.setFocusPainted(false);
        verFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardLayout.show(getContentPane(), "cardFolha");
            }
        });
        jPanelBase.add(verFolha);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/telaMenuAssistente.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelBase.add(background);

        getContentPane().add(jPanelBase, "cardMenu");

        getContentPane().add(new TelaCliente(this), "cardCliente");
        getContentPane().add(new TelaArquivos(), "cardArquivos");
        getContentPane().add(new TelaCalendario(this), "cardCalendario");

        pack();
    }
    public void mostrarCard(String card) {
        cardLayout.show(getContentPane(), card);
    }
}