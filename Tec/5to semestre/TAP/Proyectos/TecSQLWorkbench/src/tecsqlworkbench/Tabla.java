package tecsqlworkbench;

import conexion.ConexionBD;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class Tabla extends JScrollPane {

    private final ConexionBD cone;
    private String tituloTabla;
    private int filasAfectadas;
    private JTable tabla;
    
    public Tabla(ConexionBD con) throws SQLException {
        this.cone = con;
        this.tabla = new JTable();
        //this.ejecutarSentencia("select * f");
        this.setViewportView(tabla);
    }

    /**
     * La tabla usa la conexión a la base de datos para obtener los datos de
     * la tabla consultada o el numero de filas afectadas.
     * @param query comando que el usuario realiza
     * @return {@code true} si el resultado es una consulta, {@code false} cuando el resultado
     * es el numero de columnas afectadas
     * @throws SQLException 
     */
    public boolean ejecutarSentencia(String query) throws SQLException {
        if(cone.ejecutar(query)){
            DefaultTableModel modelo = new DefaultTableModel(cone.getDatos(), cone.getEncabezados());
            tabla.setModel(modelo);
            tituloTabla=cone.getTituloTabla();
            return true;
        }else{
             filasAfectadas=cone.getFilasAfectada();
            return false;
        }
    }

    public String getTituloTabla() {
        return tituloTabla;
    }

    public int getFilasAfectadas() {
        return filasAfectadas;
    }
    
    public void cerrarConexion() throws SQLException{
        cone.cerrarConexion();
    }
    
}
