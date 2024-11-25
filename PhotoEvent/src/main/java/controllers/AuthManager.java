package controllers;
import models.UsuarioCRUD;

public class AuthManager {
    private UsuarioCRUD usuarioCRUD;
    public AuthManager() {
        this.usuarioCRUD = new UsuarioCRUD();
    }
    public boolean login(String email, String senha) {
        String senhaCadastrada = usuarioCRUD.getSenhaUsuario(email);
        if (senhaCadastrada != null && senhaCadastrada.equals(senha)) {
            return true;
        } else {
            return false;
        }
    }
}