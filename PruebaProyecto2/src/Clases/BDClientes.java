/* Clase intermedia que se encargara de obtener
los datos del archivo.txt y darle el formato 
adecuado para presentarlo en el programa
*/
package Clases;

import Archivo.EstadoArchivo;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BDClientes {
    
    //Devuelve la lista de clientes del archivo
    public LinkedList<Clientes> obtener() throws FileNotFoundException{
        LinkedList<Clientes> clientes = null;
        EstadoArchivo archivo = new EstadoArchivo ("clientes.txt"); //El nombre del archivo
        LinkedList<String> lineas = archivo.obtenerTextoArchivo(); //Obtener las lineas de texto
        if (lineas != null) {
            clientes = new LinkedList();
            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea,";"); //Clase para separar cada dato con un ";"
                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                String apellidos = tokens.nextToken();
                String telefono = tokens.nextToken();
                String correo = tokens.nextToken();
                String fecha = tokens.nextToken();
                String tipoSuscripcion = tokens.nextToken();
                String estado = tokens.nextToken();
                //Se a;ade a la lista enlazada clientes una nueva lista
                clientes.add(new Clientes(id, nombre, apellidos, telefono, correo, fecha, tipoSuscripcion, estado ));              
            }
        }
        return clientes;
}
    //Metodo para registrar los clientes en la base de datos txt
public boolean registrarCliente(Clientes c){
    EstadoArchivo archivo = new EstadoArchivo ("clientes.txt");
    return archivo.registrar(c.getId() + ";"
            + c.getNombre() + ";"
            + c.getApellidos() + ";"
            + c.getTelefono() + ";"
            + c.getCorreo() + ";"
            + c.getFecha() + ";"
            + c.getTipoSuscripcion() + ";"
            + c.getEstado());
}
    
}
