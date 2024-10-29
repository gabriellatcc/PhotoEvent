package view;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends javax.swing.JFrame {
    public TelaMenu() {
        initComponents();
        setTitle("PhotoEvent");
        setSize(1280,800);
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe48px.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pack();
    }

}