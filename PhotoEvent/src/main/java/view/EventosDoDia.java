package view;

import controllers.EventoController;
import models.EventosCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EventosDoDia extends JPanel {

    public EventosDoDia(LocalDate date, EventosCRUD eventosCRUD, JFrame frame, JPanel parentPanel) {

        setPreferredSize(new Dimension(400, 300));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy"));
        setLayout(new BorderLayout());
        setBackground(new Color(0xf2f2f2));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        topPanel.setBackground(null);

        JLabel eventosLabel = new JLabel("Eventos");
        eventosLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        topPanel.add(eventosLabel, BorderLayout.WEST);

        JLabel addButton = new JLabel(new ImageIcon("/images/add.png"));
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EditorDeEvento(new EventoController(date), eventosCRUD, frame, parentPanel);
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
        topPanel.add(addButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        ArrayList<EventoController> EventoControllers = eventosCRUD.getEventos(dateFormatter.format(date));
        int rows = 6;
        if (EventoControllers.size() > 5) {
            rows = EventoControllers.size() + 1;
        }

        JPanel lista = new JPanel(new GridLayout(rows, 1, 2, 2));
        lista.setBackground(new Color(0xf2f2f2));

        JPanel header = new JPanel(new GridLayout(1, 6));
        header.setPreferredSize(new Dimension(350, 40));
        header.setBackground(Color.decode("#b05915"));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color (0x393536)));

        header.add(createHeaderLabel(""));
        header.add(createHeaderLabel("Horário"));
        header.add(createHeaderLabel("Compromisso"));
        header.add(createHeaderLabel("Categoria"));
        header.add(createHeaderLabel("Concluir"));
        lista.add(header);

        for (int i = 0; i < EventoControllers.size(); i++) {
            final int j = i;
            JPanel compromisso = new JPanel(new GridLayout(1, 6));
            compromisso.setPreferredSize(new Dimension(350, 30));
            compromisso.setBackground(Color.decode("#f2f2f2"));
            compromisso.setCursor(new Cursor(Cursor.HAND_CURSOR));
            compromisso.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new EditorDeEvento(EventoControllers.get(j), eventosCRUD, frame, parentPanel);
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

            compromisso.add(createBodyLabel(Integer.toString(i + 1), "#000000"));
            compromisso.add(createBodyLabel(EventoControllers.get(i).getTimeToString(), "#000000"));
            compromisso.add(createBodyLabel(EventoControllers.get(i).getTitle(), "#000000"));
            compromisso.add(createBodyLabel(EventoControllers.get(i).getCategory(), getTaskColor(EventoControllers.get(i).getCategory())));

            Icon notSelected = new ImageIcon("/images/check-box-not-selected.png");
            Icon selected = new ImageIcon("/images/check-box-selected.png");
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(EventoControllers.get(i).isDone());
            checkBox.setIcon(notSelected);
            checkBox.setSelectedIcon(selected);
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    EventoController t = EventoControllers.get(j);
                    t.setDone(checkBox.isSelected());
                    eventosCRUD.updateEventos(t);
                    parentPanel.revalidate();
                }
            });
            compromisso.add(checkBox);
            lista.add(compromisso);
        }

        JScrollPane scrollPane = new JScrollPane(lista);
        add(scrollPane, BorderLayout.CENTER);
    }
    private JLabel createHeaderLabel(String label) {
        JLabel headerLabel = new JLabel(label);
        headerLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
        headerLabel.setForeground(new Color(0xf2f2f2));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return headerLabel;
    }

    private JLabel createBodyLabel(String label, String fontColor) {
        JLabel bodyLabel = new JLabel(label);
        bodyLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
        bodyLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
        bodyLabel.setForeground(Color.decode(fontColor));
        return bodyLabel;
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