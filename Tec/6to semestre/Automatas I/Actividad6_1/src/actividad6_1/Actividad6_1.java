/*
 * Hola!
 */
package actividad6_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Actividad6_1 extends JFrame{
    
    public Actividad6_1(){
        this.setTitle("Actividad 6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new MigLayout("","10[]10","10[]"));
        
        this.getContentPane().setBackground(Color.decode("#e0ffff"));
        
        Image img;
        
        JTextArea taCadena = new JTextArea(4,25);
        taCadena.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taCadena.setWrapStyleWord(true);
        taCadena.setLineWrap(true);
        JLabel iconCuchillo = new JLabel();
        img = new ImageIcon(getClass().getResource("/iconos/cuchillo.png")).getImage();
        iconCuchillo.setIcon(new ImageIcon(img));
        JTextField tfCuchillo = new JTextField(20);
        tfCuchillo.setFont(new Font("Arial",0,16));
        tfCuchillo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        DefaultListModel modelo = new DefaultListModel();
        JList listaSplit = new JList(modelo);
        listaSplit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JButton btnCortar = new JButton("Cortar");
        img = new ImageIcon(getClass().getResource("/iconos/tijeras.png")).getImage();
        btnCortar.setIcon(new ImageIcon(img));
        btnCortar.setBackground(Color.decode("#b0e0e6"));
        //btnCortar.setForeground(Color.decode("#f0ffff"));
        btnCortar.addActionListener((ActionEvent)->{
            String cadena = taCadena.getText();
            String cuchillo = tfCuchillo.getText();
            
            Pattern patron = Pattern.compile(cuchillo);
            String[] split = patron.split(cadena);
            modelo.removeAllElements();
            
            for(String cad : split){
                modelo.addElement(cad);  
            }
            
            listaSplit.setModel(modelo);
        });
        
        JPanel pnlCuchillo = new JPanel(new MigLayout("","0[]9[]0","0[]0"));
        pnlCuchillo.setBackground(this.getContentPane().getBackground());
        pnlCuchillo.add(new JLabel("Introduzca el cuchillo"),"left");
        pnlCuchillo.add(iconCuchillo,"wrap");        
        
        //Elementos agregados en el layout
        this.add(new JLabel("Introduzca la cadena"),"");
        this.add(new JLabel("Lista de palabras"),"center,wrap");
        this.add(new JScrollPane(taCadena),"grow,pushx,growy,pushy");
        this.add(new JScrollPane(listaSplit),"growx,pushx,growy,pushy,span 1 4,wrap");
        this.add(pnlCuchillo,"wrap");
        this.add(tfCuchillo,"pushx,growx,wrap");
        this.add(btnCortar,"right,wrap");
        
        this.pack();
        this.setLocationRelativeTo(null);
        new Presentacion().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Actividad6_1().setVisible(true);
    }
    
}
