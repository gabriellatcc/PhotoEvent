package main;
import javax.swing.JFrame;
import view.TelaInicial;
public class Main
    //cores
    // #736D4F VERDE
// #F2F2F2 BRANCO
// #593A28 MARROM
// #262626 PRETO
// #D9D3C7 BEGE
{
    public static void main(String[] args)
    {
        TelaInicial frame = new TelaInicial();
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setVisible(true);
    }
}