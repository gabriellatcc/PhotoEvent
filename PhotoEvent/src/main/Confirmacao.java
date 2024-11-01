package main;

import view.TelaMenu;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Confirmacao {
    private JPanel jPanelCadastro;
    private String email;
    private String senha;
    private String senhaConfirmacao;
    private boolean resposta0;
    private boolean resposta1;
    private boolean resposta2;
    private boolean resposta3;
    private JFrame parentFrame;

    public Confirmacao(String entrada2, String entrada3, String entrada4, JPanel jPanelCadastro, JFrame parentFrame)
    {
        this.senha = entrada2;
        this.senhaConfirmacao = entrada3;
        this.email = entrada4;
        this.jPanelCadastro = jPanelCadastro;
        this.parentFrame = parentFrame;
    }

    public boolean verificarSenhaCoincide()
    {
        int m = 0;
        for (int j = 0; j < senha.length(); j++) {
            if (senha.charAt(j) == senhaConfirmacao.charAt(j)) {
                m++;
            }
        }
        resposta3 = m == senha.length();
        return resposta3;
    }

    public boolean conferirTamanho()
    {
        if(senha.length()>=6)
        {
            resposta0=true;
        }
        return resposta0;
    }

    public boolean conferirDigitos()
    {
        boolean temLetra = false;
        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++)
        {
            char c = senha.charAt(i);
            if (Character.isLetter(c))
            {
                temLetra = true;
            } else if (Character.isDigit(c))
            {
                temNumero = true;
            }
            if (temLetra && temNumero)
            {
                resposta2=true;
            }
        }
        return resposta2;
    }

    public boolean conferirPresenca()
    {
        if(!email.isEmpty()||!senha.isEmpty()||!senhaConfirmacao.isEmpty())
        {
            resposta1=true;
        }
        return resposta1;
    }

    public void conferir()
    {
        boolean camposPreenchidos = conferirPresenca();
        boolean senhaValida = conferirDigitos() && conferirTamanho();
        boolean senhaIgual= verificarSenhaCoincide();
        if (!camposPreenchidos)
        {
            JOptionPane.showMessageDialog(jPanelCadastro, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
        if (!senhaValida)
        {
            JTextArea aviso = new JTextArea(5, 20);
            aviso.setFont(new Font("Arial", Font.PLAIN, 14));
            aviso.setText("A senha deve no mínimo 6 dígitos, contendo pelo\nmenos 1 letra e 1 número\nAs senhas devem coincidir também.");
            aviso.setBackground(new Color(0xf0dddd));
            aviso.setForeground(new Color(0xb56262));
            aviso.setOpaque(true);
            aviso.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(0xb56262), 1, true),
                    BorderFactory.createEmptyBorder(1, 7, 1, 7)));
            aviso.setEditable(false);
            aviso.setFocusable(false);
            aviso.setBounds(390, 360, 350, 60);
            jPanelCadastro.add(aviso);
            jPanelCadastro.revalidate();
            jPanelCadastro.repaint();
        }
        if
        (!senhaIgual)
        {
            JOptionPane.showMessageDialog(jPanelCadastro, "As senhas não coincidem.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            parentFrame.dispose();
            TelaMenu tm = new TelaMenu();
            tm.setVisible(true);
        }
    }
}