
package Utilidades;
import java.io.*;

public class InicializadorDatos 
{
    public static void inicializarArchivos(String rutaCarpeta){
        crearArchivoConDatos(rutaCarpeta, "usuario.txt",  "12345678,Juan Perez,987654321\n" +
                "87654321,Ana Torres,912345678\n");
        crearArchivoConDatos(rutaCarpeta, "libros.txt",
                "001,El Quijote,Miguel de Cervantes,Anaya,Novela,1,1605\n" +
                "002,Cien años de soledad,Gabriel Garcia Marquez,Sudamericana,Novela,1,1967\n");

        crearArchivoConDatos(rutaCarpeta, "prestamos.txt",
                "12345678,Juan Perez,987654321,001,El Quijote,2025-09-11\n");
    }
    
    public static void crearArchivoConDatos(String rutaCarpeta, String nombreArchivo, String contenido){
        File archivo = new File(rutaCarpeta + File.separator + nombreArchivo);
        if(!archivo.exists()){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
                bw.write(contenido);
                System.out.println("Archivo creado : " + archivo.getName());
            } catch (IOException e) {
                System.out.println("Error al crear " + nombreArchivo + " : " + e.getMessage());
            }
        }
    }
}
