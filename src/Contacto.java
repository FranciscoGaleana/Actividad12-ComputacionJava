public class Contacto {
    //Declaracion de atributos
    private String nombre;
    private String telefono;

    //Constructor
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // --- GETTERS y SETTERS ---
    //Getter y Setter de atributo nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter y Setter de atributo telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Sobreescritura de metodo toString para mostrar valores de los atributos del objeto
    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", telefono=" + telefono + "]";
    }
}
