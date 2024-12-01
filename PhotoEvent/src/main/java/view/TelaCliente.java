package view;

import controllers.BordaPadraoController;
import models.ClienteCRUD;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCliente extends JPanel {

    private TelaMenuAssistente telaMenuAssistente;
    private ClienteCRUD clienteCRUD;

    public TelaCliente(TelaMenuAssistente telaMenuAssistente) {
        this.telaMenuAssistente = telaMenuAssistente;
        clienteCRUD = new ClienteCRUD();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBackground(new Color(0xf2f2f2));

        JPanel jPanelCliente = new JPanel();
        jPanelCliente.setLayout(null);
        jPanelCliente.setBackground(new Color(255, 255, 255));

        JScrollPane scrollPane = new JScrollPane(jPanelCliente);
        scrollPane.setBounds(387, 200, 760, 380); // Ajuste a posição e tamanho do scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        BordaPadraoController bordaPadraoController = new BordaPadraoController(10);

        ImageIcon backsy = new ImageIcon(getClass().getResource("/images/ilVoltar.png"));
        JButton voltarC = new JButton("Voltar", backsy);
        voltarC.setBackground(new Color(0xf2f2f2));
        voltarC.setFont(new Font("Calibre", Font.BOLD, 25));
        voltarC.setForeground(new Color(0x393536));
        voltarC.setBorder(BorderFactory.createCompoundBorder(
                bordaPadraoController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        voltarC.setHorizontalAlignment(SwingConstants.CENTER);
        voltarC.setVerticalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(10, 10, 150, 50);
        voltarC.addActionListener(evt -> telaMenuAssistente.mostrarCard("cardMenu"));
        add(voltarC);

        JLabel title=new JLabel("Clientes");
        title.setFont(new Font("Open Sans", Font.BOLD, 52));
        title.setForeground(new Color(0x393536));
        title.setOpaque(false);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setBounds(526,85,500,76);
        add(title);
        JButton adicionarClienteButton = new JButton("Adicionar Cliente");
        adicionarClienteButton.setBackground(new Color(0x007BFF));
        adicionarClienteButton.setFont(new Font("Arial", Font.PLAIN, 16));
        adicionarClienteButton.setForeground(Color.WHITE);
        adicionarClienteButton.setBounds(1000,50, 200, 40); // Centralizado abaixo do JScrollPane
        adicionarClienteButton.addActionListener(evt -> {
            adicionarNovoCliente();
        });
        add(adicionarClienteButton);

        carregarClientes(jPanelCliente);
    }
    private void adicionarNovoCliente() {
        String nome = JOptionPane.showInputDialog(this, "Nome do Cliente:");
        if (nome != null && !nome.isEmpty()) {
            String sobrenome = JOptionPane.showInputDialog(this, "Sobrenome:");
            String cpf = JOptionPane.showInputDialog(this, "CPF:");

            clienteCRUD.inserirCliente(123, nome, sobrenome, cpf, "", "", "");
            JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
        }
    }
    private void carregarClientes(JPanel jPanelCliente) {
        List<Document> clientes = clienteCRUD.buscarTodosClientes();

        int yPosition = 10;

        for (Document cliente : clientes) {
            String clienteInfo = "ID: " + cliente.get("id") + ", Nome: " + cliente.get("nome") +
                    ", Sobrenome: " + cliente.get("sobrenome") + ", CPF: " + cliente.get("cpf");

            JLabel label = new JLabel(clienteInfo);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setBounds(10, yPosition, 600, 30);
            jPanelCliente.add(label);

            JButton excluirButton = new JButton("Excluir");
            excluirButton.setFont(new Font("Arial", Font.PLAIN, 12));
            excluirButton.setBounds(620, yPosition, 100, 30);
            excluirButton.addActionListener(evt -> excluirCliente(cliente.getString("cpf"), jPanelCliente));

            jPanelCliente.add(excluirButton);

            yPosition += 40;
        }

        jPanelCliente.setPreferredSize(new Dimension(760, yPosition));
    }

    private void excluirCliente(String cpf, JPanel jPanelCliente) {
        boolean sucesso = clienteCRUD.deletarCliente(cpf);

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            jPanelCliente.removeAll();
            carregarClientes(jPanelCliente);
            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}