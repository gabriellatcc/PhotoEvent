package view;

import controllers.Entrada;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Arrays;

public class TelaEntrada extends JPanel {
    private TelaInicial telaInicial;
    public TelaEntrada(TelaInicial telaInicial)
    {
        this.telaInicial = telaInicial;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        JPanel jPanelLogin = new JPanel();

        // propriedades do card ENTRAR
        jPanelLogin.setPreferredSize(new Dimension(800, 600));
        jPanelLogin.setLayout(null);
        jPanelLogin.setBackground(new Color(255, 255, 255));

        JLabel cTitle = new JLabel("Acessar Conta");
        cTitle.setFont(new Font("Open Sans", Font.BOLD, 48));
        cTitle.setForeground(new Color(0x262626));
        cTitle.setOpaque(false);
        cTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cTitle.setVerticalAlignment(SwingConstants.CENTER);
        cTitle.setBounds(0,300,400,76);
        add(cTitle);

        JTextArea fraseL = new JTextArea(5, 25);
        fraseL.setFont(new Font("Calibre", Font.PLAIN, 18));
        fraseL.setText("Bem vindo(a) de volta!\n    Vamos começar?");
        fraseL.setBounds(90, 400, 300, 80);
        add(fraseL);

        TitledBorder bordaEmail = new TitledBorder(
                new LineBorder(Color.decode("#262626"), 1),
                "Email",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaEmail.setTitleFont(new Font("Calibre", Font.BOLD, 20));
        JTextField campoEmailC = new JTextField();
        campoEmailC.setBorder(bordaEmail);
        campoEmailC.setOpaque(false);
        campoEmailC.setFont(new Font("Arial",Font.PLAIN,18));
        campoEmailC.setBounds(420, 127, 350, 65);
        add(campoEmailC);

        TitledBorder bordaSenha = new TitledBorder(
                new LineBorder(Color.decode("#262626"), 1),
                "Senha",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaSenha.setTitleFont(new Font("Calibre", Font.BOLD, 20));
        JPasswordField campoSenhaC = new JPasswordField();
        campoSenhaC.setBorder(bordaSenha);
        campoSenhaC.setOpaque(false);
        campoSenhaC.setFont(new Font("Arial",Font.PLAIN,18));
        campoSenhaC.setBounds(420, 248, 350, 65);
        add(campoSenhaC);

        JButton iniciar=new JButton("Iniciar");
        iniciar.setBackground(Color.WHITE);
        iniciar.setFont(new Font("Calibre", Font.BOLD, 23));
        iniciar.setForeground(new Color(0x262626));
        iniciar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0x262626), 2, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        iniciar.setPreferredSize(new Dimension(200, 50));
        iniciar.setBounds(475,480, 250, 60);
        iniciar.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        limparMensagensErro();

                        String entrada1 = campoEmailC.getText();
                        String entrada2 = Arrays.toString(campoSenhaC.getPassword());

                        Entrada entrada = new Entrada(entrada1, entrada2);
                        entrada.autenticarUsuario();
                    }
                    private void limparMensagensErro()
                    {
                        for (Component component : jPanelLogin.getComponents())
                        {
                            if (component instanceof JTextArea)
                            {
                                jPanelLogin.remove(component);
                            }
                        }
                        jPanelLogin.revalidate();
                        jPanelLogin.repaint();
                    }
                }
        );
        add(iniciar);

        ImageIcon backsy = new ImageIcon(getClass().getResource("/images/ilVoltar.png"));
        JButton voltarL = new JButton("Voltar",backsy);
        voltarL.setFont(new Font("SansSerif", Font.BOLD, 30));
        voltarL.setBackground(new Color(255, 255, 255));
        voltarL.setForeground(new Color(0x262626));
        voltarL.setHorizontalTextPosition(SwingConstants.RIGHT);
        voltarL.setVerticalTextPosition(SwingConstants.CENTER);
        voltarL.setHorizontalAlignment(SwingConstants.LEFT);
        voltarL.setVerticalAlignment(SwingConstants.CENTER);
        voltarL.setBounds(0, 0, 180, 50);
        voltarL.setBorderPainted(false);
        voltarL.setOpaque(false);
        voltarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaInicial.mostrarCard("cardInicio");
            }
        });
        add(voltarL);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/ilBLog800px.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        add(background);

        add(jPanelLogin);
    }
}
