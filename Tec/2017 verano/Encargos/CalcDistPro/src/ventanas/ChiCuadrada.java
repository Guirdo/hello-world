/*
 * Hola!
 */
package ventanas;

import cosas.Tabla;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class ChiCuadrada extends javax.swing.JDialog {

    /**
     * Creates new form ChiCuadrada
     */
    Tabla tab = new Tabla();
    public ChiCuadrada(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfH0 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfH1 = new javax.swing.JTextField();
        btnHipos = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIngTab = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnLim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfChi = new javax.swing.JTextField();
        jtfGL = new javax.swing.JTextField();
        jtfVC = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaHipotesis = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi Cuadrada");
        setBounds(new java.awt.Rectangle(0, 0, 755, 500));

        jtfH0.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfH0CaretUpdate(evt);
            }
        });

        jLabel2.setText("Hipotesis alternativa");

        jtfH1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfH1CaretUpdate(evt);
            }
        });

        btnHipos.setText("Ingresar hipotesis");
        btnHipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHiposActionPerformed(evt);
            }
        });

        btnCalcular.setText("Realizar calculos");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel3.setText("Chi cuadrada: ");

        jtTabla.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        jLabel4.setText("Valor Critico: ");

        jLabel5.setText("Hipotesis aceptada: ");

        btnIngTab.setText("Ingresar tabla");
        btnIngTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngTabActionPerformed(evt);
            }
        });

        jLabel6.setText("Grados de libertad: ");

        btnLim.setText("Limpiar tabla");
        btnLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimActionPerformed(evt);
            }
        });

        jLabel1.setText("Hipotesis nula");

        jLabel7.setText("Tabla");

        jtfGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGLActionPerformed(evt);
            }
        });

        jtaHipotesis.setColumns(20);
        jtaHipotesis.setRows(5);
        jScrollPane2.setViewportView(jtaHipotesis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfH1)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfH0, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfGL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfVC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel5))
                                    .addComponent(jtfChi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIngTab, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHipos)))
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIngTab)
                        .addGap(18, 18, 18)
                        .addComponent(btnLim)
                        .addGap(88, 88, 88)
                        .addComponent(btnCalcular))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfH0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnHipos))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jtfVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfH0CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfH0CaretUpdate
        // TODO add your handling code here:
        if (!jtfH0.getText().isEmpty() && !jtfH1.getText().isEmpty()) {
            btnHipos.setEnabled(true);
        } else {
            btnHipos.setEnabled(false);
        }
    }//GEN-LAST:event_jtfH0CaretUpdate

    private void jtfH1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfH1CaretUpdate
        // TODO add your handling code here:
        if (!jtfH0.getText().isEmpty() && !jtfH1.getText().isEmpty()) {
            btnHipos.setEnabled(true);
        } else {
            btnHipos.setEnabled(false);
        }
    }//GEN-LAST:event_jtfH1CaretUpdate

    private void btnHiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiposActionPerformed
        // TODO add your handling code here:
        
        jtfH0.setEditable(false);
        jtfH1.setEditable(false);
        btnHipos.setEnabled(false);
    }//GEN-LAST:event_btnHiposActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        double suma = 0;
        double totalObs=0;
        double [] sumasCo = new double[jtTabla.getColumnCount()-1];
        double[] sumasRen = new double[jtTabla.getRowCount()];
        double freEspe [] = new double[jtTabla.getRowCount()*(jtTabla.getColumnCount()-1)];
        double freObs [] = new double[jtTabla.getRowCount()*(jtTabla.getColumnCount()-1)];
        
        for (int i = 1; i < jtTabla.getColumnCount(); i++) {
            for (int j = 0; j < jtTabla.getRowCount(); j++) {
                suma += (Double) jtTabla.getValueAt(j, i);
            }
            sumasCo[i-1]=suma;
            suma=0;
        }
        
        for(int i=0;i<jtTabla.getRowCount();i++){
            for(int j=1;j<jtTabla.getColumnCount();j++){
                suma += (Double) jtTabla.getValueAt(i, j);
            }
            sumasRen[i]=suma;
            suma=0;
        }
        
        //Total de observaciones
        for(int i=0;i<sumasRen.length;i++){
            totalObs+=sumasRen[i];
        }
        
        //Valores observados
        int cont1=0;
        for(int i=1;i<jtTabla.getColumnCount();i++){
            for(int j=0;j<jtTabla.getRowCount();j++){
                System.out.println("3.5 -"+(Double) jtTabla.getValueAt(j, i));
               freObs[cont1]=(Double) jtTabla.getValueAt(j, i)*1.0;
               cont1++;
            }
        }
        
        System.out.println("2.45 - "+totalObs);
        
        int cont=0,contRe=0,contCo=0;
        //Valores esperados
        for(int i=1;i<jtTabla.getColumnCount();i++){
            for(int j=0;j<jtTabla.getRowCount();j++){
               freEspe[cont]=sumasCo[i-1]*(sumasRen[contRe]/totalObs);
               cont++;
               contRe++;
            }
            contRe=0;
        }
        
        //Calculo de Chi cuadrada
        double chiCua = 0;
        for(int i=0;i<freObs.length;i++){
            System.out.println("4 -"+freObs[i]);
            System.out.println("5 -"+freEspe[i]);
            
            chiCua+=Math.pow(freObs[i]-freEspe[i],2)/freEspe[i];
        }
        chiCua = Math.rint(chiCua*100)/100;
        
        jtfChi.setText(""+chiCua);
        jtfVC.setText(""+tab.darValorCri());
        jtfGL.setText(""+tab.getGl());
        
        if(chiCua < tab.getValorCri()){
            jtaHipotesis.setText(jtfH0.getText());
        }else{
            jtaHipotesis.setText(jtfH1.getText());
        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnIngTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngTabActionPerformed
        // TODO add your handling code here:
        IngreTab it = new IngreTab(new javax.swing.JDialog(), true);
        it.setVisible(true);
        btnLim.setEnabled(true);
        jtTabla.setFont(new java.awt.Font("Verdana", 0, 13));
        jtTabla.setModel(tab.darTabla());
        btnCalcular.setEnabled(true);
        btnIngTab.setEnabled(false);
    }//GEN-LAST:event_btnIngTabActionPerformed

    private void jtfGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGLActionPerformed

    private void btnLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimActionPerformed
        // TODO add your handling code here:
        btnIngTab.setEnabled(true);
        jtTabla.setModel(new javax.swing.table.DefaultTableModel());
        btnCalcular.setEnabled(false);
        btnHipos.setEnabled(true);
        
        jtfH0.setEnabled(true);
        jtfH0.setText("");
        jtfH1.setEnabled(true);
        jtfH1.setText("");
        
        jtfChi.setText("");
        jtfVC.setText("");
        jtfGL.setText("");
        jtaHipotesis.setText("");
        
    }//GEN-LAST:event_btnLimActionPerformed

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
            java.util.logging.Logger.getLogger(ChiCuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiCuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiCuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiCuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiCuadrada dialog = new ChiCuadrada(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnHipos;
    private javax.swing.JButton btnIngTab;
    private javax.swing.JButton btnLim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextArea jtaHipotesis;
    private javax.swing.JTextField jtfChi;
    private javax.swing.JTextField jtfGL;
    private javax.swing.JTextField jtfH0;
    private javax.swing.JTextField jtfH1;
    private javax.swing.JTextField jtfVC;
    // End of variables declaration//GEN-END:variables
}
