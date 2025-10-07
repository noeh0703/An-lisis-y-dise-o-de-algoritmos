
package Recursos;
import java.util.ArrayList;
import java.util.HashMap;


public class Busqueda {
    //BUSQUEDA SECUENCIAL (memoria) interna
    public static Libro busquedaSecuencial(ArrayList<Libro> libros, String tituloBuscado){
        for(Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(tituloBuscado.trim())){
                return libro; //lo encontro
            }
        }
        return null;//no lo encontro
    }
    
    // BUSQUEDA HASH (memori interna)
        public static Usuario busquedaHash(ArrayList<Usuario> usuarios, String dniBuscado){
        //Cargar usuarios en un HashMap (clave = DNI, valor = usuario)
        HashMap<String, Usuario> tabla = new HashMap<>();
        for(Usuario u : usuarios){
            tabla.put(u.getDni(), u);
        }
       
    //retornar el usuario directamente si es que existe
        return tabla.get(dniBuscado);
    }
        //BUSQUEDA EXTERNA
        
}
