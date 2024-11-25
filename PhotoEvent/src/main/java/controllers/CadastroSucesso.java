package controllers;

import models.UsuarioCRUD;

public class CadastroSucesso {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cargo;

    public CadastroSucesso(String nome, String sobrenome, String email, String senha, String cargo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public boolean registrarUsuario() {
        UsuarioCRUD banco = new UsuarioCRUD();
        boolean cadastroRealizado = banco.cadastrarUsuario(nome, sobrenome, email, senha, cargo);
        if (cadastroRealizado) {
            System.out.println("Usuário cadastrado com sucesso no banco de dados!");
        } else {
            System.out.println("Erro ao tentar cadastrar o usuário.");
        }
        return cadastroRealizado;
    }
}