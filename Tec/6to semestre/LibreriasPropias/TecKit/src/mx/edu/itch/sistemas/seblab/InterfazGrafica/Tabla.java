package mx.edu.itch.sistemas.seblab.InterfazGrafica;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JScrollPane {

    /**
     * Atributo y conponente grafico principal.
     */
    private JTable tabla;

    /**
     * Modelo para la tabla.
     */
    private DefaultTableModel modelo;

    /**
     * Crea una tabla contenida en un <code>JScrollPane</code>.
     *
     * @param columnas arreglo de objetos para el encabezado de las columnas
     * @param filas numero de filas que tendra la tabla
     */
    public Tabla(String[] columnas, int filas, Color borde) {
        modelo = new DefaultTableModel(columnas, filas);
        tabla = new JTable(modelo);

        if (borde != null) {
            this.setBorder(BorderFactory.createLineBorder(borde));
        }else{
            this.setBorder(BorderFactory.createLineBorder(borde, 2));
        }

        tabla.setRowHeight(18);
        
        this.setViewportView(tabla);
    }

    public void vaciarTabla() {
        modelo.setRowCount(0);
    }

    public void agregarFila(Object[] array) {
        modelo.addRow(array);
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
    
}
