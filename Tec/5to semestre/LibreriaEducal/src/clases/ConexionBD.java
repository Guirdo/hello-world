package clases;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private String nombreBD = "educal";
    private String url = "jdbc:mysql://localhost:3306/"+nombreBD;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String usuario = "";
    private String contrasena = "";
    
    public ConexionBD(String user,String contra){
        this.usuario=user;
        this.contrasena=contra;
    }
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
