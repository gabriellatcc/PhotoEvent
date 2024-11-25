package models;

import com.mongodb.client.*;
import database.BancoDeDados;
import org.bson.Document;

public class EventoCRUD {

    private MongoDatabase database;

    public EventoCRUD() {
        this.database = new BancoDeDados().conectar();
    }
    public boolean inserirEvento(int id, String titulo, String nomeCliente, String sobrenomeCliente, String tipo, String endereco, double duracao, double tempoEstimadoEdicao) {
        try {
            MongoCollection<Document> collection = database.getCollection("Evento");
            Document novoEvento = new Document("id", id)
                    .append("titulo", titulo)
                    .append("nome_cliente", nomeCliente)
                    .append("sobrenome_cliente", sobrenomeCliente)
                    .append("tipo", tipo)
                    .append("endereco", endereco)
                    .append("duracao", duracao)
                    .append("tempo_estimado_edicao", tempoEstimadoEdicao);

            collection.insertOne(novoEvento);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir evento: " + e.getMessage());
        }
        return false;
    }
    public Document buscarEventoPorTitulo(String titulo) {
        try {
            MongoCollection<Document> collection = database.getCollection("Evento");
            Document query = new Document("titulo", titulo);
            return collection.find(query).first();
        } catch (Exception e) {
            System.out.println("Erro ao buscar evento: " + e.getMessage());
        }
        return null;
    }
    public boolean atualizarEvento(int id, String titulo, String nomeCliente, String sobrenomeCliente, String tipo,
                                   String endereco, double duracao, double tempoEstimadoEdicao) {
        try {
            MongoCollection<Document> collection = database.getCollection("Evento");
            Document query = new Document("id", id);
            Document update = new Document("$set", new Document("titulo", titulo)
                    .append("nome_cliente", nomeCliente)
                    .append("sobrenome_cliente", sobrenomeCliente)
                    .append("tipo", tipo)
                    .append("endereco", endereco)
                    .append("duracao", duracao)
                    .append("tempo_estimado_edicao", tempoEstimadoEdicao));
            collection.updateOne(query, update);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar evento: " + e.getMessage());
        }
        return false;
    }

    public boolean deletarEvento(int id) {
        try {
            MongoCollection<Document> collection = database.getCollection("Evento");
            Document query = new Document("id", id);
            collection.deleteOne(query);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar evento: " + e.getMessage());
        }
        return false;
    }
}