package com.photoevents;
import controllers.GerenciadorSessaoController;
import view.TelaInicial;
import view.TelaMenuAssistente;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String loggedUser = GerenciadorSessaoController.getSession();
            if (loggedUser != null && !loggedUser.isEmpty()) {
                new TelaMenuAssistente().setVisible(true);
            } else {
                new TelaInicial().setVisible(true);
            }
        });
    }
}