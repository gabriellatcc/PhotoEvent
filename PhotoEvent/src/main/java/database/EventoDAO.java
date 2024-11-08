package database;

import org.bson.Document;

public class Evento {
    private int id;
    private String titulo;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String tipo;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private double duracao;
    private double tempoEstimadoEdicao;

    // Construtor
    public Evento(int id, String titulo, String nomeCliente, String sobrenomeCliente, String tipo, String cidade, String bairro, String rua, int numero, double duracao, double tempoEstimadoEdicao) {
        this.id = id;
        this.titulo = titulo;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.tipo = tipo;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.duracao = duracao;
        this.tempoEstimadoEdicao = tempoEstimadoEdicao;
    }

    public Document toDocument() {
        return new Document("id", id)
                .append("titulo", titulo)
                .append("nome_cliente", nomeCliente)
                .append("sobrenome_cliente", sobrenomeCliente)
                .append("tipo", tipo)
                .append("cidade", cidade)
                .append("bairro", bairro)
                .append("rua", rua)
                .append("numero", numero)
                .append("duracao", duracao)
                .append("tempo_estimado_edicao", tempoEstimadoEdicao);
    }
}