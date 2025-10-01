
package Recursos;
import java.io.*;
import java.util.ArrayList;

public class GestorArchivos 
{   //asegurar la existencia d ela carpet dat
    private static void crearCarpetaData(){
     File carpeta = new File("data");
     if(!carpeta.exists()){
         carpeta.mkdir();
     }
    }    
    
   //LIBRO 
    //añade un libro a libros.txt
    public static void guardarLibro(Libro libro){
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/libros.txt", true))) {
        bw.write(libro.getIsbn() + "," + 
                 libro.getTitulo() + "," + 
                 libro.getAutor() + "," + 
                 libro.getEditorial() + "," + 
                 libro.getCategoria() + "," + 
                 libro.getVersion() + "," +
                 libro.getAño());
        bw.newLine();
    } catch (IOException e){
        System.out.println("Error al guardar libro: " + e.getMessage());
    }
}
    
    //carga todos los libros en memoria
    public static ArrayList<Libro> leerLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/libros.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if (datos.length == 7){
                    Libro libro = new Libro(
                    datos[0], 
                    datos[1],
                    datos[2],
                    datos[3],
                    datos[4],
                    Integer.parseInt(datos[5]),
                    Integer.parseInt(datos[6])
                            );
                    libros.add(libro);
                }
            }
        } catch(IOException e){
            System.out.println("Error al leer libros: " + e.getMessage());
        }
        return libros;
    }
    
    //USUARIOS
    //añade un usuario a usuarios.txt
    public static void guardarUsuario(Usuario usuario){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/usuarios.txt", true))){
            bw.write(usuario.getDni() + "," +
                    usuario.getNombre() + "," +
                    usuario.getTelefono());
            bw.newLine();
        } catch (IOException e){
            System.out.println("Erroral guardar ususario: " + e.getMessage());
        }
    }
    
    //carga todos los usuarios
    public static ArrayList<Usuario> leerUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(
         new FileReader("data/usuarios.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if(datos.length == 3){
                    Usuario usuario = new Usuario(
                    datos[0], //dni
                    datos[1], //nombre
                    Integer.parseInt(datos[2]) //telefono
                    );
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e){
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
        return usuarios;
    }
    
    //PRESTAMOS
    //añade un préstamo (guardando usuario y libro asociados)
    public static void guardarPrestamo(Prestamo prestamo) {
         try (BufferedWriter bw = new BufferedWriter(
            new FileWriter("data/prestamos.txt", true))) {
            bw.write(prestamo.getUsuario().getDni() + "," +
                     prestamo.getUsuario().getNombre() + "," +
                     prestamo.getUsuario().getTelefono() + "," +
                     prestamo.getLibro().getIsbn() + "," +
                     prestamo.getLibro().getTitulo() + "," +
                     prestamo.getFechaPrestamo());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar préstamo: " + e.getMessage());
        }
    }
    
    //reconstruye préstamos desde el archivo
    public static ArrayList<Prestamo> leerPrestamos(ArrayList<Usuario> usuarios, ArrayList<Libro> libros){
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
         new FileReader("data/prestamos.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if(datos.length == 6){
                    
            // reconsruccion de usuario y libro
            Usuario usuario = new Usuario(datos[0], datos[1], Integer.parseInt(datos[2]));
            Libro libro = null;
            for (Libro l : libros){
                if(l.getIsbn().equals(datos[3])){
                    libro = l;
                    break;
                    }
                 }
            if(libro == null){
                //si no esta en la lista creamos uno simple solo con el codigo y titulo
                libro = new Libro(datos[3], datos[4], "","","", 1, 2000);
                }
            Prestamo prestamo = new Prestamo(usuario, libro, datos[5]);
            prestamos.add(prestamo);
               }
            }
        } catch (IOException e){
            System.out.println("Error al leer prestamos: " + e.getMessage());
        }
        return prestamos;
    }
}
