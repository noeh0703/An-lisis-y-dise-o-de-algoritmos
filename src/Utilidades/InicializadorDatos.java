
package Utilidades;


public class InicializadorDatos 
{
    public static void inicializarArchivos(String rutaCarpeta){
        crearArchivoConDatos(rutaCarpeta, "usuario.txt",  "12345678,Juan Perez,987654321\n" +
                "87654321,Ana Torres,912345678\n");
    }
}
