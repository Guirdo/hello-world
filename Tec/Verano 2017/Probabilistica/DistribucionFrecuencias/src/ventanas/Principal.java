/*
 * Hola!
 */
package ventanas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    Tabla t = new Tabla();
    Tabla t1 = null;
    ArrayList<Integer> lista = null;
    DataOutputStream guardar;
    DataInputStream cargar;

    public Principal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/piechart.png")).getImage());
        this.setLocationRelativeTo(null);
        jtaSalida.setText(t.informacion());
        btnLimpiar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDist = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaSalida = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnGuardar = new javax.swing.JMenu();
        mniGuardar = new javax.swing.JMenuItem();
        mniCargar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniCerrar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mniLimpiar = new javax.swing.JMenu();
        mniCuestionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Probabilidad y Estadistica: Unidad I");
        setBounds(new java.awt.Rectangle(0, 0, 822, 450));

        jtDist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Clases", "Valor medio", "Frecuencia absoluta", "Frecuencia relativa", "F.A. acumulada", "F.R. acumulada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtDist);

        jtaSalida.setColumns(20);
        jtaSalida.setRows(5);
        jScrollPane2.setViewportView(jtaSalida);

        jLabel1.setText("Información");

        btnIngresar.setText("Ingresar datos");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar tabla");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        mnGuardar.setText("Archivo");

        mniGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        mniGuardar.setText("Guardar");
        mniGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGuardarActionPerformed(evt);
            }
        });
        mnGuardar.add(mniGuardar);

        mniCargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        mniCargar.setText("Cargar");
        mniCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCargarActionPerformed(evt);
            }
        });
        mnGuardar.add(mniCargar);
        mnGuardar.add(jSeparator1);

        mniCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        mniCerrar.setText("Cerrar");
        mniCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCerrarActionPerformed(evt);
            }
        });
        mnGuardar.add(mniCerrar);

        jMenuBar1.add(mnGuardar);

        jMenu1.setText("Herramientas");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view.png"))); // NOI18N
        jMenuItem1.setText("Vizualizar datos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        mniLimpiar.setText("Cuestionario");

        mniCuestionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mniCuestionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quest.png"))); // NOI18N
        mniCuestionario.setText("Prueba tus conocimientos");
        mniCuestionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCuestionarioActionPerformed(evt);
            }
        });
        mniLimpiar.add(mniCuestionario);

        jMenuBar1.add(mniLimpiar);

        jMenu3.setText("Ayuda");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/acerca.png"))); // NOI18N
        jMenuItem4.setText("Acerca de");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(108, 108, 108))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIngresar)
                        .addGap(249, 249, 249)
                        .addComponent(btnLimpiar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnLimpiar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        IngresarDatos id = new IngresarDatos(new javax.swing.JDialog(), true);
        id.setVisible(true);
        jtaSalida.setText(t.informacion());
        jtDist.setModel(t.darTabla());
        btnIngresar.setEnabled(false);
        btnLimpiar.setEnabled(true);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void mniCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mniCerrarActionPerformed

    private void mniGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGuardarActionPerformed

        JFileChooser jfcGuardar = new JFileChooser();
        String nombre = "";
        

        try {
            int seleccion = jfcGuardar.showSaveDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                //Seleccionamos el fichero
                File fichero = jfcGuardar.getSelectedFile();

                //Ecribe la ruta del fichero seleccionado en el campo de texto
                nombre = fichero.getAbsolutePath();

                if (!nombre.isEmpty()) {
                    int[] arreglo = t.darArreglo();
                    guardar = new DataOutputStream(new FileOutputStream(nombre + ".dat"));

                    for (int i = 0; i < arreglo.length; i++) {
                        guardar.writeInt(arreglo[i]);
                    }

                    JOptionPane.showMessageDialog(null, "¡Los datos han sido guardados con exito!", "Guardado con exito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException e) {

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha introducido ningun dato para poder guardarlo...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_mniGuardarActionPerformed

    private void mniCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCargarActionPerformed
        // TODO add your handling code here:
        JFileChooser jfcAbrir = new JFileChooser();
        String nombre = "";
        jfcAbrir.setFileFilter(new FileNameExtensionFilter("Archivo binario","dat"));

        lista = new ArrayList<>();

        try {
            int seleccion = jfcAbrir.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File fichero = jfcAbrir.getSelectedFile();
                nombre = fichero.getAbsolutePath();
                cargar = new DataInputStream(new FileInputStream(nombre));

                try {
                    while (true) {
                        lista.add(cargar.readInt());
                    }
                } catch (IOException e) {

                }

                t = new Tabla(lista);

                cargar.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: no se ha guardado ningun archivo...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }

        jtaSalida.setText(t.informacion());
        jtDist.setModel(t.darTabla());
        btnIngresar.setEnabled(false);
        btnLimpiar.setEnabled(true);
    }//GEN-LAST:event_mniCargarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        AcercaDe a = new AcercaDe(new javax.swing.JDialog(), true);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        btnIngresar.setEnabled(true);
        t = new Tabla();
        jtaSalida.setText(t.informacion());
        jtDist.setModel(t.darTabla());
        btnLimpiar.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void mniCuestionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCuestionarioActionPerformed
        //Contribucion de Diana

        //Variables
        String respuesta, mensaje = "";
        int cont = 0;
        try {
            JOptionPane.showMessageDialog(null, "Cuestionario sobre Estadística descriptiva e inferencial.", "Bienvenido al cuestionario.", JOptionPane.INFORMATION_MESSAGE);
            Object objresp = JOptionPane.showInputDialog(null, "¿Qué representa la estadística descriptiva?", "Pregunta 1.", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Una población", "Colección de datos", "Parámetros", "Muestra"}, "Una población");
            respuesta = objresp.toString();
            if ("Colección de datos" != respuesta) {
                JOptionPane.showMessageDialog(null, "La respuesta correcta era 'Colección de datos'", "Respuesta.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cont++;
            }
            Object objresp2 = JOptionPane.showInputDialog(null, "¿Qué se obtiene con la estadística descriptiva?", "Pregunta 2.", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Una muestra", "Moda", "Conclusiones sobre los datos", "Toma de decisiones"}, "Una muestra");
            respuesta = objresp2.toString();
            if ("Conclusiones sobre los datos" != respuesta) {
                JOptionPane.showMessageDialog(null, "La respuesta correcta era 'Conclusiones sobre los datos'", "Respuesta.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cont++;
            }
            Object objresp3 = JOptionPane.showInputDialog(null, "Es una de las cosas a las que se refiere la estadística descriptiva: ", "Pregunta 3.", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Experimento", "Datos", "Información", "Análisis"}, "Experimento");
            respuesta = objresp3.toString();
            if ("Análisis" != respuesta) {
                JOptionPane.showMessageDialog(null, "La respuesta correcta era 'Análisis'", "Respuesta.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cont++;
            }
            Object objresp4 = JOptionPane.showInputDialog(null, "¿Qué es la estadística inferencial?", "Pregunta 4.", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Un conjunto de técnicas", "Gráficas", "Experimento", "Muestra"}, "Un conjunto de técnicas");
            respuesta = objresp4.toString();
            if ("Un conjunto de técnicas" != respuesta) {
                JOptionPane.showMessageDialog(null, "La respuesta correcta era 'Un conjunto de técnicas'", "Respuesta.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cont++;
            }
            Object objresp5 = JOptionPane.showInputDialog(null, "¿Para qué sirven las conclusiones sacadas con la estadística inferencial?", "Pregunta 5.", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Ordenar", "Gráficar", "Tomar una decisión", "Describir"}, "Ordenar");
            respuesta = objresp5.toString();
            if ("Tomar una decisión" != respuesta) {
                JOptionPane.showMessageDialog(null, "La respuesta correcta era 'Tomar una decisión'", "Respuesta.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cont++;
            }
            Object objresp6 = JOptionPane.showInputDialog(null, "Se refiere al proceso de lograr generalizaciones acerca de las propiedades del todo:", "Pregunta 6.", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Estadística descriptiva", "Toma de decisiones", "Promedio", "Estadística inferencial"}, "Estadística descriptiva");
            respuesta = objresp6.toString();
            if ("Estadística inferencial" != respuesta) {
                JOptionPane.showMessageDialog(null, "La respuesta correcta era 'Estadística inferencial'", "Respuesta.", JOptionPane.INFORMATION_MESSAGE);
            } else {
                cont++;
            }

            if (cont == 5 || cont == 6) {
                mensaje = "¡Bien hecho!";
            }
            if (cont == 4 || cont == 3) {
                mensaje = "Necesitas mejorar.";
            }
            if (cont < 3) {
                mensaje = "Has fallado.";
            }

            JOptionPane.showMessageDialog(null, "El cuestionaro ha finalizado.\n\n"
                    + "Tu resultado es de " + cont + " de 6.\n" + mensaje, "Fin.", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error.", "Error.", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_mniCuestionarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try{
            JOptionPane.showMessageDialog(null, t.darOrdenados(), "Datos ordenados", JOptionPane.INFORMATION_MESSAGE);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Primero ingrese datos...", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jtDist;
    private javax.swing.JTextArea jtaSalida;
    private javax.swing.JMenu mnGuardar;
    private javax.swing.JMenuItem mniCargar;
    private javax.swing.JMenuItem mniCerrar;
    private javax.swing.JMenuItem mniCuestionario;
    private javax.swing.JMenuItem mniGuardar;
    private javax.swing.JMenu mniLimpiar;
    // End of variables declaration//GEN-END:variables
}
