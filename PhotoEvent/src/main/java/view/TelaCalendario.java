package view;

import models.EventosCRUD;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaCalendario extends JPanel {
    private JFrame parentFrame;
    private EventosCRUD eventosCRUD;
    private LocalDate dataAtual;

    public TelaCalendario(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.eventosCRUD = new EventosCRUD();
        this.dataAtual = LocalDate.now();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBackground(new Color(0xf2f2f2));

        InicioCalendario inicioCalendarioPanel = new InicioCalendario(this, eventosCRUD, dataAtual);
        inicioCalendarioPanel.setBounds(0, 0, 1000, 600);

        add(inicioCalendarioPanel);
        iniciarCalendario();
    }

    private void iniciarCalendario() {
        setPreferredSize(new Dimension(900, 500));
        setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        setLayout(new GridBagLayout());
        setBackground(null);

        LocalDate data = LocalDate.now();
        String dataString = data.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE"));
        JLabel hojeLabel = new JLabel(dataString);
        hojeLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
        hojeLabel.setForeground(Color.decode("#393536"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 15, 5, 15);
        add(hojeLabel, constraints);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);

        add(new Calendario(
                parentFrame,
                data.getYear(),
                data.getMonthValue(),
                dataAtual,
                this,
                this,
                eventosCRUD
        ), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;

        add(new Eventos(
                dataAtual,
                eventosCRUD,
                parentFrame,
                this
        ), constraints);
    }
}