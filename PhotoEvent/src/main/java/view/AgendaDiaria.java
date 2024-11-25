package view;

import models.EventosCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AgendaDiaria extends JPanel {
    private JPanel jPanelCalendario;
    public AgendaDiaria(JFrame frame, LocalDate diaAtual, EventosCRUD eventosCRUD)
    {
        setPreferredSize(new Dimension(900, 500));
        setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        setLayout(new GridBagLayout());
        setBackground(new Color(0xf2f2f2));

        LocalDate data = diaAtual;
        String dataString = data.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE"));
        JLabel hojeLabel = new JLabel(dataString);
        hojeLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
        hojeLabel.setForeground(Color.decode("#393536"));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 15, 5, 15);
        add(hojeLabel, constraints);

        hojeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hojeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetarAgendaDiaria(frame, eventosCRUD);
            }
        });

        constraints.gridwidth = 1;
        constraints.weightx = 0.7;
        constraints.weighty = 3;
        constraints.gridx = 0;
        constraints.gridy = 1;
        EventosDoDia eventosDoDia = new EventosDoDia(diaAtual, eventosCRUD, frame, this);
        add(eventosDoDia, constraints);

        constraints.weightx = 0.3;
        constraints.gridx = 1;
        constraints.gridy = 1;
        JPanel painelObs = criarSessaoNotas(diaAtual, eventosCRUD);
        add(painelObs, constraints);
    }

    private JPanel criarSessaoNotas(LocalDate diaAtual, EventosCRUD eventosCRUD) {
        JPanel textAreaPanel = new JPanel(new BorderLayout());
        textAreaPanel.setPreferredSize(new Dimension(150, 300));
        textAreaPanel.setBackground(new Color(0xf2f2f2));

        JLabel obsLabel = new JLabel("Observações: ");
        obsLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        obsLabel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        textAreaPanel.add(obsLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        Boolean isNew = !eventosCRUD.hasNotas(diaAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if (!isNew) {
            textArea.setText(eventosCRUD.getNotas(diaAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        }
        textArea.setFont(new Font("Helvetica", Font.PLAIN, 15));
        textArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0x393536)));
        textArea.setLineWrap(true);
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if (isNew) {
                    eventosCRUD.createNotas(diaAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), textArea.getText());
                } else {
                    eventosCRUD.updateNotas(diaAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), textArea.getText());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        textAreaPanel.add(scrollPane);
        return textAreaPanel;
    }

    private void resetarAgendaDiaria(JFrame frame, EventosCRUD eventosCRUD) {
        frame.getContentPane().removeAll();
        InicioCalendario inicioCalendarioPanel = new InicioCalendario(this, eventosCRUD, LocalDate.now());
        inicioCalendarioPanel.iniciar();
        frame.add(inicioCalendarioPanel);
        frame.revalidate();
    }
}