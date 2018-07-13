
package actividadpilas;
public class ActividadPilas {

    public static void main(String[] args) {
        Botones ventana=new Botones();
        pila ac = new pila();
        
        ventana.setBounds(300,500,300,500);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.getContentPane().setBackground(java.awt.Color.orange);
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
    }
    
}
