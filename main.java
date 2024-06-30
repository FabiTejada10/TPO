import java.util.*;

public class main {
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();
        try {
            iniciarSesion();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void inicializarDatos() {
        // Datos de prueba
        usuarios.put("cliente@correo.com", new Cliente("Cliente", "cliente@correo.com", "1234"));
        usuarios.put("organizador@correo.com", new Organizador("Organizador", "organizador@correo.com", "1234"));
    }

    private static void iniciarSesion() throws Exception {
        System.out.println("Bienvenido al sistema de conciertos con hospedaje.");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuario = Optional.ofNullable(usuarios.get(email))
                                  .orElseThrow(() -> new Exception("Usuario no encontrado."));

        if (usuario.validarContraseña(contraseña)) {
            if (usuario instanceof Cliente) {
                menuCliente((Cliente) usuario);
            } else if (usuario instanceof Organizador) {
                menuOrganizador((Organizador) usuario);
            }
        } else {
            throw new Exception("Contraseña incorrecta.");
        }
    }

    private static void menuCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("1. Reservar evento");
            System.out.println("2. Ver reservas");
            System.out.println("3. Confirmar reserva");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    // Implementar la reserva de evento
                    break;
                case 2:
                    cliente.verReservas();
                    break;
                case 3:
                    // Implementar la confirmación de reserva
                    break;
                case 4:
                    // Implementar la cancelación de reserva
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void menuOrganizador(Organizador organizador) {
        int opcion;
        do {
            System.out.println("1. Crear evento");
            System.out.println("2. Ver eventos organizados");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del evento: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción del evento: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Días del evento (separados por comas): ");
                    List<String> dias = Arrays.asList(scanner.nextLine().split(","));
                    organizador.crearEvento(nombre, descripcion, dias);
                    break;
                case 2:
                    organizador.verEventosOrganizados();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}