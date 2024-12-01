package controllers;

public class EventoController {
    private String titulo;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String tipo; // Tipo de evento (ex: aniversário, casamento)
    private String endereco;
    private double duracao; // Duração do evento em horas
    private String horarioInicio;
    private String horarioFinal; // Adicionado
    private String tempoEstimadoEdicao; // Tempo estimado de edição
    private String dataEvento;

    private String categoria; // Adicionado
    private String local; // Adicionado
    private String servico; // Foto ou filmagem
    private String telefone; // Adicionado
    private String metodoPagamento; // Cartão, pix, dinheiro
    private String parcelamento; // Sim ou não

    private double valorPagamento; // Total a ser pago pelo serviço

    // Getters e setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }

    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFinal() { // Adicionado
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) { // Adicionado
        this.horarioFinal = horarioFinal;
    }

    public String getTempoEstimadoEdicao() {
        return tempoEstimadoEdicao;
    }

    public void setTempoEstimadoEdicao(String tempoEstimadoEdicao) {
        this.tempoEstimadoEdicao = tempoEstimadoEdicao;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(String parcelamento) {
        this.parcelamento = parcelamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public boolean isEmpty() {
        return (titulo == null || titulo.trim().isEmpty()) &&
                (nomeCliente == null || nomeCliente.trim().isEmpty()) &&
                (sobrenomeCliente == null || sobrenomeCliente.trim().isEmpty()) &&
                (tipo == null || tipo.trim().isEmpty()) &&
                (endereco == null || endereco.trim().isEmpty()) &&
                duracao == 0 &&
                (horarioInicio == null || horarioInicio.trim().isEmpty()) &&
                (tempoEstimadoEdicao == null || tempoEstimadoEdicao.trim().isEmpty()) &&
                (dataEvento == null || dataEvento.trim().isEmpty()) &&
                (servico == null || servico.trim().isEmpty()) &&
                (metodoPagamento == null || metodoPagamento.trim().isEmpty()) &&
                (parcelamento == null || parcelamento.trim().isEmpty()) &&
                valorPagamento == 0;
    }
}
