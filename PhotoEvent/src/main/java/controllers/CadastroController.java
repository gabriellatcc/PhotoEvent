package controllers;

import models.UsuarioCRUD;

import javax.swing.*;
import java.awt.*;

public class CadastroController {
    private String nome, sobrenome, email, senha, confirmacaoSenha, cargoSelecionado;
    private JPanel tc;

    public CadastroController(String nome, String sobrenome, String email, String senha, String confirmacaoSenha, String cargoSelecionado, JPanel jPanelCadastro) {
        this.nome=nome;
        this.sobrenome=sobrenome;
        this.email=email;
        this.senha=senha;
        this.confirmacaoSenha=confirmacaoSenha;
        this.cargoSelecionado=cargoSelecionado;
        this.tc=jPanelCadastro;
    }

    public void executar() {
        conferir();
    }

    public boolean emailJaCadastrado()
    {
        UsuarioCRUD banco = new UsuarioCRUD();
        return banco.emailJaCadastrado(email);
    }

    public boolean verificarSenhaCoincide()
    {
        return senha.equals(confirmacaoSenha);
    }

    public boolean conferirTamanho()
    {
        return senha.length() >= 8;
    }

    public boolean conferirDigitos()
    {
        boolean temLetra = false;
        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++)
        {
            char c = senha.charAt(i);
            if (Character.isLetter(c)) temLetra = true;
            if (Character.isDigit(c)) temNumero = true;
            if (temLetra && temNumero) return true;
        }
        return false;
    }

    public boolean camposPreenchidos()
    {
        return !nome.isEmpty() && !sobrenome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !confirmacaoSenha.isEmpty() && !cargoSelecionado.isEmpty() ;
    }

    public boolean conferirEmail(String email)
    {
        String[] dominiosPermitidos = { "gmail.com", "outlook.com", "hotmail.com", "yahoo.com" };
        if (!email.contains("@"))
        {
            return false;
        }
        String dominio = email.substring(email.indexOf("@") + 1);
        for (String dominioPermitido : dominiosPermitidos)
        {
            if (dominio.equalsIgnoreCase(dominioPermitido))
            {
                return true;
            }
        }
        return false;
    }

    public void conferir() {
        if (emailJaCadastrado()) {
            System.out.println("Usuário inseriu um email já cadastrado.");
            adicionarAviso("O email já está cadastrado", 400);
            return;
        }

        if (!camposPreenchidos()) {
            System.out.println("Usuário não preencheu todos os campos.");
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!conferirEmail(email)) {
            System.out.println("Usuário inseriu um email com domínio inválido.");
            adicionarAviso("Domínio de email inválido.", 400);
            return;
        }

        if (!conferirTamanho() || !conferirDigitos()) {
            System.out.println("Usuário inseriu uma senha fora do padrão estabelecido.");
            adicionarAviso("A senha deve ter no mínimo 6 dígitos, contendo pelo menos 1 letra e 1 número.", 482);
            return;
        }

        if (!verificarSenhaCoincide()) {
            System.out.println("Usuário inseriu uma senha diferente da do campo de confirmação de senha.");
            adicionarAviso("As senhas devem coincidir.", 563);
            return;
        }

        UsuarioCRUD banco = new UsuarioCRUD();
        boolean sucesso = banco.cadastrarUsuario(nome, sobrenome, email, senha, cargoSelecionado);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Solicitação enviada com sucesso! Aguarde a aprovação do administrador.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Usuário cadastrado com sucesso no banco de dados.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuário. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao cadastrar o usuário no banco de dados.");
        }
    }

    private void adicionarAviso(String mensagem, int yPosition) {
        JLabel aviso = new JLabel();
        aviso.setFont(new Font("Calibre", Font.PLAIN, 15));
        aviso.setText(mensagem);
        aviso.setForeground(new Color(0xb56262));
        aviso.setOpaque(false);
        aviso.setFocusable(false);
        aviso.setAlignmentX(Component.RIGHT_ALIGNMENT);
        aviso.setBounds(390, yPosition, 350, 24);
        tc.revalidate();
        tc.repaint();
        tc.add(aviso);
    }
}