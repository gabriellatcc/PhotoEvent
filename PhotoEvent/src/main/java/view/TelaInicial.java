package view;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaInicial() {
        initComponents();
        setTitle("PhotoEvent - Início");
        setSize(800, 600);
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe48px.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        // Define jPanelBase e configurações de layout
        jPanelBase = new JPanel(null);
        jPanelBase.setPreferredSize(new Dimension(800, 600));

        JLabel iTitle = new JLabel("PhotoEvent");
        iTitle.setFont(new Font("Open Sans", Font.BOLD, 48));
        iTitle.setForeground(new Color(0x262626));
        iTitle.setOpaque(false);
        iTitle.setHorizontalAlignment(SwingConstants.CENTER);
        iTitle.setVerticalAlignment(SwingConstants.CENTER);
        iTitle.setBounds(15, 33, 370, 76);
        jPanelBase.add(iTitle);

        JLabel subTitle = new JLabel("para Prisma Fotografia");
        subTitle.setFont(new Font("Open Sans", Font.BOLD, 25));
        subTitle.setForeground(new Color(0x262626));
        subTitle.setOpaque(false);
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);
        subTitle.setVerticalAlignment(SwingConstants.CENTER);
        subTitle.setBounds(15, 100, 370, 76);
        jPanelBase.add(subTitle);

        JTextArea frase = new JTextArea(4, 10);
        frase.setText("Registre  seus  eventos  e  veja  a lista de clientes do seu negócio para manter a organização");
        frase.setLineWrap(true);
        frase.setWrapStyleWord(true);
        frase.setEditable(false);
        frase.setFocusable(false);
        frase.setFont(new Font("Open Sans", Font.BOLD, 20));
        frase.setOpaque(false);
        frase.setBounds(420, 140, 358, 77);
        jPanelBase.add(frase);

        JButton entrar = new JButton("Entrar");
        entrar.setBackground(new Color(255,255,255));
        entrar.setFont(new Font("Calibre", Font.BOLD, 23));
        entrar.setForeground(new Color(0x262626));
        entrar.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 2, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        entrar.setPreferredSize(new Dimension(200, 50));
        entrar.setBounds(473, 253, 253, 60);
        entrar.setFocusable(false);
        entrar.addActionListener(evt -> cardLayout.show(getContentPane(), "cardEntrada"));
        jPanelBase.add(entrar);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setBackground(new Color(255,255,255));
        cadastrar.setFont(new Font("Calibre", Font.BOLD, 23));
        cadastrar.setForeground(new Color(0x262626));
        cadastrar.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0x262626), 2, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        cadastrar.setPreferredSize(new Dimension(200, 50));
        cadastrar.setBounds(473, 340, 253, 60);
        cadastrar.setFocusable(false);
        cadastrar.addActionListener(evt ->  cardLayout.show(getContentPane(), "cardCadastro"));
        jPanelBase.add(cadastrar);

        //800x600
        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/ilBGIvf800px.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, -30, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelBase.add(background);

        // Adiciona o jPanelBase ao JFrame
        getContentPane().add(jPanelBase, "cardInicio");

        // Instancia e adiciona os cards usando suas classes específicas
        getContentPane().add(new TelaCadastro(this), "cardCadastro");
        getContentPane().add(new TelaEntrada(this), "cardEntrada");

        pack();
    }
    // Métodos para alternar entre os cards
    public void mostrarCard(String card) {
        cardLayout.show(getContentPane(), card);
    }
}