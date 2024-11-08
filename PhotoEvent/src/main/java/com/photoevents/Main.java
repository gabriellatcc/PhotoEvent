package com.photoevents;
import view.TelaInicial;
import view.TelaMenu;
import controllers.StatusMain;
//cores
// #736D4F VERDE
// #F2F2F2 BRANCO
// #593A28 MARROM
// #262626 PRETO
// #D9D3C7 BEGE

public class Main {
    public static void main(String[] args) {
        // Inicializa o statusLogin com o valor de 'resposta' (se o usuário foi ou não logado)
        boolean resposta = false; // Aqui, você pode ajustar o valor para refletir o estado do login real
        StatusMain statusLogin = new StatusMain(resposta);

        // Verifica se o usuário está logado e abre a tela correspondente
        if (statusLogin.isLogado()) {
            // Se estiver logado, abre a TelaMenu
            TelaMenu telaMenu = new TelaMenu();
            telaMenu.setLocationRelativeTo(null);
            telaMenu.setVisible(true);
        } else {
            // Se não estiver logado, abre a TelaInicial
            TelaInicial frame = new TelaInicial();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}