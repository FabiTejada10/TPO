class Cliente extends Usuario {
    private List<Reserva> reservas;

    public Cliente(String nombre, String email, String contraseña) {
        super(nombre, email, contraseña);
        this.reservas = new ArrayList<>();
    }

    public void reservarEvento(Evento evento, List<String> dias) {
        Reserva reserva = new Reserva(this, evento, dias);
        reservas.add(reserva);
        System.out.println("Reserva realizada para el evento: " + evento.getNombre());
    }

    public void verReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No tienes reservas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    public void confirmarReserva(Reserva reserva) {
        reserva.setConfirmada(true);
        System.out.println("Reserva confirmada.");
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
        System.out.println("Reserva cancelada.");
    }
}