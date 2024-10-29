package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import main.Confirmacao;
import main.Entrada;

public class TelaInicial extends javax.swing.JFrame {
    public TelaInicial() {
        initComponents();
        setTitle("PhotoEvent");
        setSize(800, 600);
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe48px.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanelInicial = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jPanelCadastro = new javax.swing.JPanel();

        // Definindo o layout do JFrame como CardLayout
        getContentPane().setLayout(new CardLayout());

        jPanelInicial.setLayout(null);
        jPanelInicial.setPreferredSize(new Dimension(800, 600));
        jPanelInicial.setBackground(new Color(255, 255, 255));
        jPanelInicial.setVisible(true);

        JTextArea iTitle = new JTextArea(4,16);
        iTitle.setText("PhotoEvent para:\nPrisma Fotografia");
        iTitle.setLineWrap(true); // Permite a quebra de linha
        iTitle.setWrapStyleWord(true); // Quebra a linha por palavras
        iTitle.setEditable(false); // O texto não será editável
        iTitle.setFocusable(false); // Remove o foco do componente do cursor
        iTitle.setFont(new Font("Verdana", Font.BOLD, 35));
        iTitle.setForeground(new Color(0x262626)); // Cor do texto
        iTitle.setOpaque(false); // Torna o fundo transparente
        iTitle.setBounds(420, 60, 700, 110); // x, y, largura, altura
        jPanelInicial.add(iTitle);

        JTextArea frase = new JTextArea(4, 10);
        frase.setText("Registre seus eventos e veja a listagem\nde clientes do seu negócio para manter\na organização");
        frase.setLineWrap(true);
        frase.setWrapStyleWord(true);
        frase.setEditable(false);
        frase.setFocusable(false);
        frase.setFont(new Font("Calibre", Font.PLAIN, 20));
        frase.setOpaque(false);
        frase.setBounds(420, 170, 700, 80);
        jPanelInicial.add(frase);

        ImageIcon imagem = new ImageIcon(getClass().getResource("/images/ilCanto.png"));
        JLabel ilustracao = new JLabel();
        ilustracao.setIcon(imagem);
        ilustracao.setHorizontalTextPosition(SwingConstants.CENTER);
        ilustracao.setVerticalTextPosition(SwingConstants.CENTER);
        ilustracao.setBounds(0, 0, 400, 600);
        ilustracao.setOpaque(false);
        jPanelInicial.add(ilustracao);

        JButton entrar = new JButton("Entrar");
        entrar.setBackground(new Color(0xD9D3C7));
        entrar.setFont(new Font("SansSerif", Font.BOLD, 20)); // NOI18N
        entrar.setForeground(new Color(0x262626));
        entrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0xD9D3C7), 4, true),
                javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        entrar.setPreferredSize(new Dimension(200, 50));
        entrar.setBounds(500, 330, 200, 50);
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "cardLogin");
            }
        });
        jPanelInicial.add(entrar);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setBackground(new Color(0xD9D3C7));
        cadastrar.setFont(new Font("SansSerif", Font.BOLD, 20)); // NOI18N
        cadastrar.setForeground(new Color(0x262626));
        cadastrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0xD9D3C7), 4, true),
                javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        cadastrar.setPreferredSize(new Dimension(200, 50));
        cadastrar.setBounds(500,430, 200, 50);
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "cardCadastro");
            }
        });
        jPanelInicial.add(cadastrar);

        //Adiciona os painéis ao cardLayout com identificadores
        getContentPane().add(jPanelInicial, "cardInicial");
        getContentPane().add(jPanelLogin, "cardLogin");
        getContentPane().add(jPanelCadastro, "cardCadastro");

        // propriedades do card ENTRAR
        getContentPane().add(jPanelLogin, "cardLogin");
        jPanelLogin.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanelLogin.setLayout(null);
        jPanelLogin.setBackground(new Color(255, 255, 255));

        ImageIcon ilEnt = new ImageIcon(getClass().getResource("/images/ilEntrada.png"));
        JLabel lTitle = new JLabel("Acessar conta");
        lTitle.setIcon(ilEnt);
        lTitle.setIconTextGap(140);
        lTitle.setFont(new Font("Arial", Font.BOLD, 48));
        lTitle.setForeground(new Color(0x262626)); // Cor do texto
        lTitle.setOpaque(false); // Torna o fundo transparente
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lTitle.setVerticalAlignment(SwingConstants.BOTTOM);
        lTitle.setHorizontalTextPosition(SwingConstants.LEFT);
        lTitle.setVerticalTextPosition(SwingConstants.CENTER);
        lTitle.setBounds(0,15,800,260);
        jPanelLogin.add(lTitle);

        JTextArea fraseL = new JTextArea(5, 25);
        fraseL.setFont(new java.awt.Font("Calibre", Font.PLAIN, 20));
        fraseL.setText("Bem vindo(a) de volta! Vamos começar?");
        fraseL.setBounds(20, 235, 370, 80);
        jPanelLogin.add(fraseL);

        JTextField campoEmailL = new JTextField();
        TitledBorder bordaEmail = BorderFactory.createTitledBorder("Email");
        bordaEmail.setTitleColor(new Color(0x262626));
        bordaEmail.setTitleFont(new Font("Arial", Font.PLAIN, 20));
        campoEmailL.setBorder(bordaEmail);
        campoEmailL.setFont(new Font("Arial",Font.PLAIN,18));
        campoEmailL.setBounds(40, 310, 300, 70);
        jPanelLogin.add(campoEmailL);

        JPasswordField campoSenhaL = new JPasswordField();
        TitledBorder bordaSenha = BorderFactory.createTitledBorder("Senha");
        bordaSenha.setTitleColor(new Color(0x262626));
        bordaSenha.setTitleFont(new Font("Arial", Font.PLAIN, 20));
        campoSenhaL.setBorder(bordaSenha);
        campoSenhaL.setFont(new Font("Arial",Font.PLAIN,18));
        campoSenhaL.setBounds(40, 420, 300, 70);
        jPanelLogin.add(campoSenhaL);

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
        voltarL.setOpaque(false);
        voltarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout cI = (CardLayout) getContentPane().getLayout();
                cI.show(getContentPane(), "cardInicial");
            }
        });
        jPanelLogin.add(voltarL);

        ImageIcon ss=new ImageIcon(getClass().getResource("/images/ilSmile48.png"));
        JButton iniciar=new JButton("Iniciar");
        iniciar.setIcon(ss);
        iniciar.setBackground(new Color(0xD9D3C7));
        iniciar.setFont(new Font("SansSerif", Font.BOLD, 20)); // NOI18N
        iniciar.setForeground(new Color(255, 255, 255));
        iniciar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iniciar.setVerticalTextPosition(SwingConstants.CENTER);
        iniciar.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0xD9D3C7), 4, true),
                javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        iniciar.setPreferredSize(new Dimension(200, 60));
        iniciar.setBounds(425,480, 265, 60);
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        iniciar.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String entrada0=campoEmailL.getText();
                        String entrada1=campoSenhaL.getText();
                        Entrada confirmacao0=new Entrada(entrada0,entrada1);
                    }
                }
        );
        jPanelLogin.add(iniciar);



        //propriedades do card CADASTRO
        getContentPane().add(jPanelCadastro, "cardCadastro");
        jPanelCadastro.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanelCadastro.setLayout(null);
        jPanelCadastro.setBackground(new Color(255, 255, 255));

        ImageIcon ilCAD = new ImageIcon(getClass().getResource("/images/ilCadastro.png"));
        JLabel cTitle = new JLabel("Cadastro");
        cTitle.setIcon(ilCAD);
        cTitle.setFont(new Font("Arial", Font.BOLD, 48));
        cTitle.setForeground(new Color(0x262626)); // Cor do texto
        cTitle.setOpaque(false); // Torna o fundo transparente
        cTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cTitle.setVerticalAlignment(SwingConstants.BOTTOM);
        cTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        cTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
        cTitle.setBounds(90,70,210,260);
        jPanelCadastro.add(cTitle);

        JTextArea fraseCa = new JTextArea(4, 20);
        fraseCa.setFont(new java.awt.Font("Calibre", Font.PLAIN, 18));
        fraseCa.setText("Para criar sua conta de funcionário,\nprecisaremos de algumas informações,\npor isso, preencha os campos ao lado\npara começar.");
        fraseCa.setEditable(false);
        fraseCa.setFocusable(false);
        fraseCa.setBounds(30, 330, 335, 100);
        jPanelCadastro.add(fraseCa);

        JTextArea fraseCb = new JTextArea(5, 20);
        fraseCb.setFont(new java.awt.Font("Calibre", Font.PLAIN, 18));
        fraseCb.setText("Por questões de segurança, sua senha\ndeve ter:\n- No mínimo 6 digitos\n- Pelo menos 1 letra e 1 número\nExemplo de senha: 1abc23");
        fraseCb.setEditable(false);
        fraseCb.setFocusable(false);
        fraseCb.setBounds(30, 446, 320, 100);
        jPanelCadastro.add(fraseCb);

        // Configuração dos campos de texto e senha
        JTextField campoEmailC = new JTextField();
        campoEmailC.setBorder(bordaEmail);
        campoEmailC.setFont(new Font("Arial",Font.PLAIN,18));
        campoEmailC.setBounds(390, 80, 350, 65); //145
        jPanelCadastro.add(campoEmailC);

        JPasswordField campoSenhaC = new JPasswordField();
        campoSenhaC.setBorder(bordaSenha);
        campoSenhaC.setFont(new Font("Arial",Font.PLAIN,18));
        campoSenhaC.setBounds(390, 185, 350, 65);//250
        jPanelCadastro.add(campoSenhaC);

        JPasswordField campoConfirmarSenha = new JPasswordField();
        TitledBorder bordaConfirmaSenha = BorderFactory.createTitledBorder("Confirmação de senha");
        bordaConfirmaSenha.setTitleColor(new Color(0x262626));
        bordaConfirmaSenha.setTitleFont(new Font("Arial", Font.PLAIN, 20));
        campoConfirmarSenha.setBorder(bordaConfirmaSenha);
        campoConfirmarSenha.setFont(new Font("Arial",Font.PLAIN,18));
        campoConfirmarSenha.setBounds(390, 290, 350, 65);
        jPanelCadastro.add(campoConfirmarSenha);

        JButton concluir=new JButton("Concluir cadastro");
        concluir.setIcon(ss);
        concluir.setBackground(new Color(0xD9D3C7));
        concluir.setFont(new Font("SansSerif", Font.BOLD, 20)); // NOI18N
        concluir.setForeground(new Color(255, 255, 255));
        concluir.setHorizontalTextPosition(SwingConstants.RIGHT);
        concluir.setVerticalTextPosition(SwingConstants.CENTER);
        concluir.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(0xD9D3C7), 4, true),
                javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        concluir.setPreferredSize(new Dimension(200, 60));
        concluir.setBounds(425,480, 265, 60);
        concluir.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String entrada2=campoEmailC.getText();
                        String entrada3=campoSenhaC.getText();
                        String entrada4=campoConfirmarSenha.getText();
                        Confirmacao confirmacao=new Confirmacao(entrada2,entrada3,entrada4,jPanelCadastro);
                        confirmacao.conferir();
                    }
                }
        );
        jPanelCadastro.add(concluir);

        JButton voltarC = new JButton("Voltar",backsy);
        voltarC.setFont(new Font("SansSerif", Font.BOLD, 30));
        voltarC.setBackground(new Color(255, 255, 255));
        voltarC.setForeground(new Color(0x262626));
        voltarC.setHorizontalTextPosition(SwingConstants.RIGHT);
        voltarC.setVerticalTextPosition(SwingConstants.CENTER);
        voltarC.setHorizontalAlignment(SwingConstants.LEFT);
        voltarC.setVerticalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(0, 0, 180, 50);
        voltarC.setOpaque(false);
        voltarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout cI = (CardLayout) getContentPane().getLayout();
                cI.show(getContentPane(), "cardInicial");
            }
        });
        jPanelCadastro.add(voltarC);


        pack();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

    }

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelInicial;
    private javax.swing.JPanel jPanelLogin;
}