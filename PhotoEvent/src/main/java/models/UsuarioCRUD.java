package models;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import database.BancoDeDados;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class UsuarioCRUD {
    private MongoDatabase database;

    public UsuarioCRUD() {
        this.database = new BancoDeDados().conectar();
    }

    // Create
    public boolean cadastrarUsuario(String nome, String sobrenome, String email, String senha, String cargo) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            Document novoUsuario = new Document()
                    .append("nome", nome)
                    .append("sobrenome", sobrenome)
                    .append("email", email)
                    .append("senha", senha)
                    .append("cargo", cargo)
                    .append("status", "pendente");
            collection.insertOne(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
        return false;
    }

    //read
    public String getStatusUsuario(String email) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            Document query = new Document("email", email);
            Document usuario = collection.find(query).first();
            if (usuario != null) {
                return usuario.getString("status");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar status do usuário: " + e.getMessage());
        }
        return null;
    }

    // Read
    public boolean emailJaCadastrado(String email) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            Document query = new Document("email", email);
            long count = collection.countDocuments(query);
            return count > 0;
        } catch (Exception e) {
            System.out.println("Erro ao verificar email: " + e.getMessage());
        }
        return false;
    }

    // Read
    public String getSenhaUsuario(String email) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            Document query = new Document("email", email);
            Document usuario = collection.find(query).first();

            if (usuario != null) {
                return usuario.getString("senha");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar senha: " + e.getMessage());
        }
        return null;
    }

    // Read
    public String getEmailUsuario(String email) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            Document query = new Document("email", email);
            Document usuario = collection.find(query).first();

            if (usuario != null) {
                return usuario.getString("email");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar email: " + e.getMessage());
        }
        return null;
    }

    // Read
    public String getCargoUsuario(String email) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            Document query = new Document("email", email);
            Document usuario = collection.find(query).first();
            if (usuario != null) {
                return usuario.getString("cargo");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar cargo: " + e.getMessage());
        }
        return null;
    }

    // Read
    public List<Document> obterSolicitacoesPendentes() {
        List<Document> solicitacoes = new ArrayList<>();
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            FindIterable<Document> documentos = collection.find(Filters.eq("status", "pendente"));
            for (Document doc : documentos) {
                solicitacoes.add(doc);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar solicitações: " + e.getMessage());
        }
        return solicitacoes;
    }

    //update
    public void atualizarStatusSolicitacao(String email, String novoStatus) {
        try {
            MongoCollection<Document> collection = database.getCollection("Usuarios");
            long countAtivo = collection.countDocuments(Filters.and(
                    Filters.eq("email", email),
                    Filters.eq("status", "ativo")
            ));

            if (countAtivo > 0) {
                System.out.println("Usuário já está ativo. Nenhuma ação necessária.");
                return;
            }

            Bson filtro = Filters.and(
                    Filters.eq("email", email),
                    Filters.eq("status", "pendente")
            );

            Bson atualizacao = Updates.set("status", novoStatus);
            UpdateResult resultado = collection.updateOne(filtro, atualizacao);

            if (resultado.getModifiedCount() > 0) {
                System.out.println("Status atualizado com sucesso para o email: " + email);
            } else {
                System.out.println("Nenhum documento encontrado com o email: " + email + " e status pendente.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar status da solicitação: " + e.getMessage());
        }
    }
}