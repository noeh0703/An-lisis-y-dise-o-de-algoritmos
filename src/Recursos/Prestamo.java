
package Recursos;

public class Prestamo 
{
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;

    // Constructor
    public Prestamo(Usuario usuario, Libro libro, String fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
    }
   
// GETTERS Y SETTERS

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    
    //Mostrar prestamos
    @Override
    public String toString(){
        return "Prestamo -> Usuario: " + usuario.getNombre() + "| Libro : " + libro.getTitulo() + "| Fecha : " + fechaPrestamo;
    }
}
