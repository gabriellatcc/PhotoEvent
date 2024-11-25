package database;

import com.mongodb.client.*;

public class BancoDeDados {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDatabase conectar() {
        try {
            String uri = "mongodb://localhost:27017";
            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase("photoevent");
            return database;
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return null;
    }
}