package main;

import view.TelaMenu;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Confirmacao {
    private String senha;
    private String senhaConfirmacao;
    private String email;
    private JPanel jPanelCadastro;
    private boolean resposta1;
    private boolean resposta2;
    private boolean resposta3;

    public Confirmacao(String entrada2, String entrada3, String entrada4, JPanel jPanelCadastro) {
        this.senha = entrada2;
        this.senhaConfirmacao = entrada3;
        this.email = entrada4;
        this.jPanelCadastro = jPanelCadastro;
    }

    public boolean verificarSenhaCoincide()
    {
        resposta3=false;
        if (senhaConfirmacao.equals(senha))
        {
            resposta3=true;
        }
        return resposta3;
    }
    public boolean conferirTamanho()
    {
        resposta1=false;
        if (email.isEmpty())
        {
            JOptionPane.showMessageDialog(jPanelCadastro, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            JTextField campoEmailC = new JTextField();
            TitledBorder bordaEmail = BorderFactory.createTitledBorder("Email");
            campoEmailC.setBorder(bordaEmail);
            bordaEmail.setTitleColor(new Color(255,0,0));
            bordaEmail.setTitleFont(new Font("Arial", Font.PLAIN, 20));
            campoEmailC.setFont(new Font("Arial",Font.PLAIN,18));
            campoEmailC.setBounds(390, 80, 350, 65); //145

            jPanelCadastro.add(campoEmailC);
        }
        else if(senha.isEmpty())
        {
            JOptionPane.showMessageDialog(jPanelCadastro, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            resposta1=false;
            TitledBorder bordaSenha = BorderFactory.createTitledBorder("Senha");
            bordaSenha.setTitleColor(new Color(255,0,0));
            bordaSenha.setTitleFont(new Font("Arial", Font.PLAIN, 20));
            JPasswordField campoSenhaC = new JPasswordField();
            campoSenhaC.setBorder(bordaSenha);
            campoSenhaC.setFont(new Font("Arial",Font.PLAIN,18));
            campoSenhaC.setBounds(390, 185, 350, 65);
            jPanelCadastro.add(campoSenhaC);
        }
        else if(senhaConfirmacao.isEmpty())
        {
            JOptionPane.showMessageDialog(jPanelCadastro, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            resposta1=false;
            JPasswordField campoConfirmarSenha = new JPasswordField();
            TitledBorder bordaConfirmaSenha = BorderFactory.createTitledBorder("Confirmação de senha");
            bordaConfirmaSenha.setTitleColor(new Color(255,0,0));
            bordaConfirmaSenha.setTitleFont(new Font("Arial", Font.PLAIN, 20));
            campoConfirmarSenha.setBorder(bordaConfirmaSenha);
            campoConfirmarSenha.setFont(new Font("Arial",Font.PLAIN,18));
            campoConfirmarSenha.setBounds(390, 290, 350, 65);
            jPanelCadastro.add(campoConfirmarSenha);
        }
        else if(email.isEmpty()||senha.isEmpty()||senhaConfirmacao.isEmpty())
        {
            JOptionPane.showMessageDialog(jPanelCadastro, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            resposta1=false;
        }
        else
        {
            resposta1=true;
        }
        return resposta1;
    }

    public boolean conferirDigitos()
    {
        resposta2=false;
        for(int i=0; i<senha.length();i++)
        {
            char c = senha.charAt(i);
            switch (c)
            {
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i': case 'j':
                case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't':
                case 'u': case 'v': case 'w': case 'x': case 'y': case 'z':
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                    return resposta2=true;
                default:
                    return resposta2=false;
            }
        }
        return resposta2;
    }

    public void conferir() {
        if(!conferirTamanho() && !conferirDigitos())
        {
            JLabel aviso0 = new JLabel("A senha deve ter 6 dígidos, pelo menos 1 letra e número");
            aviso0.setFont(new Font("Arial", Font.PLAIN, 14));
            aviso0.setBackground(new Color(0xf0dddd));
            aviso0.setForeground(new Color(0xb56262));
            aviso0.setHorizontalAlignment(SwingConstants.CENTER);
            aviso0.setBorder(new javax.swing.border.LineBorder(new Color(0xb56262), 1, true));
            aviso0.setOpaque(true);
            aviso0.setBounds(390, 360, 350, 40);
            jPanelCadastro.revalidate();
            jPanelCadastro.repaint();
            jPanelCadastro.add(aviso0);
        }
        if(!verificarSenhaCoincide())
        {
            JLabel aviso = new JLabel("As senhas não coincidem.");
            aviso.setFont(new Font("Arial", Font.PLAIN, 14));
            aviso.setBackground(new Color(0xf0dddd));
            aviso.setForeground(new Color(0xb56262));
            aviso.setHorizontalAlignment(SwingConstants.CENTER);
            aviso.setBorder(new javax.swing.border.LineBorder(new Color(0xb56262), 1, true));
            aviso.setOpaque(true);
            aviso.setBounds(390, 360, 350, 40);
            jPanelCadastro.revalidate();
            jPanelCadastro.repaint();
            jPanelCadastro.add(aviso);
        }
        else
        {
            TelaMenu frame = new TelaMenu();
            frame.setLocationRelativeTo(null);
            frame.setExtendedState(JFrame.ICONIFIED);
            frame.setVisible(true);
        }
    }
}