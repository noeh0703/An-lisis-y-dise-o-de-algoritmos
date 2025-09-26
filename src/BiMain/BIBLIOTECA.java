
package BiMain;
import Recursos.*;
import java.util.ArrayList;
import java.util.Scanner;
import Utilidades.SeleccionCarpeta;
public class BIBLIOTECA {
 private static Scanner input = new Scanner(System.in);
 
 ////METODOS/////
 public void mostrarMenu() {
    int opcion;
    do {
        System.out.println("\n--- MENÚ BIBLIOTECA ---");
        System.out.println("=> 1. Registrar Libro");
        System.out.println("=> 2. Registrar Usuario");
        System.out.println("=> 3. Registrar Préstamo");
        System.out.println("=> 4. Mostrar Préstamos");
        System.out.println("=> 5. Ordenación de Libros");
        System.out.println("=> 6. Busquedas");
        System.out.println("=> 0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = input.nextInt();
        input.nextLine();

        switch (opcion) {
            case 1: registrarLibro(); break;
            case 2: registrarUsuario(); break;
            case 3: registrarPrestamo(); break;
            case 4: mostrarPrestamos(); break;
            case 5: menuOrdenacion(); break;
            case 6: menuBusqueda(); break;
            case 0: System.out.println("Saliendo..."); break;
            default: System.out.println("Opción no válida");
        }
    } while (opcion != 0);
}
 private static void registrarLibro(){
     System.out.print("ISBN: ");
     String isbn = input.nextLine();
     System.out.print("Titulo: ");
     String titulo = input.nextLine();
     System.out.print("Autor: ");
     String autor = input.nextLine();
     System.out.print("Editorial: ");
     String editorial = input.nextLine();
     System.out.print("Caregoria: ");
     String categoria = input.nextLine();
     System.out.print("Version(nuemero entero): ");
     int version = input.nextInt();
     System.out.print("Año de publiacion: ");
     int año = input.nextInt();
     input.nextLine(); //Limpiar
     
     Libro libro = new Libro(isbn, titulo, autor, editorial, categoria, version, año);
     GestorArchivos.guardarLibro(libro);
     System.out.println("Libro registrado correctamente");
 }
 
 private static void registrarUsuario(){
     System.out.print("DNI: ");
     String dni = input.nextLine();
     System.out.print("Nombre: ");
     String nombre = input.nextLine();
     System.out.print("Telefono: ");
     int telefono = input.nextInt();
     input.nextLine();
     
     Usuario usuario = new Usuario(dni, nombre, telefono);
     GestorArchivos.guardarUsuario(usuario);
     System.out.print("Usuario registrado exitosamente");
 }
 
 private static void registrarPrestamo(){
 ArrayList<Usuario> usuarios = GestorArchivos.leerUsuarios();
 ArrayList<Libro> libros = GestorArchivos.leerLibros();
 
 System.out.print("DNI del usuario: ");
 String dni = input.nextLine();
 Usuario usuario = null;
    for(Usuario u : usuarios){
        if(u.getDni().equals(dni)){
            usuario = u;
            break;
                }
            }
    if(usuario == null){
        System.out.println("Usuario no encontrado");
        return;
        }
    
 System.out.print("ISBN del libro: ");
 String isbn = input.nextLine();
 Libro libro = null;
    for(Libro l : libros){
        if(l.getIsbn().equals(isbn)){
            libro = l;
            break;
        }
    }
    if(libro == null){
        System.out.println("Libro no encontrado");
        return;
        }
    System.out.print("Fecha de prestamo (dd-mm-aaaa): ");
            String fecha = input.nextLine();
            
    Prestamo prestamo = new Prestamo(usuario, libro, fecha);
    GestorArchivos.guardarPrestamo(prestamo);
    System.out.println("Prestamo restrado correctamente");
    }
 
 private static void mostrarPrestamos(){
     ArrayList<Usuario> usuarios = GestorArchivos.leerUsuarios();
     ArrayList<Libro> libros = GestorArchivos.leerLibros();
     ArrayList<Prestamo> prestamos = GestorArchivos.leerPrestamos(usuarios, libros);
     
     System.out.println("\n----LISTA DE PRESTAMOS----");
     for(Prestamo p : prestamos){
         System.out.println(p);
     }
 }
 
 private static void menuOrdenacion(){
     ArrayList<Libro> libros = GestorArchivos.leerLibros();
     if(libros.isEmpty()){
         System.out.println("No hay libros registrados");
         return;
    }
     System.out.println("\n----ORDENACION DE LIBROS----");
      System.out.println("=> 1. Ordenar por Título (Burbuja)");
        System.out.println("=> 2. Ordenar por Año (Inserción)");
        System.out.println("=> 3. Ordenar por editorial (sort)");
        System.out.print("Seleccione una opción: ");
        int opcion = input.nextInt();
        input.nextLine();
        
        switch (opcion){
            case 1: 
                Ordenacion.burbujaPorTitulo(libros);
                break;
            case 2: 
                Ordenacion.insercionPorAño(libros);
                break;
            default: 
                System.out.println("Opcion no valida");
        }
    }
 private static void menuBusqueda(){
     System.out.println("-------------BUSQUEDAS----------");
     System.out.println("=> 1. Buscar libro por titulo (secuencial");
     System.out.println("=> 2. Buscar usuario por DNI (Hash)");
     System.out.println("Seleccione una opcion : ");
     int opcion = input.nextInt();
     input.nextLine();
     
     switch(opcion){
         case 1: 
             ArrayList<Libro> libros = GestorArchivos.leerLibros();
             System.out.print("Ingrese el titulo del libro: ");
             String titulo = input.nextLine();
             Libro libroEncotrado = Busqueda.busquedaSecuencial(libros, titulo);
             break;
         case 2: 
             ArrayList<Usuario> usuarios = GestorArchivos.leerUsuarios();
             System.out.print("Ingrese el DNI: ");
             String dni = input.nextLine();
             Usuario dniEncontrado = B
     }
 }
 
 ///////METODO/////
    public static void main(String[] args) 
    {
        //SELECCIONAR CARPETA DE DATOS
        SeleccionCarpeta.elegirCarpeta();
        
        //INICIAR MENU
        BIBLIOTECA app = new BIBLIOTECA();
        app.mostrarMenu();
        }
    }

