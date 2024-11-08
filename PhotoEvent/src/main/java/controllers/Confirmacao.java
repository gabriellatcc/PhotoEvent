package controllers;

import database.BancoDeDados;
import view.TelaMenu;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Confirmacao {
    private String email;
    private String senha;
    private String senhaConfirmacao;

    public Confirmacao(String entrada1, String entrada2, String entrada3) {
        this.email = entrada1;
        this.senha = entrada2;
        this.senhaConfirmacao = entrada3;
    }

    public boolean emailJaCadastrado() {
        BancoDeDados banco = new BancoDeDados();
        return banco.emailJaCadastrado(email);
    }

    public boolean verificarSenhaCoincide() {

        return senha.equals(senhaConfirmacao);
    }

    public boolean conferirTamanho() {

        return senha.length() >= 6;
    }

    public boolean conferirDigitos() {
        boolean temLetra = false;
        boolean temNumero = false;

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (Character.isLetter(c)) temLetra = true;
            if (Character.isDigit(c)) temNumero = true;
            if (temLetra && temNumero) return true;
        }
        return false;
    }

    public boolean camposPreenchidos() {
        return !email.isEmpty() && !senha.isEmpty() && !senhaConfirmacao.isEmpty();
    }

    public void conferir() {
        // Verificação de e-mail
        if (emailJaCadastrado()) {
            JOptionPane.showMessageDialog(null, "O email já está cadastrado.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verificar se os campos estão preenchidos
        if (!camposPreenchidos()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Verificação de validade da senha
        if (!conferirTamanho() || !conferirDigitos()) {
            JTextArea aviso = new JTextArea(5, 20);
            aviso.setFont(new Font("Arial", Font.PLAIN, 14));
            aviso.setText("A senha deve ter no mínimo 6 dígitos, contendo pelo\nmenos 1 letra e 1 número.");
            aviso.setBackground(new Color(0xf0dddd));
            aviso.setForeground(new Color(0xb56262));
            aviso.setOpaque(true);
            aviso.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(0xb56262), 1, true),
                    BorderFactory.createEmptyBorder(1, 7, 1, 7)));
            aviso.setEditable(false);
            aviso.setFocusable(false);
            return;
        }

        // Verificando se as senhas coincidem
        if (!verificarSenhaCoincide()) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        BancoDeDados banco = new BancoDeDados();
        boolean cadastroRealizado = banco.cadastrarUsuario(email, senha);

        if (cadastroRealizado) {
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            TelaMenu tm = new TelaMenu();
            tm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
}