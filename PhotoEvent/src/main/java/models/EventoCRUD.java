package models;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import database.BancoDeDados;
import controllers.EventoController;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class EventoCRUD {
    private MongoCollection<Document> eventosCollection;

    public EventoCRUD() {
        BancoDeDados bancoDeDados = new BancoDeDados();
        MongoDatabase database = bancoDeDados.conectar();
        this.eventosCollection = database.getCollection("eventos");
    }

    // CREATE
    public void criarEvento(EventoController evento) {
        if ("foto".equalsIgnoreCase(evento.getServico())) {
            // Calcular o valor baseado na duração para o fotógrafo
            evento.setValorPagamento(calcularPagamentoFoto(evento.getDuracao()));
        }

        Document eventoDoc = new Document("titulo", evento.getTitulo())
                .append("nomeCliente", evento.getNomeCliente())
                .append("sobrenomeCliente", evento.getSobrenomeCliente())
                .append("tipo", evento.getTipo())
                .append("endereco", evento.getEndereco())
                .append("duracao", evento.getDuracao())
                .append("horarioInicio", evento.getHorarioInicio())
                .append("tempoEstimadoEdicao", evento.getTempoEstimadoEdicao())
                .append("dataEvento", evento.getDataEvento())
                .append("servico", evento.getServico())
                .append("metodoPagamento", evento.getMetodoPagamento())
                .append("parcelamento", evento.getParcelamento())
                .append("valorPagamento", evento.getValorPagamento());
        eventosCollection.insertOne(eventoDoc);
    }

    // READ
    public List<EventoController> buscarEventosPorData(String data) {
        List<EventoController> eventos = new ArrayList<>();
        FindIterable<Document> documentos = eventosCollection.find(Filters.eq("dataEvento", data));
        for (Document doc : documentos) {
            EventoController evento = new EventoController();
            evento.setDuracao(doc.getDouble("duracao") != null ? doc.getDouble("duracao") : 0.0);
            evento.setValorPagamento(doc.getDouble("valorPagamento") != null ? doc.getDouble("valorPagamento") : 0.0);
            evento.setTitulo(doc.getString("titulo") != null ? doc.getString("titulo") : "Sem título");
            evento.setNomeCliente(doc.getString("nomeCliente"));
            evento.setSobrenomeCliente(doc.getString("sobrenomeCliente"));
            evento.setTipo(doc.getString("tipo"));
            evento.setEndereco(doc.getString("endereco"));
            evento.setHorarioInicio(doc.getString("horarioInicio"));
            evento.setTempoEstimadoEdicao(doc.getString("tempoEstimadoEdicao"));
            evento.setDataEvento(doc.getString("dataEvento"));
            evento.setServico(doc.getString("servico"));
            evento.setMetodoPagamento(doc.getString("metodoPagamento"));
            evento.setParcelamento(doc.getString("parcelamento"));
            eventos.add(evento);
        }
        return eventos;
    }

    // UPDATE
    public void atualizarEvento(String titulo, EventoController eventoAtualizado) {
        Document filtro = new Document("titulo", titulo);
        Document novoEvento = new Document("titulo", eventoAtualizado.getTitulo())
                .append("nomeCliente", eventoAtualizado.getNomeCliente())
                .append("sobrenomeCliente", eventoAtualizado.getSobrenomeCliente())
                .append("tipo", eventoAtualizado.getTipo())
                .append("endereco", eventoAtualizado.getEndereco())
                .append("duracao", eventoAtualizado.getDuracao())
                .append("horarioInicio", eventoAtualizado.getHorarioInicio())
                .append("tempoEstimadoEdicao", eventoAtualizado.getTempoEstimadoEdicao())
                .append("dataEvento", eventoAtualizado.getDataEvento())
                .append("servico", eventoAtualizado.getServico())
                .append("metodoPagamento", eventoAtualizado.getMetodoPagamento())
                .append("parcelamento", eventoAtualizado.getParcelamento())
                .append("valorPagamento", eventoAtualizado.getValorPagamento());

        eventosCollection.updateOne(filtro, new Document("$set", novoEvento));
    }

    public void excluirEvento(String titulo) {
        Document filtro = new Document("titulo", titulo);
        eventosCollection.deleteOne(filtro);
    }

    private double calcularPagamentoFoto(double duracao) {
        double precoPorHora = 100.0;
        return precoPorHora * duracao;
    }
}