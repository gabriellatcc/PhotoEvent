package view;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaMenu() {
        initComponents();
        setTitle("PhotoEvent");
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe48px.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        cardLayout = new CardLayout();
        jPanelBase = new JPanel(cardLayout);

        // Instancia os cards usando suas classes específicas
        jPanelBase.add(new TelaCliente(), "cardCliente");
        jPanelBase.add(new TelaCalendario(), "cardCalendario");
        jPanelBase.add(new TelaFolha(), "cardFolha");
        jPanelBase.add(new TelaEvento(), "cardEvento");
        jPanelBase.add(new TelaPerfil(), "cardPerfil");

        // Adiciona o jPanelBase ao JFrame
        getContentPane().add(jPanelBase);
        pack();

        // Exemplo de como exibir um card específico NO BOTAO
        cardLayout.show(jPanelBase, "cardCliente");
    }

    // Métodos para alternar entre os cards
    public void mostrarCard(String card) {
        cardLayout.show(jPanelBase, card);
    }
}
