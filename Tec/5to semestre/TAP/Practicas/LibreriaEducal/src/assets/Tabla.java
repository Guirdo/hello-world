package assets;

import javax.swing.JTable;

public class Tabla extends JTable{
    
    public Tabla (){
        Object matriz[][] =new Object[3][6];
        
        this.setModel(new javax.swing.table.DefaultTableModel(
        matriz,new String[]{"Codigo","Titulo","Autor","Editorial","Precio","Cantidad"}
        ){
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        this.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.getColumnModel().getColumn(2).setPreferredWidth(110);
        this.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.getColumnModel().getColumn(5).setPreferredWidth(50);
    }//Contructor
}
