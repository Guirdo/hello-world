/*
 * Hola!
 */
package ventanas;

import javax.swing.UIManager;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Poisson extends javax.swing.JDialog {

    /**
     * Creates new form Poisson
     */
    public Poisson(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        jtfX2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jtfLamda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfX = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jrbIgual = new javax.swing.JRadioButton();
        jrbMenIg = new javax.swing.JRadioButton();
        jrbMenor = new javax.swing.JRadioButton();
        jrbMayIg = new javax.swing.JRadioButton();
        jrbMay = new javax.swing.JRadioButton();
        jrbIntMen = new javax.swing.JRadioButton();
        jrbIntMenIg = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCalc = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfRes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfX2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Distribucion Poisson");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("λ = ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("x1 = ");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Poisson");

        buttonGroup1.add(jrbIgual);
        jrbIgual.setText("X = x");
        jrbIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbIgualActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbMenIg);
        jrbMenIg.setText("X <= x");
        jrbMenIg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMenIgActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbMenor);
        jrbMenor.setText("X < x");
        jrbMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMenorActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbMayIg);
        jrbMayIg.setText("X >= x");
        jrbMayIg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMayIgActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbMay);
        jrbMay.setText("X > x");
        jrbMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMayActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbIntMen);
        jrbIntMen.setText("x1 < X <= x2");
        jrbIntMen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbIntMenActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbIntMenIg);
        jrbIntMenIg.setText("x1 <= X <= x2");
        jrbIntMenIg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbIntMenIgActionPerformed(evt);
            }
        });

        jLabel4.setText("Poisson acumulada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbIntMen)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbMayIg)
                                .addGap(18, 18, 18)
                                .addComponent(jrbMay))
                            .addComponent(jLabel3)
                            .addComponent(jrbIgual)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbMenIg)
                                .addGap(18, 18, 18)
                                .addComponent(jrbMenor))
                            .addComponent(jrbIntMenIg)
                            .addComponent(jLabel4))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbIgual)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMenIg)
                    .addComponent(jrbMenor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMayIg)
                    .addComponent(jrbMay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbIntMen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbIntMenIg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCalc.setText("Calcular");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        jLabel5.setText("Resultado: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("x2 =");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfRes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfLamda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfX, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtfX2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnCalc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfLamda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(btnCalc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMayActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(false);
    }//GEN-LAST:event_jrbMayActionPerformed

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        // TODO add your handling code here:
        double res=0;
        double lamda = Double.parseDouble(jtfLamda.getText());
        int x = Integer.parseInt(jtfX.getText());
        
        if(jrbIgual.isSelected()){
            jtfRes.setText(""+(Math.rint(darPoisson(lamda,x)*100))/100);
        }else if(jrbMenIg.isSelected()){
            jtfRes.setText(""+(Math.rint(darPoisAcum(lamda,x)*100))/100);
        }else if(jrbMenor.isSelected()){
            jtfRes.setText(""+((Math.rint(darPoisAcum(lamda,x-1)*100))/100));
        }else if(jrbMay.isSelected()){
            res = 1-darPoisAcum(lamda,x);
            jtfRes.setText(""+(Math.rint(res*100)/100));
        }else if(jrbIntMen.isSelected()){
            int x2 = Integer.parseInt(jtfX2.getText());
            double p1=0,p2=0;
            
            if(x > x2){
                p1 = darPoisAcum(lamda,x);
                p2 = darPoisAcum(lamda,x2);
            }else{
                p1 = darPoisAcum(lamda,x2);
                p2 = darPoisAcum(lamda,x);
            }
            
            res = p1-p2;
            res = Math.rint(res*100)/100;
            jtfRes.setText(""+res);
        }else if(jrbIntMenIg.isSelected()){
            int x2 = Integer.parseInt(jtfX2.getText());
            double p1=0,p2=0;
            
            if(x > x2){
                p1 = darPoisAcum(lamda,x);
                p2 = darPoisAcum(lamda,x2-1);
            }else{
                p1 = darPoisAcum(lamda,x2);
                p2 = darPoisAcum(lamda,x-1);
            }
            
            res = p1-p2;
            res = Math.rint(res*100)/100;
            jtfRes.setText(""+res);
        }
    }//GEN-LAST:event_btnCalcActionPerformed

    private void jrbIntMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbIntMenActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(true);
    }//GEN-LAST:event_jrbIntMenActionPerformed

    private void jrbIntMenIgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbIntMenIgActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(true);
    }//GEN-LAST:event_jrbIntMenIgActionPerformed

    private void jrbMenIgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMenIgActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(false);
    }//GEN-LAST:event_jrbMenIgActionPerformed

    private void jrbMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMenorActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(false);
    }//GEN-LAST:event_jrbMenorActionPerformed

    private void jrbMayIgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMayIgActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(false);
    }//GEN-LAST:event_jrbMayIgActionPerformed

    private void jrbIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbIgualActionPerformed
        // TODO add your handling code here:
        jtfX2.setEnabled(false);
    }//GEN-LAST:event_jrbIgualActionPerformed
    
    private double darPoisson(double lamda, int x){
        double res = (Math.pow(lamda,x)*Math.pow(Math.E, -lamda))/factorial(x);
        
       return res; 
    }
    
    private double factorial(double num) {
        double res = 1;

        if (num > 1) {
            for (int i = 1; i <= num; i++) {
                res *= i;
            }
        }

        return res;
    }
    
    private double darPoisAcum(double lamda,int x){
        double res =0;
        
        for(int i = 0; i <= x; i++){
            res+=darPoisson(lamda,i);
        }
        
        return res;
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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Poisson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Poisson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Poisson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Poisson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Poisson dialog = new Poisson(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnCalc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton jrbIgual;
    private javax.swing.JRadioButton jrbIntMen;
    private javax.swing.JRadioButton jrbIntMenIg;
    private javax.swing.JRadioButton jrbMay;
    private javax.swing.JRadioButton jrbMayIg;
    private javax.swing.JRadioButton jrbMenIg;
    private javax.swing.JRadioButton jrbMenor;
    private javax.swing.JTextField jtfLamda;
    private javax.swing.JTextField jtfRes;
    private javax.swing.JTextField jtfX;
    private javax.swing.JTextField jtfX2;
    // End of variables declaration//GEN-END:variables
}
