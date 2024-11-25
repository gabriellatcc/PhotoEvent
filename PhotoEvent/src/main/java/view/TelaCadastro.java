package view;

import controllers.CadastroController;
import controllers.BordaPadraoController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class TelaCadastro extends JPanel {
    private TelaInicial telaInicial;
    private JPanel jPanelCadastro;
    private String nome, sobrenome, email, senha, confirmacaoSenha,cargoSelecionado;
    public TelaCadastro(TelaInicial telaInicial)
    {
        this.telaInicial = telaInicial;
        setLayout(null);
        initComponents();
    }
    private void initComponents()
    {
        jPanelCadastro = new JPanel(null);
        jPanelCadastro.setBounds(0, 0, 1535, 1080);

        JLabel title = new JLabel("Cadastro");
        title.setFont(new Font("Open Sans", Font.BOLD, 52));
        title.setForeground(new Color(0x0cadee));
        title.setOpaque(false);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setBounds(862,208,286,76);
        jPanelCadastro.add(title);

        JLabel fraseCa = new JLabel("<html><div style='text-align: justify;'>Preencha os campos ao lado para solicitar sua conta de funcionário. Seus dados serão enviados ao administrador e não divulgados ou compartilhados.</div></html>");
        fraseCa.setFont(new Font("Open Sans", Font.PLAIN, 20));
        fraseCa.setFocusable(false);
        fraseCa.setForeground(new Color(0x393536));
        fraseCa.setBounds(846, 315, 320, 135);
        jPanelCadastro.add(fraseCa);

        JTextArea fraseCb= new JTextArea(6,25);
        fraseCb.setText("Por questões de segurança, sua senha\n" +
                "deve ter:\n" +
                "- No mínimo 8 digitos\n" +
                "- Pelo menos 1 letra e 1 número\n" +
                "Exemplo de senha: 1abc2345");
        fraseCb.setFont(new Font("Open Sans", Font.PLAIN, 18));
        fraseCb.setFocusable(false);
        fraseCb.setEditable(false);
        fraseCb.setOpaque(false);
        fraseCb.setForeground(new Color(0x393536));
        fraseCb.setBounds(843, 484, 370, 130);
        jPanelCadastro.add(fraseCb);

        BordaPadraoController bordaPadraoController =new BordaPadraoController(10);
        TitledBorder bordaNome = new TitledBorder(
                bordaPadraoController,
                "Nome",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaNome.setTitleFont(new Font("Calibre", Font.PLAIN, 18));
        JTextField campoNome = new JTextField();
        campoNome.setBorder(bordaNome);
        campoNome.setOpaque(false);
        campoNome.setFont(new Font("Arial",Font.PLAIN,17));
        campoNome.setBounds(389, 186, 350, 54);
        jPanelCadastro.add(campoNome);

        TitledBorder bordaSobrenome = new TitledBorder(
                bordaPadraoController,
                "Sobrenome",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
            bordaSobrenome.setTitleFont(new Font("Calibre", Font.PLAIN, 18));
        JTextField campoSobrenome = new JTextField();
        campoSobrenome.setBorder(bordaSobrenome);
        campoSobrenome.setOpaque(false);
        campoSobrenome.setFont(new Font("Arial",Font.PLAIN,17));
        campoSobrenome.setBounds(389, 266, 350, 54);
        campoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    campoSobrenome.requestFocus();
                }
            }
        });

        TitledBorder bordaEmail = new TitledBorder(
                bordaPadraoController,
                "Email",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaEmail.setTitleFont(new Font("Calibre", Font.PLAIN, 18));
        JTextField campoEmail = new JTextField();
        campoEmail.setBorder(bordaEmail);
        campoEmail.setOpaque(false);
        campoEmail.setFont(new Font("Arial",Font.PLAIN,17));
        campoEmail.setBounds(389, 346, 350, 54);
        campoSobrenome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    campoEmail.requestFocus();
                }
            }
        });

        TitledBorder bordaSenha = new TitledBorder(
                bordaPadraoController,
                "Senha",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaSenha.setTitleFont(new Font("Calibre", Font.PLAIN, 18));
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBorder(bordaSenha);
        campoSenha.setOpaque(false);
        campoSenha.setFont(new Font("Arial",Font.PLAIN,17));
        campoSenha.setBounds(389, 427, 350, 54);
        campoEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    campoSenha.requestFocus();
                }
            }
        });

        TitledBorder bordaConfirmaSenha = new TitledBorder(
                bordaPadraoController,
                "Confirme a senha",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        bordaConfirmaSenha.setTitleFont(new Font("Calibre", Font.PLAIN, 18));
        JPasswordField campoConfirmarSenha = new JPasswordField();
        campoConfirmarSenha.setBorder(bordaConfirmaSenha);
        campoConfirmarSenha.setOpaque(false);
        campoConfirmarSenha.setFont(new Font("Arial",Font.PLAIN,17));
        campoConfirmarSenha.setBounds(389, 508, 350, 54);
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    campoConfirmarSenha.requestFocus();
                }
            }
        });

        String[] cargos = {"Assistente geral","Fotógrafo", "Videomaker", "Editor de Fotos", "Editor de Vídeos"};
        JComboBox<String> comboBox = new JComboBox<>(cargos);
        comboBox.setBorder(bordaPadraoController);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI());
        comboBox.setBounds(389,590,350,50);
        campoConfirmarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    comboBox.requestFocus();
                }
            }
        });

        JButton solicitar = new JButton("Solicitar entrada");
        solicitar.setBackground(new Color(255,255,255));
        solicitar.setFont(new Font("Calibre", Font.PLAIN, 20));
        solicitar.setForeground(new Color(0x393536));
        solicitar.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 7, 7, 7)
        ));
        solicitar.setPreferredSize(new Dimension(200, 50));
        solicitar.setBounds(435, 652, 250, 60);
        solicitar.addActionListener(
                new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        nome = campoNome.getText();
                        sobrenome = campoSobrenome.getText();
                        email = campoEmail.getText();
                        senha = Arrays.toString(campoSenha.getPassword());
                        confirmacaoSenha = Arrays.toString(campoConfirmarSenha.getPassword());
                        cargoSelecionado =  (String) comboBox.getSelectedItem();
                        CadastroController CadastroController = new CadastroController(nome, sobrenome, email, senha, confirmacaoSenha,cargoSelecionado, jPanelCadastro);
                        CadastroController.executar();
                    }
                }
        );
        comboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    solicitar.doClick();
                }
            }
        });
        jPanelCadastro.add(campoSobrenome);
        jPanelCadastro.add(campoEmail);
        jPanelCadastro.add(campoSenha);
        jPanelCadastro.add(campoConfirmarSenha);
        jPanelCadastro.add(comboBox);
        jPanelCadastro.add(solicitar);

        JButton voltarC = new JButton("⬅");
        voltarC.setForeground(new Color(0x393536));
        voltarC.setBackground(new Color(0xffffff));
        voltarC.setFocusable(false);
        voltarC.setFocusPainted(false);
        voltarC.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        voltarC.setFont(new Font("Calibre", Font.BOLD, 35));
        voltarC.setHorizontalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(349, 126, 70, 55);
        voltarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaInicial.mostrarCard("cardInicio");
                campoNome.setText("");
                campoSobrenome.setText("");
                campoEmail.setText("");
                campoSenha.setText("");
                campoConfirmarSenha.setText("");
            }
        });
        jPanelCadastro.add(voltarC);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/telaCadastro.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        jPanelCadastro.add(background);
        add(jPanelCadastro);
    }
}