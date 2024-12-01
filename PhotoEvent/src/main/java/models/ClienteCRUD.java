package models;

import com.mongodb.client.*;
import database.BancoDeDados;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {

    private MongoDatabase database;

    public ClienteCRUD() {
        this.database = new BancoDeDados().conectar();
    }
//
    public boolean inserirCliente(int id, String nome, String sobrenome, String cpf, String cnpj, String telefone, String servicosContratados) {
        try {
            MongoCollection<Document> collection = database.getCollection("Cliente");
            Document novoCliente = new Document("id", id)
                    .append("nome", nome)
                    .append("sobrenome", sobrenome)
                    .append("cpf", cpf)
                    .append("cnpj", cnpj)
                    .append("telefone", telefone)
                    .append("servicos_contratados", servicosContratados);
            collection.insertOne(novoCliente);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
        return false;
    }
    //read
    public Document buscarClientePorCpf(String cpf) {
        try {
            MongoCollection<Document> collection = database.getCollection("Cliente");
            Document query = new Document("cpf", cpf);  // Filtra pelo CPF
            return collection.find(query).first();  // Retorna o primeiro cliente encontrado
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }
    //read
    public List<Document> buscarTodosClientes() {
        List<Document> clientes = new ArrayList<>();
        try {
            MongoCollection<Document> collection = database.getCollection("Cliente");
            FindIterable<Document> resultado = collection.find();
            for (Document doc : resultado) {
                clientes.add(doc);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar todos os clientes: " + e.getMessage());
        }
        return clientes;
    }
//update
    public boolean atualizarCliente(int id, String nome, String sobrenome, String cpf, String cnpj, String telefone, String servicosContratados) {
        try {
            MongoCollection<Document> collection = database.getCollection("Cliente");
            Document query = new Document("cpf", cpf);
            Document update = new Document("$set", new Document("id", id)
                    .append("nome", nome)
                    .append("sobrenome", sobrenome)
                    .append("cnpj", cnpj)
                    .append("telefone", telefone)
                    .append("servicos_contratados", servicosContratados));
            collection.updateOne(query, update);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
        return false;
    }
//delete
    public boolean deletarCliente(String cpf) {
        try {
            MongoCollection<Document> collection = database.getCollection("Cliente");
            Document query = new Document("cpf", cpf);
            collection.deleteOne(query);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
        return false;
    }
}