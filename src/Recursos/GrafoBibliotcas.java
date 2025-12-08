
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
    // Agregar relación entre usuario y libro
    public void agregarArista(String nodo1, String nodo2) {
        agregarNodo(nodo1);
        agregarNodo(nodo2);

        adyacencia.get(nodo1).add(nodo2);
        adyacencia.get(nodo2).add(nodo1); // grafo no dirigido
    }
}
