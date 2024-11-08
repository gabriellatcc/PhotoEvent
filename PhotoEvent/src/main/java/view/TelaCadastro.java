package view;

import controllers.Confirmacao;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Arrays;

public class TelaCadastro extends JPanel {
    private TelaInicial telaInicial;
    public TelaCadastro(TelaInicial telaInicial)
    {
        this.telaInicial = telaInicial;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        JPanel jPanelCadastro = new JPanel();

        //propriedades do card CADASTRO
        jPanelCadastro.setPreferredSize(new Dimension(800, 600));
        jPanelCadastro.setLayout(null);
        jPanelCadastro.setBackground(new Color(255, 255, 255));

        JLabel cTitle = new JLabel("Cadastro");
        cTitle.setFont(new Font("Open Sans", Font.BOLD, 48));
        cTitle.setForeground(new Color(0x262626));
        cTitle.setOpaque(false);
        cTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cTitle.setVerticalAlignment(SwingConstants.CENTER);
        cTitle.setBounds(55,270,286,76);
        add(cTitle);

        JTextArea fraseCa = new JTextArea(4, 20);
        fraseCa.setFont(new Font("Calibre", Font.PLAIN, 18));
        fraseCa.setText("Para criar sua conta de funcionário,\nprecisaremos de algumas informações,\npor isso, preencha os campos ao lado\npara começar.");
        fraseCa.setEditable(false);
        fraseCa.setFocusable(false);
        fraseCa.setBounds(30, 335, 335, 100);
        add(fraseCa);

        JTextArea fraseCb = new JTextArea(5, 20);
        fraseCb.setFont(new Font("Calibre", Font.PLAIN, 14));
        fraseCb.setText("Por questões de segurança, sua senha deve ter:\n- No mínimo 6 digitos\n- Pelo menos 1 letra e 1 número\nExemplo de senha: 1abc23");
        fraseCb.setEditable(false);
        fraseCb.setFocusable(false);
        fraseCb.setBounds(30, 446, 320, 100);
        add(fraseCb);

        // Configuração dos campos de texto e senha
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
        campoEmailC.setBounds(420, 97, 350, 65);
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
        campoSenhaC.setBounds(420, 218, 350, 65);
        add(campoSenhaC);

        TitledBorder bordaConfirmaSenha = new TitledBorder(
                new LineBorder(Color.decode("#262626"), 1),
                "Confirme a senha",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaConfirmaSenha.setTitleFont(new Font("Calibre", Font.BOLD, 20));
        JPasswordField campoConfirmarSenha = new JPasswordField();
        campoConfirmarSenha.setBorder(bordaConfirmaSenha);
        campoConfirmarSenha.setOpaque(false);
        campoConfirmarSenha.setFont(new Font("Arial",Font.PLAIN,18));
        campoConfirmarSenha.setBounds(420, 339, 350, 65);
        add(campoConfirmarSenha);

        JButton concluir=new JButton("Concluir cadastro");
        concluir.setBackground(Color.WHITE);
        concluir.setFont(new Font("Calibre", Font.BOLD, 23));
        concluir.setForeground(new Color(0x262626));
        concluir.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0x262626), 2, true),
                BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        concluir.setPreferredSize(new Dimension(200, 50));
        concluir.setBounds(475,480, 250, 60);
        concluir.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        limparMensagensErro();

                        String entrada1 = campoEmailC.getText();
                        String entrada2 = Arrays.toString(campoSenhaC.getPassword());
                        String entrada3 = Arrays.toString(campoConfirmarSenha.getPassword());

                        Confirmacao confirmacao = new Confirmacao(entrada1, entrada2, entrada3);
                        confirmacao.conferir();
                    }
                    private void limparMensagensErro()
                    {
                        for (Component component : jPanelCadastro.getComponents())
                        {
                            if (component instanceof JTextArea)
                            {
                                jPanelCadastro.remove(component);
                            }
                        }
                        jPanelCadastro.revalidate();
                        jPanelCadastro.repaint();
                    }
                }
        );
        add(concluir);

        ImageIcon backsy = new ImageIcon(getClass().getResource("/images/ilVoltar.png"));
        JButton voltarC = new JButton("Voltar",backsy);
        voltarC.setFont(new Font("SansSerif", Font.BOLD, 30));
        voltarC.setBackground(new Color(255, 255, 255));
        voltarC.setForeground(new Color(0x262626));
        voltarC.setHorizontalTextPosition(SwingConstants.RIGHT);
        voltarC.setVerticalTextPosition(SwingConstants.CENTER);
        voltarC.setHorizontalAlignment(SwingConstants.LEFT);
        voltarC.setVerticalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(0, 0, 180, 50);
        voltarC.setBorderPainted(false);
        voltarC.setOpaque(false);
        voltarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaInicial.mostrarCard("cardInicio");
                campoEmailC.setText("");
                campoSenhaC.setText("");
                campoConfirmarSenha.setText("");
            }
        });
        add(voltarC);


        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/ilBGCad800px.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        add(background);

        add(jPanelCadastro);
    }
}
