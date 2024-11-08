package controllers;

public class StatusLogin {
    private boolean logado;

    public StatusLogin(boolean logado) {
        this.logado = logado;
    }

    public boolean estaLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
}