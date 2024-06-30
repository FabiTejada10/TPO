class Reserva {
    private Cliente cliente;
    private Evento evento;
    private List<String> dias;
    private boolean confirmada;

    public Reserva(Cliente cliente, Evento evento, List<String> dias) {
        this.cliente = cliente;
        this.evento = evento;
        this.dias = dias;
        this.confirmada = false;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    @Override
    public String toString() {
        return "Reserva de " + cliente.getNombre() + " para el evento " + evento.getNombre() + " en los días " + dias + (confirmada ? " (Confirmada)" : " (No confirmada)");
    }
}