package tecsqlworkbench;

import conexion.ConexionBD;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Arbol extends JScrollPane {

    private ConexionBD cone;
    private JTree arbol;

    public Arbol(ConexionBD con) throws SQLException {
        this.cone = con;
        this.arbol = new JTree();
        this.actualizarArbol();

        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#283747")));

        this.setViewportView(arbol);
    }

    private void actualizarArbol() throws SQLException {
        ArrayList<DefaultMutableTreeNode> tablas = new ArrayList<>();
        DefaultMutableTreeNode bd = new DefaultMutableTreeNode(cone.getNombreDB());
        String comando;
        
        //cone.ejecutar("show databases");

        cone.ejecutar("show tables");
        Object[][] array = cone.getDatos();

        for (int i = 0; i < array.length; i++) {
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(array[i][0]);
            tablas.add(nodo);
            bd.add(tablas.get(i));
        }

        for (int i = 0; i < array.length; i++) {
            comando = "select * from " + array[i][0];
            cone.ejecutar(comando);

            Vector<Object> enc = convertirAVector(cone.getEncabezados());

            for (int j = 0; j < enc.size(); j++) {
                tablas.get(i).add(new DefaultMutableTreeNode(enc.get(j)));
            }
        }

        DefaultTreeModel mode = new DefaultTreeModel(bd);
        arbol.setModel(mode);
    }

    private static Vector convertirAVector(Object[] arreglo) {
        if (arreglo == null) {
            return null;
        }
        Vector<Object> v = new Vector<Object>(arreglo.length);
        for (Object o : arreglo) {
            v.addElement(o);
        }
        return v;
    }
    
    public void cerrarConexion() throws SQLException{
        cone.cerrarConexion();
    }
}
