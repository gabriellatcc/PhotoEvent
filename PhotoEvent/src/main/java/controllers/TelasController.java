package controllers;

import models.UsuarioCRUD;
import view.*;

import javax.swing.*;

public class TelasController {
    private String email;

    public TelasController(String email) {
        this.email = email;
    }

    public void abrirMenu() {
        UsuarioCRUD usuarioCRUD = new UsuarioCRUD();

        String status = usuarioCRUD.getStatusUsuario(email);
        if ("pendente".equalsIgnoreCase(status)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Sua solicitação ainda não foi avaliada pelo administrador.",
                    "Acesso Negado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String cargo = usuarioCRUD.getCargoUsuario(email);
        if (cargo == null) {
            System.out.println("Email não registrado ou erro ao buscar cargo.");
            return;
        }

        switch (cargo.toLowerCase()) {
            case "administrador":
                new TelaMenuAdmin().setVisible(true);
                break;

            case "assistente geral":
                new TelaMenuAssistente().setVisible(true);
                break;

            default:
                System.out.println("Cargo não reconhecido: " + cargo);
                break;
        }
    }
}