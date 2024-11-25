package view;

import controllers.BordaPadraoController;

import javax.swing.*;
import java.awt.*;

public class TelaPerfilAdmin extends JPanel
{
    private TelaMenuAssistente telaMenuAssistente;
    public TelaPerfilAdmin(TelaMenuAssistente telaMenuAssistente)
    {
        this.telaMenuAssistente = telaMenuAssistente;
        initComponents();
    }
    private void initComponents()
    {
        setLayout(null);
        setBackground(new Color(0xf2f2f2));

        JPanel jPanelPerfil = new JPanel();
        jPanelPerfil.setLayout(null);
        jPanelPerfil.setBackground(new Color(255, 255, 255));

        BordaPadraoController BordaPadraoController =new BordaPadraoController(10);


        ImageIcon backsy = new ImageIcon(getClass().getResource("/images/ilVoltar.png"));
        JButton voltarC = new JButton("Voltar",backsy);
        voltarC.setBackground(new Color(0xf2f2f2));
        voltarC.setFont(new Font("Calibre", Font.BOLD, 25));
        voltarC.setForeground(new Color(0x393536));
        voltarC.setBorder(BorderFactory.createCompoundBorder(
                BordaPadraoController,
                BorderFactory.createEmptyBorder(7, 1, 7, 1)
        ));
        voltarC.setHorizontalAlignment(SwingConstants.CENTER);
        voltarC.setVerticalAlignment(SwingConstants.CENTER);
        voltarC.setBounds(10, 10, 150, 50);
        voltarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaMenuAssistente.mostrarCard("cardMenu");
            }
        });
        add(voltarC);

        ImageIcon fundo = new ImageIcon(getClass().getResource("/images/telaPerfilAdmin.jpg"));
        JLabel background = new JLabel(fundo);
        background.setBounds(0, 0, fundo.getIconWidth(), fundo.getIconHeight());
        add(background);

        add(jPanelPerfil);
    }
}