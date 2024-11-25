package view;

import javax.swing.*;
import java.awt.*;

public class DiaLabel extends JLabel {

    public DiaLabel(String s, Color background, Color foreground, boolean btn) {
        setText(s);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica", Font.BOLD, 15));
        setOpaque(true);
        setBackground(background);
        setForeground(foreground);
        if (btn) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
}

