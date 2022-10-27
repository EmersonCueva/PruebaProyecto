//Modelo para ingresar datos en la tabla
package Clases;
import java.io.FileNotFoundException;
import javax.swing.DefaultListModel;
import javax.swing.table.AbstractTableModel;

public class ModeloClientes extends AbstractTableModel{
    
    /*Constructor que crea una lista de clientes y los carga del archivo para
    Mostrarlos en la tabla
    */
    private ListaClientes clientes;

    public ModeloClientes() throws FileNotFoundException{
        clientes= new ListaClientes();
        clientes.cargarClientes();
    }
    
    @Override
    public int getRowCount() {
        return clientes.total();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clientes aux = clientes.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getId();
            case 1: return aux.getNombre();
            case 2: return aux.getApellidos();
            case 3: return aux.getTelefono();
            case 4: return aux.getCorreo();
            case 5: return aux.getFecha();
            case 6: return aux.getTipoSuscripcion();
            default: return aux.getEstado();
        }
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Apellidos";
            case 3: return "Telefono";
            case 4: return "Correo";
            case 5: return "Fecha";
            case 6: return "Suscripcion";
            default: return "Estado";
        }
    }
    
    @Override
    public Class getColumnClass(int col){
        switch(col){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            case 5: return String.class;
            case 6: return String.class;
            default: return String.class;
            
        }
    }
    
    @Override
    public boolean isCellEditable (int wor, int col){
        return true;
    }
    
     @Override
    public void setValueAt(Object value, int fila, int columna) {
        Clientes aux = clientes.obtener(fila);
        switch(columna){
            case 0: aux.setId((int)value);
                    break;  //getId();
            case 1: aux.setNombre((String)value);
            case 2: aux.setApellidos((String)value);
            case 3: aux.setTelefono((String)value);
            case 4: aux.setCorreo((String)value);
            case 5: aux.setFecha((String)value);
            case 6: aux.setTipoSuscripcion((String)value);
            default: aux.setEstado((String)value);
        }
        fireTableCellUpdated(fila,columna);
    }
    
    public void agregarClientes(Clientes cliente){
        clientes.agregar(cliente);
        this.fireTableDataChanged();
    }
    
        
        public void eliminarClientes(int ind){
        clientes.eliminar(ind);
        this.fireTableDataChanged();
         }
        //Funcion para validar la existencia del registro del id en la lista
        public boolean ExisteEnLista(DefaultListModel modelLista, String dto){
            boolean bandera = false;
            for (int i =0;i<modelLista.getSize();i++){
                bandera=true;
            }
            return bandera;
        }

    public void removeTableModelListener(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    