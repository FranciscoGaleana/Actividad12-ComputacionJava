import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    //Buffer para leer entrada de datos
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //Declaracion de variables
        int opcion;
        String nombre;
        String telefono;

        //Instanciando objeto de tipo AgendaTelefonica
        AgendaTelefonica agenda = new AgendaTelefonica();

        //Ciclo infinito para mostrar menu hasta que el usuario desee salir
        while (true) {
            //Se imprime menu de opciones y se lee la opcion ingresada
            mostrarMenuOpciones();
            opcion = leerOpcion();

            //El usuario ha escogido terminar el programa
            if(opcion == 4) {
                break;
            }
            
            //Switch para manejar escenarios segun la opcion ingresada
            switch (opcion) {
                case 1:
                    //Leer nombre y numero de telefo
                    nombre = leerNombre();
                    telefono = leerTelefono();

                    //Agregar objeto Contacto a la agenda (HashMap)
                    agenda.agregarContacto(new Contacto(nombre, telefono));
                    break;

                case 2:
                    //Validar que la agenda no este vacia
                    if (agenda.estaVacia()){
                        System.out.println("No hay contactos registrados");
                        break;
                    }    

                    //Leyendo nombre del contacto a buscar
                    String nombrePorBuscar = leerNombre();
                    Contacto encontrado = agenda.buscarContacto(nombrePorBuscar);

                    //Si el nombre ingresado se encontro, se muestra su numero de telefono
                    if (encontrado != null){
                        System.out.println(encontrado.toString());
                    }
                    
                    //De lo contrario se indica que no se encontro
                    else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;

                case 3:
                    //Validar que la agenda no este vacia
                    if(agenda.estaVacia()){
                        System.out.println("No hay contactos registrados");
                        break;
                    }

                    //Mostrar contactos registrados
                    System.out.println("Contactos registrados:");
                    agenda.mostrarContactos();
                    break;
            }       
        }
        //Se cierra el buffer
        entrada.close();
    }

    // --- Funciones para simplificar logica del main() ---
    //Función para mostrar mennu de opciones
    public static void mostrarMenuOpciones() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Mostrar todos los contactos");
        System.out.println("4. Salir del programa");
    }

    //Funcion para leer opcion
    public static int leerOpcion() throws IOException {
        int opcion = 0;
        boolean esInvalido = true;

        //Ciclo que termina hasta que el numero ingresado sea valido
        while (esInvalido) {
            try {
                //Preguntando opcion
                System.out.print("\nIngresa una opción: ");
                opcion = Integer.parseInt(entrada.readLine());

                //Validando que el numero ingresado sea una opcion valida
                while (opcion < 1 || opcion > 4) {
                    System.out.print("Opción ingresada no existe, intentarlo nuevamente: ");
                    opcion = Integer.parseInt(entrada.readLine());
                }
                
                //Si el codigo llega hasta aqui es porque no se ha arrojado ninguna excepcion
                esInvalido = false;
                
            //Se maneja la posible excepcion en donde se haya ingresado una entrada diferente
            //a un numero
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, volver a intentarlo");
            }
        }
        
        //Se regresa la opcion ingresada
        return opcion;
    }


    //Funcion para leer el nombre
    public static String leerNombre() throws IOException {
        System.out.print("Ingresa el nombre del contacto: ");
        return entrada.readLine().trim();
    }

    //Funcion para leer el numero de telefono
    public static String leerTelefono() throws IOException {
        System.out.print("Ingresa el número de telefono del contacto: ");
        return entrada.readLine();
    }
}
