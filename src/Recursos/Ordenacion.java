
package Recursos;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Ordenacion {

//Ordenar por titulo usando burbuja (interno)
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
    
    //ordenar por año usando insercion (interno)
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
    
    //IMPLLEMENTAR EL METODO DE ORDENACION EXTERNA SORT (externo)
    public static void mergeSortPrestamosPorFecha(String archivo){        
    //Leer prestamos enmemoria
        List<String> prestamos = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null){
            prestamos.add(linea);
            }
        }catch (IOException e){
            System.out.println("Error al leer el archivo : " + e.getMessage());
        }if(prestamos.isEmpty()){
           System.out.println("No hay prestamos registrados en el archivo");
           return;
       }
       
       //ORDENAR POR FECHA dd-mm-aaaa
       Collections.sort(prestamos, new Comparator<String>(){
        @Override
        public int compare(String p1, String p2){
            String[] d1 = p1.split(",");
            String[] d2 = p2.split(",");
            return d1[d1.length - 1].compareTo(d2[d2.length - 1]);
        }
        });
        
        //GUARDAR ARCHIVO ORDENADO
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/prestamos_ordenados.txt"))) {           
            for (String prestamo : prestamos) {
            bw.write(prestamo);
            bw.newLine();
        }
            System.out.println("Préstamos ordenados por fecha -> archivo: prestamos_ordenados.txt");
            
            //Ademas mostrar en consola
            System.out.println("\n---Prestamos por fecha-----");
            for(String prestamo :prestamos){
                //N- Para dar formato
                System.out.print("\n" + prestamo);
            }
        } catch (IOException e) {
        System.out.println("Error en ordenación externa: " + e.getMessage());
    }
 }
    }



