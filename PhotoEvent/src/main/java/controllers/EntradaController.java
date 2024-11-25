package controllers;

import models.UsuarioCRUD;

import javax.swing.*;
import java.awt.*;

public class EntradaController {
    private String email;
    private String senha;
    private JPanel ti;

    public EntradaController(String email, String senha, JPanel TelaInicial) {
        this.email = email;
        this.senha = senha;
        this.ti = TelaInicial;
    }

    public boolean camposPreenchidos() {
        return !email.isEmpty() && !senha.isEmpty();
    }

    public void conferir() {
        if (!camposPreenchidos()) {
            System.out.println("Usuário não preencheu todos os campos.");
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioCRUD banco = new UsuarioCRUD();
        String emailRegistrado = banco.getEmailUsuario(email);
        String senhaRegistrada=banco.getSenhaUsuario(senha);

        if (emailRegistrado == null) {
            System.out.println("Usuário inseriu um e-mail não cadastrado.");
            adicionarAviso("O e-mail não está cadastrado.",380);
            return;
        }

        if (senhaRegistrada != null) {
            System.out.println("Usuário inseriu uma senha incorreta.");
            adicionarAviso("Senha incorreta.", 461);
            return;
        }

        JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
        TelasController telasController = new TelasController(email);
        telasController.abrirMenu();

        Window window = SwingUtilities.getWindowAncestor(ti);
        if (window instanceof JFrame) {
            ((JFrame) window).dispose();
        }
        limparMensagensErro();
    }
    private void adicionarAviso(String mensagem, int yPosition) {
        JLabel aviso = new JLabel();
        aviso.setFont(new Font("Calibre", Font.PLAIN, 15));
        aviso.setText(mensagem);
        aviso.setForeground(new Color(0xb56262));
        aviso.setOpaque(false);
        aviso.setFocusable(false);
        aviso.setAlignmentX(Component.RIGHT_ALIGNMENT);
        aviso.setBounds(827, yPosition, 350, 24);
        ti.add(aviso);
        ti.setComponentZOrder(aviso, 0);
        ti.revalidate();
        ti.repaint();
    }

    public void limparMensagensErro() {
        for (Component component : ti.getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                if ("Senha incorreta.".equals(label.getText()) || "O e-mail não está cadastrado.".equals(label.getText())) {
                    ti.remove(label);
                }
            }
        }
        ti.revalidate();
        ti.repaint();
    }
    public void executar() {
        conferir();
    }
}