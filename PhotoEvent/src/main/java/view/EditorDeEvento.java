package view;
import controllers.EventoController;
import models.EventosCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class EditorDeEvento {

    String[] categories = {"Aniversário", "Casamento", "Ensaio"};
    private TelaMenuAssistente telaMenuAssistente;
    public EditorDeEvento(EventoController t, EventosCRUD eventosCRUD, JFrame parentFrame, JPanel parentPanel) {
        this.telaMenuAssistente = telaMenuAssistente;
        int year = t.getDate().getYear();
        int month = t.getDate().getMonthValue();

        JFrame frame = new JFrame("Adicionar evento");
        if (t.getTitle() != null) {
            frame.setTitle(t.getTitle());
        }

        ImageIcon img = new ImageIcon("/images/add.png");
        frame.setIconImage(img.getImage());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0xf2f2f2));

        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setPreferredSize(new Dimension(300, 300));
        painelPrincipal.setBackground(new Color(0xf2f2f2));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(15, 30, 0, 30);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel titleLabel = new JLabel("Título:");
        titleLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        titleLabel.setPreferredSize(new Dimension(120, 40));
        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        painelPrincipal.add(titleLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        JTextField titleField = new JTextField();
        titleField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        titleField.setPreferredSize(new Dimension(200, 40));
        painelPrincipal.add(titleField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel timeLabel = new JLabel("Horário:");
        timeLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        timeLabel.setPreferredSize(new Dimension(120, 40));
        timeLabel.setHorizontalAlignment(JLabel.LEFT);
        painelPrincipal.add(timeLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        JTextField timeField = new JTextField();
        timeField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        timeField.setPreferredSize(new Dimension(200, 40));
        painelPrincipal.add(timeField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel catagoriaLabel = new JLabel("Categoria:");
        catagoriaLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        catagoriaLabel.setPreferredSize(new Dimension(100, 40));
        catagoriaLabel.setHorizontalAlignment(JLabel.LEFT);
        painelPrincipal.add(catagoriaLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        final JComboBox<String> categoriaField = new JComboBox<String>(categories);
        categoriaField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        categoriaField.setPreferredSize(new Dimension(200, 40));

        ((JLabel) categoriaField.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        painelPrincipal.add(categoriaField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        JLabel descLabel = new JLabel("Descrição:");
        descLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        descLabel.setPreferredSize(new Dimension(120, 40));
        descLabel.setHorizontalAlignment(JLabel.LEFT);
        painelPrincipal.add(descLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 1;
        JTextArea descField = new JTextArea(3, 0);
        descField.setPreferredSize(new Dimension(200,300));
        descField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        descField.setFont(new Font("Helvetica", Font.PLAIN, 20));
        JScrollPane scroll = new JScrollPane(descField);
        painelPrincipal.add(scroll, constraints);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
        bottomPanel.setBackground(new Color(0xf2f2f2));

        JButton botaoApagarTarefa = new JButton("Apagar");
        botaoApagarTarefa.setFont(new Font("Helvetica", Font.PLAIN, 15));
        botaoApagarTarefa.setBackground(Color.decode("#f0ece6"));
        botaoApagarTarefa.setForeground(Color.decode("#393536"));
        botaoApagarTarefa.setPreferredSize(new Dimension(40,30));
        botaoApagarTarefa.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        bottomPanel.add(botaoApagarTarefa);

        JButton botaoSalvarTarefa = new JButton("Salvar");
        botaoSalvarTarefa.setFont(new Font("Helvetica", Font.PLAIN, 15));
        botaoSalvarTarefa.setBackground(Color.decode("#393536"));
        botaoSalvarTarefa.setForeground(new Color(0xf2f2f2));
        botaoSalvarTarefa.setPreferredSize(new Dimension(40,30));
        botaoSalvarTarefa.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        bottomPanel.add(botaoSalvarTarefa);

        timeField.setText(t.getTimeToString());

        if (t.getTitle() != null) {
            titleField.setText(t.getTitle());
            descField.setText(t.getDescription());
            categoriaField.setSelectedItem(t.getCategory());
            botaoSalvarTarefa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (titleField.getText().equals("")) {
                        JOptionPane.showMessageDialog(painelPrincipal, "O título não pode estar vazio.");
                        return;
                    }

                    t.setTitle(titleField.getText());
                    t.setDescription(descField.getText());
                    t.setCategory(categoriaField.getSelectedItem().toString());
                    try {
                        t.setTime(timeField.getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(painelPrincipal, "Verifique o formato de hora HH:mm");
                        return;
                    }

                    eventosCRUD.updateEventos(t);
                    resetarPainelPrincipal(parentFrame, parentPanel, t.getDate(), eventosCRUD, new Calendario(telaMenuAssistente, year, month, t.getDate(), parentFrame, parentPanel, eventosCRUD));
                    frame.dispose();
                }
            });

            botaoApagarTarefa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(painelPrincipal, new JLabel("Tem certeza de que deseja apagar " + t.getTitle() + "?"), "Apagar " + t.getTitle() + "?", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        eventosCRUD.deleteEventos(t.getID());

                        resetarPainelPrincipal(parentFrame, parentPanel, t.getDate(), eventosCRUD, new Calendario(telaMenuAssistente,year, month, t.getDate(), parentFrame, parentPanel, eventosCRUD));
                        frame.dispose();
                    }
                }
            });
        } else {
            botaoApagarTarefa.setVisible(false);
            botaoSalvarTarefa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (titleField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "O título não pode estar vazio.");
                        return;
                    }

                    t.setTitle(titleField.getText());
                    t.setDescription(descField.getText());
                    t.setCategory(categoriaField.getSelectedItem().toString());
                    t.setDone(false);
                    try {
                        t.setTime(timeField.getText());
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Verifique o formato de hora HH:mm");
                        return;
                    }
                    eventosCRUD.createEventos(t);
                    ArrayList<EventoController> EventoControllers = eventosCRUD.getEventos(t.getDateToString());
                    resetarPainelPrincipal(parentFrame, parentPanel, t.getDate(), eventosCRUD, new Calendario(telaMenuAssistente, year, month, t.getDate(), parentFrame, parentPanel, eventosCRUD));
                    frame.dispose();
                }
            });
        }

        frame.add(painelPrincipal);
        frame.add(bottomPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void resetarPainelPrincipal(JFrame parentFrame, JPanel parentPanel, LocalDate selectedDay, EventosCRUD eventosCRUD, Calendario c) {
        String name = parentPanel.getClass().toString();

        if (name.contains("AgendaDiaria")) {
            parentFrame.getContentPane().removeAll();
            AgendaDiaria agendaDiaria = new AgendaDiaria(parentFrame, selectedDay, eventosCRUD);
            agendaDiaria.validate();
            parentFrame.add(agendaDiaria);
            parentFrame.revalidate();
        } else {
            parentFrame.getContentPane().removeAll();
            InicioCalendario inicioCalendario = new InicioCalendario(parentPanel, eventosCRUD, selectedDay);
            inicioCalendario.validate();
            parentFrame.add(inicioCalendario);
            parentFrame.revalidate();
        }
    }
}