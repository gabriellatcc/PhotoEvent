package models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.BancoDeDados;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class PagamentoCRUD {
    private MongoDatabase database;

    public PagamentoCRUD() {
        this.database = new BancoDeDados().conectar();
    }

    public List<Document> calcularFolhaDePagamento() {
        List<Document> folhaDePagamento = new ArrayList<>();
        try {
            MongoCollection<Document> eventosCollection = database.getCollection("eventos");
            for (Document evento : eventosCollection.find()) {
                String servico = evento.getString("servico");
                double duracao = evento.getDouble("duracao");

                double pagamento = 0;

                if ("foto".equalsIgnoreCase(servico)) {
                    pagamento = calcularPagamentoFoto(duracao);
                }

                folhaDePagamento.add(new Document("evento", evento.getString("titulo"))
                        .append("servico", servico)
                        .append("duracao", duracao)
                        .append("valorPagamento", pagamento));
            }
        } catch (Exception e) {
            System.out.println("Erro ao calcular folha de pagamento: " + e.getMessage());
        }
        return folhaDePagamento;
    }

    private double calcularPagamentoFoto(double duracao) {
        double precoPorHora = 100.0;
        return precoPorHora * duracao;
    }
}
