import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int opcion;
        String nombre;
        String telefono;

        AgendaTelefonica agenda = new AgendaTelefonica();

        while (true) {
            mostrarMenuOpciones();
            opcion = leerOpcion();

            if(opcion == 4) {
                break;
            }

            switch (opcion) {
                case 1:
                    nombre = leerNombre();
                    telefono = leerTelefono();

                    agenda.agregarContacto(new Contacto(nombre, telefono));
                    break;

                case 2:
                    if (agenda.estaVacia()){
                        System.out.println("No hay contactos registrados");
                        break;
                    }    

                    String nombrePorBuscar = leerNombre();
                    Contacto encontrado = agenda.buscarContacto(nombrePorBuscar);

                    if (encontrado != null){
                        System.out.println(encontrado.toString());
                    }

                    else {
                        System.out.println("Contacto no encontrado");
                    }

                    break;

                case 3:
                    if(agenda.estaVacia()){
                        System.out.println("No hay contactos registrados");
                        break;
                    }

                    System.out.println("Contactos registrados:");
                    agenda.mostrarContactos();
                    System.out.println();
                    break;
            }       
        }
        entrada.close();
    }

    public static void mostrarMenuOpciones() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Mostrar todos los contactos");
        System.out.println("4. Salir del programa");
    }

    public static int leerOpcion() throws IOException {
        int opcion = 0;
        boolean esInvalido = true;

        while (esInvalido) {
            try {
                System.out.print("\nIngresa una opción: ");
                opcion = Integer.parseInt(entrada.readLine());

                while (opcion < 1 || opcion > 4) {
                    System.out.print("Opción ingresada no existe, intentarlo nuevamente: ");
                    opcion = Integer.parseInt(entrada.readLine());
                }

                esInvalido = false;
    
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, volver a intentarlo");
            }
        }
        return opcion;
    }


    public static String leerNombre() throws IOException {
        System.out.print("Ingresa el nombre del contacto: ");
        return entrada.readLine().trim();
    }

    public static String leerTelefono() throws IOException {
        System.out.print("Ingresa el número de telefono del contacto: ");
        return entrada.readLine();
    }
}
