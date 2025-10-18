
package Recursos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.io.*;

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
    
        // ⚙️ BÚSQUEDA SECUENCIAL EXTERNA (lee directamente desde libros.txt)
    public static String busquedaSecuencialExterna(String archivo, String tituloBuscado) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 2 && datos[1].trim().equalsIgnoreCase(tituloBuscado.trim())) {
                    return linea; // libro encontrado
                }
            }
        } catch (IOException e) {
            System.out.println("️ Error al leer el archivo: " + e.getMessage());
        }
        return null; // no encontrado
    }
     
    // BÚSQUEDA BINARIA EXTERNA (archivo debe estar ORDENADO por título)
    public static String busquedaBinariaExterna(String archivo, String tituloBuscado) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;            
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }            
        } catch (IOException e) {            
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;            
        }
        
        int inicio = 0, fin = lineas.size()-1;        
        while(inicio <= fin){
            int medio = (inicio + fin)/2;
            String[] datos = lineas.get(medio).split(",");
            if(datos.length < 2)continue;            
            int compara = datos[1].trim().compareToIgnoreCase(tituloBuscado.trim());
            if(compara == 0)            
                return lineas.get(medio);
            if(compara < 0)
                inicio = medio +1;
            else fin = medio -1;
            
        }
       
        return null;
       }
    }

