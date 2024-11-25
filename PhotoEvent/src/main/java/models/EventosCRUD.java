package models;

import com.mongodb.client.*;
import controllers.EventoController;
import database.BancoDeDados;
import org.bson.Document;

import java.util.ArrayList;

public class EventosCRUD {
    private MongoDatabase database;
    private MongoCollection<Document> taskCollection;
    private MongoCollection<Document> notesCollection;

    public EventosCRUD() {
        this.database = new BancoDeDados().conectar();
        this.taskCollection = database.getCollection("enventos");
        this.notesCollection = database.getCollection("descricoes");
        this.database = new BancoDeDados().conectar();
    }

    public ArrayList<EventoController> getEventos(String data) {
        ArrayList<EventoController> EventoControllers = new ArrayList<>();
        FindIterable<Document> results = taskCollection.find(new Document("data", data));

        for (Document doc : results) {
            EventoController t = new EventoController();
            t.setID(doc.getInteger("ID"));
            t.setTitle(doc.getString("titulo"));
            t.setDescription(doc.getString("descricao"));
            t.setCategory(doc.getString("categoria"));
            t.setDone(doc.getBoolean("isDone"));
            t.setDateTimeFromString(doc.getString("date") + " | " + doc.getString("time"));
            EventoControllers.add(t);
        }
        System.out.println("Tarefas carregadas para a data: " + data);
        return EventoControllers;
    }

    public boolean hasEventos(String data) {
        long count = taskCollection.countDocuments(new Document("data", data));
        System.out.println("Número de tarefas para a data " + data + ": " + count);
        return count > 0;
    }

    public void createEventos(EventoController t) {
        Document doc = new Document("titulo", t.getTitle())
                .append("descricao", t.getDescription())
                .append("categoria", t.getCategory())
                .append("isDone", t.isDone())
                .append("data", t.getDateToString())
        //        .append("nome_cliente", nomeCliente)
         //       .append("sobrenome_cliente", sobrenomeCliente)
         //       .append("tipo", tipo)
         //       .append("endereco", endereco)
//.append("duracao", duracao)
         //       .append("tempo_estimado_edicao", tempoEstimadoEdicao)
                .append("horario", t.getTimeToString());
        taskCollection.insertOne(doc);
        System.out.println("Tarefa enviada ao banco: " + t.getTitle());
    }

    public void updateEventos(EventoController t) {
        Document updatedEvento = new Document("titulo", t.getTitle())
                .append("descricao", t.getDescription())
                .append("categoria", t.getCategory())
                .append("isDone", t.isDone())
                .append("data", t.getDateToString())
                .append("horario", t.getTimeToString());

        taskCollection.updateOne(new Document("ID", t.getID()), new Document("$set", updatedEvento));
        System.out.println("Tarefa atualizada no banco: " + t.getTitle());
    }

    public void deleteEventos(int ID) {
        taskCollection.deleteOne(new Document("ID", ID));
        System.out.println("Tarefa com ID " + ID + " deletada do banco.");
    }

    public boolean hasNotas(String data) {
        long count = notesCollection.countDocuments(new Document("data", data));
        System.out.println("Número de notas para a data " + data + ": " + count);
        return count > 0;
    }

    public String getNotas(String data) {
        Document result = notesCollection.find(new Document("data", data)).first();
        String note = result != null ? result.getString("note") : "";
        System.out.println("Nota carregada para a data " + data + ": " + note);
        return note;
    }

    public void createNotas(String data, String note) {
        Document doc = new Document("data", data)
                .append("note", note);
        notesCollection.insertOne(doc);
        System.out.println("Nota criada para a data " + data + ": " + note);
    }

    public void updateNotas(String data, String note) {
        Document updatedNote = new Document("note", note);
        notesCollection.updateOne(new Document("data", data), new Document("$set", updatedNote));
        System.out.println("Nota atualizada para a data " + data + ": " + note);
    }
}