//Clase que nos permetira guardar los datos en un archivo.txt

package Archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class EstadoArchivo {
    
    //Nombre del archivo
    private String nombre;
    
    
    public EstadoArchivo(String nombre) {
        this.nombre = nombre;
    }
        
    //Obtiene el archivo .txt de la carpeta Recurso
    private File obtenerArchivo(){
       
        try{
            URL url = getClass().getClassLoader().getResource("Recursos/" +nombre);
            return new File(url.toURI());
        } catch (URISyntaxException ex){
            ex.printStackTrace();;
            return null;
        }
    }
    
    //Metoo que obtiene todo el contenido dentro del archivo
    public LinkedList<String> obtenerTextoArchivo() throws FileNotFoundException{
        LinkedList<String> lineasTxt=null; //Lineas de texto del archivo
        try{
            File archivo = obtenerArchivo(); //Obtener el archivo de texto
            if (archivo.exists()) { //Si el archivo existe
                lineasTxt=new LinkedList();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                //Leer las lineas de texto del archivo
                while ((linea = br.readLine()) !=null){
                    System.out.println(linea); //Para observar que se esta leyendo con exito
                    lineasTxt.add(linea);
                }
                br.close();
            }else{
                JOptionPane.showMessageDialog(null,"El archivo de texto no existe");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Se produjo un error");
        }
        return lineasTxt;
    }
    
    //Metodo para registrar clientes en el archivo
    public boolean registrar(String linea){
        File archivo = obtenerArchivo(); //Obtenemos el archivo de texto
        try{
        if (archivo.exists()) { //Verificar si existe el archivo
            //Registramos informacion en el archivo
            FileWriter fw = new FileWriter(archivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(linea);//Escribir el texto que es recibido en el archivo
            pw.flush();
            pw.close();
            return true;
        }
        }catch (IOException error){
            error.printStackTrace();
        }
        return false;
        }
    
    
}
