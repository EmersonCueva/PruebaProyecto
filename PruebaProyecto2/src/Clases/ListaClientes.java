//Esta clase implementara las listas del tipo cliente, para guardar cada dato del cliente en listas

package Clases;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class ListaClientes {
    private LinkedList <Clientes> clientes;
    
    
    //Metodo para agregar clientes a la lista
    public void agregar(Clientes cliente){
        clientes.add(cliente);
    }
    
    //Metodo para eliminar clientes de la lista
    public void eliminar(int in){
        clientes.remove(in);
    }
    
    //Metodo para conocer cuantos clientes han sido ingresados
    public int total(){
        return clientes.size();
    }
    
    public Clientes obtener (int in){
        return clientes.get(in);
    }
    
    
    public void cargarClientes() throws FileNotFoundException{
        //Crea clientes
        BDClientes bd = new BDClientes();
        //Obtener clientes
        clientes = bd.obtener();
    }
    
    public void imprimir(){
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).getId()+ " " + clientes.get(i).getNombre()+ " ");
        }
    }
}

