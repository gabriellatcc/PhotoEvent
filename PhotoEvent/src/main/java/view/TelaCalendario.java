package view;

import controllers.BordaPadraoController;
import models.EventoCRUD;
import controllers.EventoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;


public class TelaCalendario extends JPanel {
    private TelaMenuBase telaMenuBase;
    private JPanel calendarGrid;
    private JLabel labelDataAtual;
    private EventoCRUD eventoCRUD;

    public TelaCalendario(TelaMenuBase telaMenuBase) {
        this.telaMenuBase = telaMenuBase;
        this.eventoCRUD = new EventoCRUD();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(0xf2f2f2));

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
        voltarC.addActionListener(evt -> telaMenuBase.mostrarCard("cardMenu"));
        add(voltarC);


        labelDataAtual = new JLabel();
        labelDataAtual.setFont(new Font("Arial", Font.BOLD, 20));
        labelDataAtual.setHorizontalAlignment(SwingConstants.CENTER);
        atualizarDataAtual();
        add(labelDataAtual, BorderLayout.NORTH);

        calendarGrid = new JPanel(new GridLayout(7, 7));
        add(calendarGrid, BorderLayout.CENTER);

        String[] dias = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        for (String dia : dias) {
            calendarGrid.add(new JLabel(dia, SwingConstants.CENTER));
        }

        LocalDate dataAtual = LocalDate.now();
        preencherCalendario(dataAtual.getYear(), dataAtual.getMonthValue(), dataAtual.getDayOfMonth());

        JButton btnNovoEvento = new JButton("Novo Evento");
        btnNovoEvento.setFont(new Font("Arial", Font.BOLD, 16));
        btnNovoEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Novo evento");
            }
        });

        JScrollPane scrollPaneEventos = new JScrollPane();
        JPanel eventosPanel = new JPanel();
        eventosPanel.setLayout(new BoxLayout(eventosPanel, BoxLayout.Y_AXIS));
        scrollPaneEventos.setViewportView(eventosPanel);

        add(scrollPaneEventos, BorderLayout.EAST);
        add(scrollPaneEventos, BorderLayout.EAST);

        List<EventoController> eventos = eventoCRUD.buscarEventosPorData(dataAtual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        for (EventoController evento : eventos) {
            eventosPanel.add(new JLabel("Evento: " + evento.getTitulo()));
        }

    }

    private void atualizarDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        labelDataAtual.setText(dataAtual.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
    }

    private void preencherCalendario(int ano, int mes, int diaAtual) {
        calendarGrid.removeAll();

        String[] dias = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        for (String dia : dias) {
            calendarGrid.add(new JLabel(dia, SwingConstants.CENTER));
        }

        LocalDate primeiroDiaDoMes = LocalDate.of(ano, mes, 1);
        int diaDaSemana = primeiroDiaDoMes.getDayOfWeek().getValue();

        LocalDate ultimoDiaDoMes = primeiroDiaDoMes.withDayOfMonth(primeiroDiaDoMes.lengthOfMonth());

        for (int i = 0; i < diaDaSemana; i++) {
            calendarGrid.add(new JLabel(""));
        }

        for (int dia = 1; dia <= ultimoDiaDoMes.getDayOfMonth(); dia++) {
            JButton diaButton = new JButton(String.valueOf(dia));
            diaButton.setFont(new Font("Arial", Font.PLAIN, 16));

            String dataFormatada = String.format("%04d-%02d-%02d", ano, mes, dia);

            if (dia == diaAtual) {
                diaButton.setBackground(new Color(0xFFCC00));
            } else {
                diaButton.setBackground(Color.WHITE);
            }

            List<EventoController> eventosDoDia = eventoCRUD.buscarEventosPorData(dataFormatada);
            if (!eventosDoDia.isEmpty()) {
                diaButton.setBackground(new Color(0x66CC66));
            }

            diaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Dia selecionado: " + diaAtual);
                    abrirFormularioEvento(dataFormatada);
                }
            });

            calendarGrid.add(diaButton);
        }

        int diasExtras = 7 - (ultimoDiaDoMes.getDayOfWeek().getValue());
        for (int i = 0; i < diasExtras; i++) {
            calendarGrid.add(new JLabel(""));
        }

        calendarGrid.revalidate();
        calendarGrid.repaint();
    }

    private void abrirFormularioEvento(String dataSelecionada) {
        JFrame frame = new JFrame("Criar Evento");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JPanel painelEsquerdo = new JPanel(new GridLayout(6, 1, 10, 10));
        JPanel painelDireito = new JPanel(new GridLayout(6, 1, 10, 10));

        // Coluna esquerda (dados do evento)
        painelEsquerdo.add(new JLabel("Nome do Evento:"));
        JTextField campoNomeEvento = new JTextField();
        painelEsquerdo.add(campoNomeEvento);

        painelEsquerdo.add(new JLabel("Categoria:"));
        String[] categorias = {"Aniversário", "Casamento", "Ensaio"};
        JComboBox<String> comboCategoria = new JComboBox<>(categorias);
        painelEsquerdo.add(comboCategoria);

        painelEsquerdo.add(new JLabel("Local:"));
        JTextField campoLocal = new JTextField();
        painelEsquerdo.add(campoLocal);

        painelEsquerdo.add(new JLabel("Data:"));
        JTextField campoDataEvento = new JTextField("DD/MM/YYYY");
        painelEsquerdo.add(campoDataEvento);

        painelEsquerdo.add(new JLabel("Horário de Início:"));
        JTextField campoHorarioInicio = new JTextField();
        painelEsquerdo.add(campoHorarioInicio);

        painelEsquerdo.add(new JLabel("Horário Final:"));
        JTextField campoHorarioFinal = new JTextField();
        painelEsquerdo.add(campoHorarioFinal);

        // Coluna direita (dados do cliente e pagamento)
        painelDireito.add(new JLabel("Nome do Cliente:"));
        JTextField campoNomeCliente = new JTextField();
        painelDireito.add(campoNomeCliente);

        painelDireito.add(new JLabel("Telefone:"));
        JTextField campoTelefone = new JTextField();
        painelDireito.add(campoTelefone);

        painelDireito.add(new JLabel("Serviço:"));
        String[] servicos = {"Foto", "Filmagem"};
        JComboBox<String> comboServico = new JComboBox<>(servicos);
        painelDireito.add(comboServico);

        painelDireito.add(new JLabel("Método de Pagamento:"));
        String[] metodosPagamento = {"Cartão de Crédito/Débito", "Pix", "Dinheiro"};
        JComboBox<String> comboPagamento = new JComboBox<>(metodosPagamento);
        painelDireito.add(comboPagamento);

        painelDireito.add(new JLabel("Parcelamento:"));
        String[] parcelamentos = {"Sim", "Não"};
        JComboBox<String> comboParcelamento = new JComboBox<>(parcelamentos);
        painelDireito.add(comboParcelamento);

        // Adicionando os painéis ao frame
        frame.add(painelEsquerdo);
        frame.add(painelDireito);

        // Botão de salvar evento
        JButton btnSalvar = new JButton("Salvar Evento");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventoController evento = new EventoController();
                evento.setTitulo(campoNomeEvento.getText());
                evento.setCategoria((String) comboCategoria.getSelectedItem());
                evento.setLocal(campoLocal.getText());
                evento.setDataEvento(campoDataEvento.getText());
                evento.setHorarioInicio(campoHorarioInicio.getText());
                evento.setHorarioFinal(campoHorarioFinal.getText());
                evento.setNomeCliente(campoNomeCliente.getText());
                evento.setTelefone(campoTelefone.getText());
                evento.setServico((String) comboServico.getSelectedItem());
                evento.setMetodoPagamento((String) comboPagamento.getSelectedItem());
                evento.setParcelamento((String) comboParcelamento.getSelectedItem());

                eventoCRUD.criarEvento(evento);
                JOptionPane.showMessageDialog(frame, "Evento salvo com sucesso!");
                frame.dispose();
            }
        });

        frame.add(btnSalvar, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void atualizarEventosDoDia(String data) {
        JScrollPane scrollPaneEventos = new JScrollPane();
        JPanel eventosPanel = new JPanel();
        eventosPanel.setLayout(new BoxLayout(eventosPanel, BoxLayout.Y_AXIS));
        scrollPaneEventos.setViewportView(eventosPanel);

        List<EventoController> eventosDoDia = eventoCRUD.buscarEventosPorData(data);

        for (EventoController evento : eventosDoDia) {
            eventosPanel.add(new JLabel("Evento: " + evento.getTitulo()));
        }
        eventosPanel.revalidate();
        eventosPanel.repaint();
    }
}