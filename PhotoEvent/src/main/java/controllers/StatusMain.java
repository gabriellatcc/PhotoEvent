package controllers;

public class StatusMain {
    private StatusLogin statusLogin;

    public StatusMain(boolean resposta) {
        this.statusLogin = new StatusLogin(resposta);
    }

    public boolean isLogado() {
        return statusLogin.estaLogado();
    }
}