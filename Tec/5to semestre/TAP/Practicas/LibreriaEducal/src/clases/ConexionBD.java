package clases;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private String url = "jdbc:mysql://localhost:3306/educal?serverTimezone=Mexico/General";
    private static Connection con;
    private Statement st;
    private ResultSet rs;
    private String usuario = "javaUser";
    private String contrasena = "cafejava";

    public ConexionBD(String user, String contra) throws ClassNotFoundException, SQLException {
        this.usuario = user;
        this.contrasena = contra;

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, usuario, contrasena);
    }

    public static Connection getCon() {
        return con;
    }

    public Connection conexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(url, usuario, contrasena);

        return con;
    }
}
