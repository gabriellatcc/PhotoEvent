package database;

import org.bson.Document;

public class ClienteDAO {
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String cnpj;
    private String telefone;
    private String servicosContratados;

    // Construtor
    public ClienteDAO(int id, String nome, String sobrenome, String cpf, String cnpj, String telefone, String servicosContratados) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.servicosContratados = servicosContratados;
    }

    // Conversão para Document do MongoDB
    public Document toDocument()
    {
        return new Document("id", id)
                .append("nome", nome)
                .append("sobrenome", sobrenome)
                .append("cpf", cpf)
                .append("cnpj", cnpj)
                .append("telefone", telefone)
                .append("servicos_contratados", servicosContratados);
    }
}