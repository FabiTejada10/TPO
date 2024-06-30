class Evento extends Entrada {
    private Organizador organizador;
    private List<String> dias;

    public Evento(String nombre, String descripcion, Organizador organizador, List<String> dias) {
        super(nombre, descripcion);
        this.organizador = organizador;
        this.dias = dias;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public List<String> getDias() {
        return dias;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Descripción: " + descripcion + ", Días: " + dias + ", Organizador: " + organizador.getNombre();
    }
}