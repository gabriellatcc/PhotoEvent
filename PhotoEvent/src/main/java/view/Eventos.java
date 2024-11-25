package view;
import controllers.EventoController;
import models.EventosCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Eventos extends JPanel {
    public Eventos(LocalDate date, EventosCRUD eventosCRUD, JFrame frame, JPanel mainPanel) {
        setPreferredSize(new Dimension(400, 400));
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(0xf2f2f2));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 10));
        createTasksSection(date, eventosCRUD, frame, mainPanel);
    }
    private void createTasksSection(LocalDate date, EventosCRUD eventosCRUD, JFrame frame, JPanel mainPanel) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy"));
        ArrayList<EventoController> EventoControllers = eventosCRUD.getEventos(dateFormatter.format(date));
        int rows = 4;
        if (EventoControllers.size() > 4) {
            rows = EventoControllers.size();
        }

        JPanel list = new JPanel(new GridLayout(rows, 1, 10, 5));
        list.setBackground(new Color(0xf2f2f2));

        JScrollPane scrollPane = new JScrollPane(list);

        for (int i = 0; i < EventoControllers.size(); i++) {
            final int j = i;
            JPanel task = new JPanel(new GridLayout(2, 2));
            task.setPreferredSize(new Dimension(400,80));
            task.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20), BorderFactory.createMatteBorder(0, 10, 0, 0, Color.decode(getTaskColor(EventoControllers.get(i).getCategory())))));
            task.setBackground(Color.decode("#f0ece6"));
            task.setCursor(new Cursor(Cursor.HAND_CURSOR));
            task.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new EditorDeEvento(EventoControllers.get(j), eventosCRUD, frame, mainPanel);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

            JPanel taskTop = new JPanel(new BorderLayout());
            taskTop.setBackground(null);

            JLabel title = new JLabel(EventoControllers.get(i).getTitle());
            title.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
            title.setFont(new Font("Helvetica", Font.PLAIN, 20));
            title.setForeground(Color.decode("#393536"));
            taskTop.add(title, BorderLayout.WEST);

            Icon notSelected = new ImageIcon("/images/check-box-not-selected.png");
            Icon selected = new ImageIcon("/images/check-box-selected.png");
            JCheckBox checkBox = new JCheckBox();
            checkBox.setBackground(null);
            checkBox.setSelected(EventoControllers.get(i).isDone());
            checkBox.setIcon(notSelected);
            checkBox.setSelectedIcon(selected);
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    EventoController t = EventoControllers.get(j);
                    t.setDone(checkBox.isSelected());
                    eventosCRUD.updateEventos(t);
                }
            });
            taskTop.add(checkBox, BorderLayout.EAST);

            JLabel time = new JLabel(EventoControllers.get(i).getDateTimeToString());
            time.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
            time.setFont(new Font("Helvetica", Font.PLAIN, 15));
            time.setForeground(Color.DARK_GRAY);
            task.add(taskTop);
            task.add(time);
            list.add(task);
        }
        add(scrollPane, BorderLayout.CENTER);

        JButton botaoNovoCompromisso = new JButton("Novo");
        botaoNovoCompromisso.setFont(new Font("Helvetica", Font.PLAIN, 15));
        botaoNovoCompromisso.setBackground(Color.decode("#b05915"));
        botaoNovoCompromisso.setForeground(new Color(0xf2f2f2));
        botaoNovoCompromisso.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        botaoNovoCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditorDeEvento(new EventoController(date), eventosCRUD, frame, mainPanel);
            }
        });
        add(botaoNovoCompromisso, BorderLayout.SOUTH);
    }
    private String getTaskColor(String category) {
        switch (category) {
            case "Aniversário":
                return "#fad02c";
            case "Casamento":
                return "#0cadee";
            case "Ensaio":
                return "#ea298f";
            default:
                return "#666822";
        }
    }
}