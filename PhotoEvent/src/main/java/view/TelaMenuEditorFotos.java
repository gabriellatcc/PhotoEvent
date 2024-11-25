package view;

import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

import javax.swing.*;
import java.awt.*;

public class TelaMenuEditorFotos extends JFrame {
    private JPanel jPanelBase;
    private CardLayout cardLayout;

    public TelaMenuEditorFotos()
    {
        initComponents();
        setTitle("PhotoEvent - Menu Editor de Vídeos");
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void initComponents()
    {
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        jPanelBase = new JPanel(null);

        getContentPane().add(jPanelBase, "cardMenuEditorFotos");

        pack();
    }
}