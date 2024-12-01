package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import controllers.BordaPadraoController;
import org.bson.Document;
import models.PagamentoCRUD;

public class TelaFolhaPagamento extends JFrame {
    private JTable tabela;
    private TelaMenuAssistente telaMenuAssistente;

    public TelaFolhaPagamento(TelaMenuAssistente telaMenuAssistente) {
        this.telaMenuAssistente=telaMenuAssistente;
        setLayout(new BorderLayout());

        BordaPadraoController bordaPadraoController=new BordaPadraoController(10);
        JButton voltarC = new JButton("⬅");
        voltarC.setForeground(new Color(0x393536));
        voltarC.setBackground(new Color(0xffffff));
        voltarC.setFocusable(false);
        voltarC.setFocusPainted(false);
        voltarC.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        voltarC.setFont(new Font("Calibre", Font.BOLD, 35));
        voltarC.setHorizontalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(10, 10, 70, 55);
        voltarC.addActionListener(evt -> telaMenuAssistente.mostrarCard("cardMenu"));
        add(voltarC);

        PagamentoCRUD pagamentoModel = new PagamentoCRUD();
        List<Document> folha = pagamentoModel.calcularFolhaDePagamento();

        String[] colunas = {"Trabalhador", "Cargo", "Duração (h)", "Total (R$)"};
        String[][] dados = new String[folha.size()][4];

        for (int i = 0; i < folha.size(); i++) {
            Document doc = folha.get(i);
            dados[i][0] = doc.getString("trabalhador");
            dados[i][1] = doc.getString("cargo");
            dados[i][2] = String.valueOf(doc.getDouble("duracao"));
            dados[i][3] = String.format("%.2f", doc.getDouble("total"));
        }

        tabela = new JTable(dados, colunas);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }
}