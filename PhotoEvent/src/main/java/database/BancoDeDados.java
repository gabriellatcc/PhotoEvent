package database;

import com.mongodb.client.*;
import org.bson.Document;

public class BancoDeDados {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDatabase conectar() {
        try {
            // Conectar ao MongoDB usando a URI
            String uri = "mongodb://localhost:27017"; // URL do seu MongoDB, pode ser alterada conforme sua configuração
            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase("seu_banco"); // Substitua pelo nome do seu banco
            return database;
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return null;
    }

    public boolean emailJaCadastrado(String email) {
        try {
            MongoDatabase db = conectar();
            MongoCollection<Document> collection = db.getCollection("Usuarios"); // Nome da sua coleção no MongoDB

            Document query = new Document("email", email);
            long count = collection.countDocuments(query);

            return count > 0; // Retorna true se o email já estiver cadastrado
        } catch (Exception e) {
            System.out.println("Erro ao verificar email: " + e.getMessage());
        }
        return false;
    }

    public boolean cadastrarUsuario(String email, String senha) {
        try {
            MongoDatabase db = conectar();
            MongoCollection<Document> collection = db.getCollection("Usuarios"); // Nome da sua coleção no MongoDB

            Document novoUsuario = new Document("email", email)
                    .append("senha", senha);

            collection.insertOne(novoUsuario);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
        return false;
    }

    public String getSenhaUsuario(String email) {
        try {
            MongoDatabase db = conectar();
            MongoCollection<Document> collection = db.getCollection("Usuarios");

            Document query = new Document("email", email);
            Document usuario = collection.find(query).first();

            if (usuario != null) {
                return usuario.getString("senha"); // Retorna a senha se o e-mail for encontrado
            }
            return null; // Se o e-mail não for encontrado

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean inserirCliente(Cliente cliente) {
        try {
            MongoDatabase db = conectar();
            MongoCollection<Document> collection = db.getCollection("Cliente");

            collection.insertOne(cliente.toDocument());
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
        return false;
    }
    //metodo de busca de cliente
    /*public List<Cliente> buscarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            MongoDatabase db = conectar();
            MongoCollection<Document> collection = db.getCollection("Cliente");

            for (Document doc : collection.find()) {
                Cliente cliente = new Cliente(
                        doc.getInteger("id"),
                        doc.getString("nome"),
                        doc.getString("sobrenome"),
                        doc.getString("cpf"),
                        doc.getString("cnpj"),
                        doc.getString("telefone"),
                        doc.getString("servicos_contratados")
                );
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar clientes: " + e.getMessage());
        }
        return clientes;
    }*/

}