import java.util.HashMap;

public class AgendaTelefonica {
    //Se declara el hashmap y se inicializa inmediatamente
    //El nombre es la llave y el valor es un objeto de tipo contacto
    private HashMap<String, Contacto> contactos = new HashMap<>();

    //Método para agregar un contacto nuevo
    public void agregarContacto(Contacto contacto) {
        //Si ya existe un contacto con ese nombre se avisa y no se agrega nada
        if (this.contactos.containsKey(contacto.getNombre())) {
            System.out.println("Ya existe un contacto con ese nombre");
        }
        
        //De lo contrario, se agrega al contacto ingresado
        else {
            this.contactos.put(contacto.getNombre(), contacto);
        }
    }

    //Método para buscar un contacto por nombre
    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    //Método para mostrar todos los contactos registrados
    public void mostrarContactos() {
        contactos.values().forEach(contacto -> {
            System.out.println(contacto.toString());
        });
    }

    //Método para verificar si el hashmap está vacío
    public boolean estaVacia() {
        return contactos.isEmpty();
    }
}
