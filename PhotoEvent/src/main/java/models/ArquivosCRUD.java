package models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ArquivosCRUD {
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public ArquivosCRUD(String dbName, String collectionName) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase(dbName);
        this.collection = database.getCollection(collectionName);
    }

    public void insertImage(String filePath, String fileName) {
        Document doc = new Document("filePath", filePath)
                .append("fileName", fileName);
        collection.insertOne(doc);
    }

    public List<Document> getAllImages() {
        return collection.find().into(new ArrayList<>());
    }

    public void deleteImage(String fileName) {
        collection.deleteOne(new Document("fileName", fileName));
    }

    public void updateImage(String oldName, String newPath, String newName) {
        Document query = new Document("fileName", oldName);
        Document updatedData = new Document("$set", new Document("filePath", newPath).append("fileName", newName));
        collection.updateOne(query, updatedData);
    }
}