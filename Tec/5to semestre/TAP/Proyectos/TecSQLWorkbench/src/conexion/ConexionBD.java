package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase que se conecta a la base de datos y ejecuta los query para devolver los
 * datos que resulten a una tabla.
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ConexionBD {

    /**
     * Se refiere a la direccion del servidor del SGBD con sus opciones correspondientes
     */
    private final String url = "jdbc:mysql://localhost:3306/investigadores?serverTimezone=Mexico/General";
    /**
     * El usuario que tenga permitido entrar a la base de datos
     */
    private final String usuario = "javaUser";
    /**
     * La contraseña con la que se debe identificar el usuario
     */
    private final String contrasena = "cafejava";
    /**
     * El objecto {@code Connection} que realiza la conexión con la BD.
     */
    private final Connection con;
    /**
     * Prepara los comandos para después ejecutarlos.
     */
    private Statement st;
    /**
     * Si el {@code Statement} es una consulta, sera pertinente guardarlo en este tipo de objeto
     */
    private ResultSet rs;
    /**
     * Este objeto obtiene los datos de la tabla que se consulta
     */
    private ResultSetMetaData rsmd;
    /**
     * El titulo de la tabla consultada
     */
    private String tituloTabla;
    /**
     * Un arreglo con los encabezados de la tabla consultada
     */
    private Object[] encabezados;
    /**
     * Una matriz con los datos obtenidos de la tabla.
     */
    private Object[][] datos;
    /**
     * Numero de filas afectadas en una sentencia que no fuera una consulta
     */
    private int filasAfectada;
    /**
     * El nombre de la base de datos.
     */
    private String nombreDB;

    /**
     *  Crear la conexión hacia la base de datos y obtiene el nombre de esta    
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ConexionBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, usuario, contrasena);
        nombreDB = con.getCatalog();
    }

    /**
     *
     * El try-catch lo que hace es atrapar la excepcion y diferenciar entre una
     * consulta(select,show tables todo lo que devuelta un {@code ResulSet}) y
     * todo lo demas (insert,update,delete, todo lo que no devuelve un
     * {@code ResulSet})
     *
     * @param query es el comando que el usuario realiza.
     * @return {@code true} cuando es una consulta y {@code false} cuando es
     * otro cosa.
     * @throws SQLException
     */
    public boolean ejecutar(String query) throws SQLException {
        ArrayList<Object[]> lista = new ArrayList<>();
        rs = null;
        st = con.createStatement();

        try {
            rs = st.executeQuery(query);
            rsmd = rs.getMetaData();

            encabezados = new Object[rsmd.getColumnCount()];

            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                encabezados[i] = rsmd.getColumnName(i + 1);
            }

            while (rs.next()) {
                Object[] array = new Object[rsmd.getColumnCount()];
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    array[i] = rs.getObject(i + 1);
                }
                lista.add(array);
            }

            datos = new Object[lista.size()][encabezados.length];
            for (int i = 0; i < lista.size(); i++) {
                Object[] array = lista.get(i);
                for (int j = 0; j < encabezados.length; j++) {
                    datos[i][j] = array[j];
                }
            }

            tituloTabla = rsmd.getTableName(1);

            return true;
        } catch (SQLException ex) {
            filasAfectada = st.executeUpdate(query);
            return false;
        }catch(NullPointerException e){
            return false;
        }
    }
    
    public void cerrarConexion() throws SQLException{
        con.close();
    }

    public Object[] getEncabezados() {
        return encabezados;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public String getTituloTabla() {
        return tituloTabla;
    }

    public int getFilasAfectada() {
        return filasAfectada;
    }

    public String getNombreDB() {
        return nombreDB;
    }

}
