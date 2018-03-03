package objetos;

import java.util.List;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMPersonas implements TableModel {

    private List<Persona> personas;

    public TMPersonas(List<Persona> lista) {
        this.personas = lista;
    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String titulo = "";
        switch (columnIndex) {
            case 0:
                titulo = "Nombre";
                break;
                
            case 1:
                titulo = "Apellidos";
                break;
                
            case 2:
                titulo = "Sexo";
                break;
                
            case 3:
                titulo ="N° telefonico";
                break;
        }
        
        return titulo;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = personas.get(rowIndex);
        String valor = "";
        
        switch(columnIndex){
            case 0:
                p.getNombres();
                break;
            case 1:
                p.getApellidos();
                break;
            case 2:
                p.getSexo();
                break;
            case 3:
                p.getNumTel();
                break;
        }
        
        return valor;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Persona p = personas.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                p.setNombres(aValue.toString());
                break;
            case 1:
                p.setApellidos(aValue.toString());
                break;
            case 2:
                p.setSexo(aValue.toString());
                break;
            case 3:
                p.setNumTel(aValue.toString());
                break;
        }
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }

}
