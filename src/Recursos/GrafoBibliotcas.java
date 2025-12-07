
package Recursos;
import java.util.*;
//grafos para el avance de la siguiente unidad
public class GrafoBibliotcas {
    //Lista de abyacencia
    private Map<String, List<String>> adyacencia;
    
    public Grafo(){
        adyacencia = new HashMap<>();
    }
    
    //asegurar que el nodo exista en el grafo
    public void agregarNodo(String nodo) {
        adyacencia.putIfAbsent(nodo, new ArrayList<>());
    }
}
