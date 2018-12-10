/*
 * Hola!
 */
package tecsqlworkbench;

import conexion.ConexionBD;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class TecSQLWorkbench extends JFrame implements WindowListener{

    private Tabla tabla;
    private Arbol ar;
    private String comandos;
    private ConexionBD cone;

    public TecSQLWorkbench() {
        this.setTitle("TecSQL Workbech");
        this.addWindowListener(this);
        this.setLayout(null);
        this.setSize(865, 515);
        this.setLocationRelativeTo(null);

        try {
            cone = new ConexionBD();
            tabla = new Tabla(cone);
            ar= new Arbol(cone);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(1);
        }

        JLabel text1 = new JLabel("Linea de comandos");
        text1.setBounds(215, 15, 120, 20);
        
        ar.setBounds(10, 15,190, 450);
        tabla.setBounds(215, 215, 620, 250);

        JTextArea lineaComandos = new JTextArea();
        lineaComandos.setFont(new Font("Monospaced", 0, 14));
        lineaComandos.setBackground(Color.BLACK);
        lineaComandos.setForeground(Color.GREEN);
        JScrollPane sclLinea = new JScrollPane(lineaComandos);
        sclLinea.setBounds(215, 55, 620, 120);

        JLabel tituloTabla = new JLabel(tabla.getTituloTabla());
        tituloTabla.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        tituloTabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tituloTabla.setBounds(459, 185, 150, 20);

        JButton ejecutar = new JButton("Ejecutar");
        ejecutar.setBounds(735, 15, 100, 25);
        ejecutar.setMnemonic('e');
        ejecutar.addActionListener((ActionEvent) -> {
            comandos = lineaComandos.getText();
            lineaComandos.setText("");

            try {
                if (tabla.ejecutarSentencia(comandos)) {
                    tituloTabla.setText(tabla.getTituloTabla());
                }else{
                    JOptionPane.showMessageDialog(null,"Han sido afectadas "+tabla.getFilasAfectadas()+" filas.");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        this.add(ar);
        this.add(text1);
        this.add(sclLinea);
        this.add(ejecutar);
        this.add(tituloTabla);
        this.add(tabla);
    }

    public static void main(String[] args) {
        new TecSQLWorkbench().setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try{
            cone.cerrarConexion();
            tabla.cerrarConexion();
            ar.cerrarConexion();
        } catch (SQLException ex) {
            
        }
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

}
