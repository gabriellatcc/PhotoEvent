package view;

import javax.swing.*;
import java.awt.*;

public class TelaCalendario extends javax.swing.JFrame
{
    public TelaCalendario()
    {
        initComponents();
        setTitle("PhotoEvent");
        setIconImage(new ImageIcon(getClass().getResource("/images/ilPe48px.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//1920 1080
    }
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        pack();
    }
}