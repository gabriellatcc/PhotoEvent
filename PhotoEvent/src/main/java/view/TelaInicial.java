package view;

import controllers.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
public class TelaInicial extends JFrame {
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaInicial() {
        initComponents();
        setTitle("PhotoEvent - Início");
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe.png")).getImage());
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/telaInicio.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelBase.add(background);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        jPanelBase = new JPanel(null);

        JLabel iTitle = new JLabel("PhotoEvent");
        iTitle.setFont(new Font("Open Sans", Font.BOLD, 64));
        iTitle.setForeground(new Color(0xf0ece6));
        iTitle.setHorizontalAlignment(SwingConstants.CENTER);
        iTitle.setBounds(380, 161, 370, 76);
        jPanelBase.add(iTitle);

        JLabel lTitle = new JLabel("Login");
        lTitle.setFont(new Font("Open Sans", Font.BOLD, 56));
        lTitle.setForeground(new Color(0x393536));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setBounds(862,208,286,76);
        jPanelBase.add(lTitle);


        JLabel frase = new JLabel("<html><div style='text-align: center;'>Entre com sua conta de funcionário para registrar eventos, ver a listagem de clientes e manter a organização.</div></html>");
        frase.setFont(new Font("Montserrat", Font.PLAIN, 16));
        frase.setForeground(new Color(0x393536));
        frase.setOpaque(false);
        frase.setBounds(816, 615, 375, 75);
        jPanelBase.add(frase);

        BordaPadraoController bordaPadraoController = new BordaPadraoController(10);
        TitledBorder bordaEmail = new TitledBorder(
                bordaPadraoController,
                "Email",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaEmail.setTitleFont(new Font("Arial", Font.PLAIN, 18));
        bordaEmail.setTitleColor(new Color(0x393536));
        JTextField campoEmailC = new JTextField();
        campoEmailC.setBorder(bordaEmail);
        campoEmailC.setOpaque(false);
        campoEmailC.setFont(new Font("Arial",Font.PLAIN,17));
        campoEmailC.setBounds(829, 325, 350, 54);
        jPanelBase.add(campoEmailC);

        TitledBorder bordaSenha = new TitledBorder(
                bordaPadraoController,
                "Senha",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaSenha.setTitleFont(new Font("Arial", Font.PLAIN, 18));
        bordaSenha.setTitleColor(new Color(0x393536));
        JPasswordField campoSenhaC = new JPasswordField();
        campoSenhaC.setBorder(bordaSenha);
        campoSenhaC.setOpaque(false);
        campoSenhaC.setFont(new Font("Arial",Font.PLAIN,17));
        campoSenhaC.setBounds(829, 406, 350, 54);
        campoEmailC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    campoSenhaC.requestFocus();
                }
            }
        });

        JButton iniciar = new JButton("Iniciar");
        iniciar.setBackground(new Color(0xf2f2f2));
        iniciar.setFont(new Font("Calibre", Font.PLAIN, 20));
        iniciar.setForeground(new Color(0x393536));
        iniciar.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        iniciar.setPreferredSize(new Dimension(200, 50));
        iniciar.setBounds(873, 499, 250, 60);
        iniciar.addActionListener(evt -> {
            String email = campoEmailC.getText();
            String senha = new String(campoSenhaC.getPassword());
            AuthManager authManager=new AuthManager();
            if (authManager.login(email, senha)) {
                GerenciadorSessaoController.saveSession(email);
                dispose();
                TelasController telasController= new TelasController(email);
                telasController.abrirMenu();
            }
            EntradaController EntradaController = new EntradaController(email, senha, jPanelBase);
            EntradaController.executar();
        });
        campoSenhaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciar.doClick();
                }
            }
        });
        jPanelBase.add(campoSenhaC);
        jPanelBase.add(iniciar);

        JLabel textoFixo = new JLabel("É novo por aqui?");
        textoFixo.setFont(new Font("Arial", Font.PLAIN, 20));
        textoFixo.setForeground(new Color(57, 53, 54));
            textoFixo.setBounds(855, 580, 200, 23);

        JButton criarConta = new JButton("Crie sua conta.");
        criarConta.setFont(new Font("Arial", Font.PLAIN, 20));
        criarConta.setForeground(new Color(0x0cadee));
        criarConta.setBorderPainted(false);
        criarConta.setContentAreaFilled(false);
        criarConta.setFocusPainted(false);
        criarConta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        criarConta.setBounds(980, 580, 200, 23);
        criarConta.addActionListener(evt -> cardLayout.show(getContentPane(), "cardCadastro"));

        jPanelBase.add(textoFixo);
        jPanelBase.add(criarConta);


        getContentPane().add(jPanelBase, "cardInicio");
        getContentPane().add(new TelaCadastro(this), "cardCadastro");
    }
    public void mostrarCard(String card) {
        cardLayout.show(getContentPane(), card);
    }
}