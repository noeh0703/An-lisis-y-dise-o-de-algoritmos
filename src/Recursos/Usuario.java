
package Recursos;

public class Usuario 
{
    private String dni;
    private String nombre;
    private int telefono;
 //CONSTRUCTOR
    public Usuario(String dni, String nombre, int telefono){
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }
   //GETTERS Y SETTERS

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    //MOSTRAR USUARIO
   @Override
   public String toString() {
       return dni + " - " + nombre;
   }
}
