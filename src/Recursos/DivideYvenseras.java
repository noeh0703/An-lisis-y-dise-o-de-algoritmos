
package Recursos;
import java.util.ArrayList;
import java.util.Collections;
public class DivideYvenseras {
    //QUICK-SORT ordenr por titulo
    public static void quickSortLibros(ArrayList<Libro> libros, int inicio, int fin){
        if(inicio < fin){
            int indicePivote = particion(libros, inicio, fin);
            //lamada recursiva para ordenar las sublistas
            quickSortLibros(libros, inicio, indicePivote -1);
            quickSortLibros(libros, indicePivote + 1, fin);
        }
    }
}
