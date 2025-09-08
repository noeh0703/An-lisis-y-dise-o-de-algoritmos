
package Recursos;
import java.util.ArrayList;

public class Ordenacion {

//Ordenar por titulo usando burbuja
    public static void burbujaPorTitulo(ArrayList<Libro> libros){
        for(int i = 0; i < libros.size() - 1; i++){
            for(int j = 0; j < libros.size() - 1; j++){
                if(libros.get(j).getTitulo().compareTo(libros.get(j + 1).getTitulo())>0){
                    Libro temp = libros.get(j);
                    libros.set(j, libros.get(j + 1));
                    libros.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nlIibros ordenados por titulo (burbuja)");
        for(Libro l : libros){
            System.out.println(l);
        }
    }
    
    //ordenar por año usando insercion
    public static void insercionPorAño(ArrayList<Libro> libros){
        for(int i = 0 ; i< libros.size(); i++){
            Libro actual = libros.get(i);
            int j = i - 1;
        while (j >= 0 && libros.get(j).getAño() > actual.getAño()) {
                libros.set(j + 1, libros.get(j));
                j--;
            }
            libros.set(j + 1, actual);
        }
         System.out.println("\n Libros ordenados por año (Inserción):");
        for (Libro l : libros) {
            System.out.println(l);
        }
     }
    
    //IMPLLEMENTAR EL METODO DE ORDENACION EXTERNA SORT
 }


