package main;
import javax.swing.JFrame;
import view.TelaInicial;
public class Main
{
    public static void main(String[] args)
    {
        TelaInicial frame = new TelaInicial();
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setVisible(true);
    }
}