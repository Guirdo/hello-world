/*
 * Hola!
 */
package ventanas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class IngresarDatos extends javax.swing.JDialog {

    /**
     * Creates new form IngresarDatos
     */
    ArrayList<Integer> lista = new ArrayList<>();
    Tabla t;
    int cont = 1;

    public IngresarDatos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/piechart.png")).getImage());
        this.setLocationRelativeTo(null);
        validarNumeros(jtfIngreso);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContador = new javax.swing.JLabel();
        jtfIngreso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaOrdenado = new javax.swing.JTextArea();
        btnIngresar = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar datos");
        setBounds(new java.awt.Rectangle(0, 0, 348, 297));

        lblContador.setText("Ingrese el dato #1:");

        jtaOrdenado.setColumns(20);
        jtaOrdenado.setRows(5);
        jScrollPane1.setViewportView(jtaOrdenado);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar datos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContador)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTerminar)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblContador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTerminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        lista.add(Integer.parseInt(jtfIngreso.getText()));
        cont++;
        lblContador.setText("Ingrese el dato #" + cont);
        jtfIngreso.setText("");
        jtaOrdenado.setText(imprimir());
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        // TODO add your handling code here:
        if(lista.size()<1){
            t = new Tabla();
        }else{
            t = new Tabla(lista);
        }
        dispose();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        cont=0;
        lblContador.setText("Ingrese el dato #1:");
        jtfIngreso.setText("");
        jtaOrdenado.setText("");
        lista= new ArrayList<>();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public String imprimir() {
        String salida = "";

        int aux;
        for (int i = 0; i < (lista.size() - 1); i++) {
            for (int x = i + 1; x < lista.size(); x++) {
                if (lista.get(x) < lista.get(i)) {
                    aux = lista.get(i);
                    lista.set(i, lista.get(x));
                    lista.set(x, aux);
                }
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            salida += lista.get(i) + " ";
            if ((i + 1) % 5 == 0) {
                salida += "\n";
            }
        }

        return salida;
    }

    public void validarNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
               char c = e.getKeyChar();
               if(!Character.isDigit(c)){
                   e.consume();
               }
            }
        });
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IngresarDatos dialog = new IngresarDatos(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JToggleButton btnLimpiar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaOrdenado;
    private javax.swing.JTextField jtfIngreso;
    private javax.swing.JLabel lblContador;
    // End of variables declaration//GEN-END:variables
}
