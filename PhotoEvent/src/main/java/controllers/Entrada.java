package controllers;

import view.TelaMenu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Entrada {
    private String email;
    private String senha;

    public Entrada(String entrada1, String entrada2) {
        this.email = entrada1;
        this.senha = entrada2;
    }

    public void autenticarUsuario() {
        BancoDeDados banco = new BancoDeDados();
        String senhaRegistrada = banco.getSenhaUsuario(email);

        if (senhaRegistrada == null) {
            exibirMensagemErro("O e-mail não está cadastrado.");
            return;
        }

        // Verifica se a senha fornecida corresponde à registrada
        if (!senhaRegistrada.equals(senha)) {
            exibirMensagemErro("Senha incorreta.");
            return;
        }

        // Se a autenticação for bem-sucedida
        JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
        TelaMenu tm = new TelaMenu();
        tm.setVisible(true);
    }

    private void exibirMensagemErro(String mensagem) {
        JTextArea aviso = new JTextArea(5, 20);
        aviso.setFont(new Font("Arial", Font.PLAIN, 14));
        aviso.setText(mensagem);
        aviso.setBackground(new Color(0xf0dddd));
        aviso.setForeground(new Color(0xb56262));
        aviso.setOpaque(true);
        aviso.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0xb56262), 1, true),
                BorderFactory.createEmptyBorder(1, 7, 1, 7)));
        aviso.setEditable(false);
        aviso.setFocusable(false);
        aviso.setBounds(390, 360, 350, 60);
    }
}
