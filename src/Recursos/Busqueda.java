
package Recursos;
import java.util.ArrayList;
import java.util.HashMap;
public class Busqueda {
    //BUSQUEDA SECUENCIAL (memoria) interna
    public static Libro busquedaSecuencial(ArrayList<Libro> libros, String tituloBuscado){
        for(Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(tituloBuscado)){
                return libro; //lo encontro
            }
        }
        return null;//no lo encontro
    }
    // BUSQUEDA HASH (memori interna)
    
}
