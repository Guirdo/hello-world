/*
 * Hola!
 */
package cuestionarioeuler;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.lang.Integer;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Cuestionario extends javax.swing.JFrame {

    /**
     * Creates new form Cuestionario
     */
    public Cuestionario() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 400, 300));

        jLabel1.setText("Cuestionario: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("La historia de la probabilidad");

        btnComenzar.setText("Comenzar");
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        jtaResultado.setColumns(20);
        jtaResultado.setRows(5);
        jtaResultado.setText("Da click en\n\"comenzar\"");
        jScrollPane1.setViewportView(jtaResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnComenzar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnComenzar)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        // TODO add your handling code here:
        int correctas=0,i=0,seleccion;
        JComboBox jc = new JComboBox();
        
        jc.addItem("Sócrates");
        jc.addItem("Pierre Fermat y Blaise Pascal ");
        jc.addItem("Arquímedes"); 
        jc.addItem("Platón");
        
        Object campos[] = {"1.- ¿Con quién comienza la historia de la probabilidad?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==1){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        
        jc.removeAllItems();
        
        jc.addItem("El Libro de los Juegos de Azar");
        jc.addItem("Probabilidad aplicada");
        jc.addItem("Teoría de Probabilidad");
        jc.addItem("Estadística Aplicada");
        
        Object campos1[] = {"2. ¿Cómo se llamó el primer libro de probabilidad publicado en 1660?",jc};
        
        do{
            JOptionPane.showMessageDialog(null,campos1,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Herodoto");
        jc.addItem("Posidonia");
        jc.addItem("Polibio");
        jc.addItem("Hecateo de Mileto");
        
        Object campos2[] = {"3.- ¿Qué historiador griego escribió sobre la popularidad de los juegos de azar?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos2,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Grecia y Roma");
        jc.addItem("Francia y Italia");
        jc.addItem("E.U y México");
        jc.addItem("Chile y Brasil");
        Object []campos3 ={"4.- ¿En qué civilizaciones el azar tenia origen divino?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos3,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Por tontos");
        jc.addItem("Razones Divinas");
        jc.addItem("La Religión");
        jc.addItem("Por en Gobierno");
        Object campos4[] = {"5.- ¿Cuál es la razón por la cual no se creó el cálculo de la Probabilidad entre egipcios, griegos y romanos?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos4,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==1){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Creación de la locomotora");
        jc.addItem("Se abandonó la explicaciones teológicas");
        jc.addItem("Creación de la Probabilidad");
        jc.addItem("Propuesta de la Estadística");
        Object campos5[] = {"6.- ¿Qué fue lo que atrajo la modernización en la investigación de la ciencia?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos5,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==1){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Rene Descartes");
        jc.addItem("Euclides");
        jc.addItem("Gerolano Cardano");
        jc.addItem("Leonardo de Pisa");
        Object campos6[] = {"7.- ¿Quiénes comenzaron a interpretar los resultados de experimentos aleatorios sencillos en el siglo XVI?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos6,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==2){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Euclides");
        jc.addItem("Tales de Mileto");
        jc.addItem("Evariste Galois");
        jc.addItem(" Blaise Pascal");
        Object campos7[] = {"8.- ¿Con quién inicio el desarrollo y los fundamentos del cálculo de la probabilidad?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos7,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==3){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Ars Conjectandi (El arte de la previsión)");
        jc.addItem("Huygens De Ratiociniis in Ludo Aleae");
        jc.addItem("Fundamentos de la Probabilida");
        jc.addItem("De Ratiociniis in Ludo Aleae");
        Object campos8[] = {"9.- ¿James Bernoulli escribió un tratado que fue publicado en 1713, como se llamó?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos8,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Blaise Pascal");
        jc.addItem("Fermat");
        jc.addItem("Herodoto");
        jc.addItem("Euclides");
        Object campos9[] = {"10.- ¿Quién fue llamado como padre de la teoría de los números en 1840?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos9,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==1){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("James Bernoulli y Daniel Bernoulli");
        jc.addItem("Euclides y Fermat");
        jc.addItem("Pierre Fermat y Blaise Pascal");
        jc.addItem("Gerolano Cardano y Herodoto ");
        Object campos10[] = {"11.- ¿Quiénes citaron con la teoría más general sobre la probabilidad en el siglo XVII y el siglo XVII? ",jc};
        do{
            JOptionPane.showMessageDialog(null,campos10,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==2){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("A Method of Calculating the Probabilities of Events in Play");
        jc.addItem("De Mensura Sortis");
        jc.addItem("Doctrine of Changes");
        jc.addItem("Ars Conjectandi");
        Object campos11[] = {"12.- Cual es la contribución más importante sobre la teoría de probabilidad que formulo Abraham De Moivre en su obra llamada? ",jc};
        do{
            JOptionPane.showMessageDialog(null,campos11,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==2){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Ames Bernoulli");
        jc.addItem("Pierre Simon Laplace");
        jc.addItem("Gerolano Cardano");
        jc.addItem("Fermat");
        Object campos12[] = {"13.-  ¿Quiénes uno de los más importantes de la historia que formaliza la teoría clásica de la probabilidad?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos12,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("Por El Cristianismo");
        jc.addItem("Por la Iglesia ");
        jc.addItem("Son San Agustin");
        jc.addItem("Fermat");
        Object campos13[] = {"14.- ¿Porque los planteamientos de la probabilidad fueron evolucionando lentamente? ",jc};
        do{
            JOptionPane.showMessageDialog(null,campos13,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        jc.addItem("De Ludo Aleae");
        jc.addItem(" Doctrine of Changes");
        jc.addItem("Ars Conjectandi ");
        jc.addItem("Dialogos");
        Object campos14[] = {"15.- ¿Cual  puede ser el mejor manual escrito para un jugador de la época del siglo XVI?",jc};
        do{
            JOptionPane.showMessageDialog(null,campos14,"Cuestionario",JOptionPane.INFORMATION_MESSAGE);
            if(jc.getSelectedIndex()==0){
                correctas++;
                i=2;
            }else{
                JOptionPane.showMessageDialog(null,"Incorrecto...","Mensaje de error",JOptionPane.ERROR_MESSAGE);
                i++;
            }
        }while(i<2);
        i=0;
        jc.removeAllItems();
        
        
        double pro = (double)correctas / 20.0*100;
        String resultado = "Numero de aciertos: "+correctas+
                            "\nPromedio obtenido: "+pro;
        
        jtaResultado.setText(resultado);
    }//GEN-LAST:event_btnComenzarActionPerformed
    
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
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuestionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaResultado;
    // End of variables declaration//GEN-END:variables
}
