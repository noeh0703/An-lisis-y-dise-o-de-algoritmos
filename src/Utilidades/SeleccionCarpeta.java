
package Utilidades;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SeleccionCarpeta 
{ private static String rutaCarpeta = "";


//ABRIR DIALOGO Y GUARDAR RUTA SELECCIONADA
public static void elegirCarpeta(){
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Selecciona los archivos donde estan los archivos .txt");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    
    int opcion = chooser.showOpenDialog(null);
    if(opcion == JFileChooser.APPROVE_OPTION){
        File carpeta = chooser.getSelectedFile();
        rutaCarpeta = carpeta.getAbsolutePath();
        System.out.println("Carpeta seleccionada : " + rutaCarpeta);
    }else {
        System.out.println("No se selecciono carpeta, el programa terminara");
        System.exit(0);
        }
    }   
    //OBTENER LA RUTA COMPLETA DEL ARCHIVO
    public static String getRutaArchivo(String nombreArchivo){
        File archivo = new File(rutaCarpeta, nombreArchivo);
        
        try{
            if(!archivo.exists()){
                archivo.createNewFile(); //lo creara vasio si no existe
                System.out.println("Archivo creado : " + archivo.getAbsolutePath());                
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return archivo.getAbsolutePath();
        }    
    }
