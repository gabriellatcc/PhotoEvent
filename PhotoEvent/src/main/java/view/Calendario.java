package view;

import models.EventosCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Calendario extends JPanel {
    private TelaMenuAssistente telaMenuAssistente;
    public Calendario(JFrame telaMenuGerente, int ano, int month, LocalDate diaSelecionado, TelaCalendario parentalFrame, JPanel parentPanel, EventosCRUD eventosCRUD) {
        this.telaMenuAssistente = telaMenuGerente;
        setPreferredSize(new Dimension(400, 400));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 0));
        setBackground(new Color(0xf2f2f2));

        JPanel top = new JPanel(new BorderLayout());
        top.setPreferredSize(new Dimension(350, 50));
        top.setBackground(new Color(0xf2f2f2));

        JButton voltarC = new JButton("⬅");
        voltarC.setForeground(new Color(0x393536));
        voltarC.setBackground(new Color(0xf0ece6));
        voltarC.setFocusable(false);
        voltarC.setFocusPainted(false);
        voltarC.setFont(new Font("Calibre", Font.BOLD, 35));
        voltarC.setHorizontalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(10, 10, 70, 55);
        voltarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaMenuGerente.mostrarCard("cardMenu");
            }
        });
        top.add(voltarC, BorderLayout.WEST);

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        JLabel data = new JLabel(LocalDate.of(ano, month, 1).format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        data.setHorizontalAlignment(JLabel.CENTER);
        data.setFont(new Font("Helvetica", Font.BOLD, 25));
        data.setForeground(Color.decode("#393536"));
        top.add(data, BorderLayout.CENTER);

        JLabel esquerda = new JLabel(new ImageIcon("/images/arrow-left.png"));
        esquerda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        esquerda.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentPanel.removeAll();
                if (month != 1) {
                    resetarPainelPrincipal(parentalFrame, parentPanel, diaSelecionado, eventosCRUD, new Calendario(telaMenuGerente, ano, month - 1, diaSelecionado, parentalFrame, parentPanel, eventosCRUD));
                } else {
                    resetarPainelPrincipal(parentalFrame, parentPanel, diaSelecionado, eventosCRUD, new Calendario(telaMenuGerente, ano - 1, 12, diaSelecionado, parentalFrame, parentPanel, eventosCRUD));
                }
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
        top.add(esquerda, BorderLayout.WEST);

        JLabel direita = new JLabel(new ImageIcon("/images/arrow-right.png"));
        direita.setCursor(new Cursor(Cursor.HAND_CURSOR));
        direita.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentPanel.removeAll();
                if (month != 12) {
                    resetarPainelPrincipal(parentalFrame, parentPanel, diaSelecionado, eventosCRUD, new Calendario(telaMenuGerente, ano, month - 1, diaSelecionado, parentalFrame, parentPanel, eventosCRUD));
                } else {
                    resetarPainelPrincipal(parentalFrame, parentPanel, diaSelecionado, eventosCRUD, new Calendario(telaMenuGerente, ano - 1, 12, diaSelecionado, parentalFrame, parentPanel, eventosCRUD));
                }
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
        top.add(direita, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        JPanel dias = new JPanel(new GridLayout(7, 7));
        dias.setBackground(new Color(0xf2f2f2));

        Color header = Color.decode("#393536");
        dias.add(new DiaLabel("D", header, new Color(0xf2f2f2), false));
        dias.add(new DiaLabel("S", header, new Color(0xf2f2f2), false));
        dias.add(new DiaLabel("T", header, new Color(0xf2f2f2), false));
        dias.add(new DiaLabel("Q", header, new Color(0xf2f2f2), false));
        dias.add(new DiaLabel("Q", header, new Color(0xf2f2f2), false));
        dias.add(new DiaLabel("S", header, new Color(0xf2f2f2), false));
        dias.add(new DiaLabel("S", header, new Color(0xf2f2f2), false));

        LocalDate primeiroDia = LocalDate.of(ano, month, 1);
        DayOfWeek primeiroDiaSemana = primeiroDia.getDayOfWeek();

        for (int j = 0; j < primeiroDiaSemana.getValue() % 7; j++) {
            dias.add(new DiaLabel("", Color.decode("#f0ece6"), Color.BLACK, false));
        }

        int numeroDias = YearMonth.of(ano, month).lengthOfMonth();
        for (int i = 1; i <= numeroDias; i++) {
            final int dia = i;
            DiaLabel diaLabel;

            if (diaSelecionado.getYear() == ano && diaSelecionado.getMonthValue() == month && diaSelecionado.getDayOfMonth() == i) {
                diaLabel = new DiaLabel(i + "", Color.decode("#dacebb"), new Color(0x393536), true);
            } else if (eventosCRUD.hasEventos(formatoData.format(LocalDate.of(ano, month, i)))) {
                diaLabel = new DiaLabel(i + "", Color.decode("#fad02c"), new Color(0xf2f2f2), true);
            } else {
                diaLabel = new DiaLabel(i + "", Color.decode("#f0ece6"), new Color(0x393536), true);
            }

            LocalDate today = LocalDate.now();
            if (today.getYear() == ano && today.getMonthValue() == month && today.getDayOfMonth() == i) {
                diaLabel = new DiaLabel(i + "", Color.decode("#393536"), new Color((0xf2f2f2)), true);
            }
            diaLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    LocalDate dataAtual = LocalDate.of(ano, month, dia);
                    resetarPainelPrincipal(parentalFrame, parentPanel, dataAtual, eventosCRUD, new Calendario(telaMenuGerente, ano, month, dataAtual, parentalFrame, parentPanel, eventosCRUD));

                    if (e.getClickCount() == 2) {
                        parentPanel.setVisible(false);
                        AgendaDiaria agendaDiaria = new AgendaDiaria(parentalFrame, dataAtual, eventosCRUD);
                        agendaDiaria.setVisible(true);
                        parentalFrame.add(agendaDiaria);
                    }
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
            dias.add(diaLabel);
        }

        for (int i = 0; i < (42 - (primeiroDiaSemana.getValue() % 7 + numeroDias)); i++) {
            dias.add(new DiaLabel("", Color.decode("#f0ece6"), new Color(0x393536), false));
        }

        add(dias, BorderLayout.CENTER);
    }

    private static void resetarPainelPrincipal(JFrame parentFrame, JPanel painelPrincipal, LocalDate dataAtual, EventosCRUD eventosCRUD, Calendario c) {
        painelPrincipal.removeAll();
        LocalDate data = LocalDate.now();
        String dateString = data.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE"));
        JLabel hojeLabel = new JLabel(dateString);
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
        painelPrincipal.add(hojeLabel, constraints);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        painelPrincipal.add(c, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        painelPrincipal.add(new Eventos(dataAtual, eventosCRUD, parentFrame, painelPrincipal), constraints);
        painelPrincipal.revalidate();
    }
}
