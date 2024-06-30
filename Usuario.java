abstract class Usuario {
    protected String nombre;
    protected String email;
    protected String contraseña;

    public Usuario(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }
}