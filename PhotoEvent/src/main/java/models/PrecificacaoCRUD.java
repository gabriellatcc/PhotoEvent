package models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import database.BancoDeDados;
import org.bson.Document;

public class PrecificacaoCRUD {
    private MongoDatabase database;

    public PrecificacaoCRUD() {
        this.database = new BancoDeDados().conectar();
    }
//create
    public boolean definirPrecoPorCargo(String cargo, double precoPorHora) {
        try {
            MongoCollection<Document> collection = database.getCollection("Precificacao");
            Document filtro = new Document("cargo", cargo);
            Document atualizar = new Document("$set", new Document("precoPorHora", precoPorHora));
            collection.updateOne(filtro, atualizar, new com.mongodb.client.model.UpdateOptions().upsert(true));
            System.out.println("Preço por hora atualizado para o cargo: " + cargo);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao definir preço: " + e.getMessage());
        }
        return false;
    }
//read
    public Double obterPrecoPorCargo(String cargo) {
        try {
            MongoCollection<Document> collection = database.getCollection("Precificacao");
            Document resultado = collection.find(Filters.eq("cargo", cargo)).first();
            if (resultado != null) {
                return resultado.getDouble("precoPorHora");
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter preço do cargo: " + e.getMessage());
        }
        return null;
    }
}