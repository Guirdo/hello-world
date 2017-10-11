package cosas;

public class Tabla {
    static double valorCri,chiCua;
    static int gl,alfa; 
    static Object tabla[][];
    static String[] encabezados;
    static Class[] tipos;
    static boolean[] editar;
    
    public Tabla(){
        
    }
    
    public Tabla(Object[][] tab,String[] enca,Class[] tips,boolean[] edit,int df,int alfa){
        this.tabla=tab;
        encabezados=enca;
        tipos=tips;
        editar=edit;
        this.gl=df;
        this.alfa=alfa;
        this.valorCri=darValorCri();
    }

    public double getValorCri() {
        return valorCri;
    }

    public int getGl() {
        return gl+1;
    }
    
    
    
    public javax.swing.table.DefaultTableModel darTabla() {

        javax.swing.table.DefaultTableModel tab = new javax.swing.table.DefaultTableModel(
                tabla,encabezados) {
            Class[] types = tipos;
            boolean[] canEdit = editar;

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return tab;
    }
    
    public double darValorCri(){
        double res=0;
        
        double [][] tabChi = {
                {2.71,3.84,5.02,6.63,7.88},
                {4.61,5.99,7.38,9.21,10.60},
                {6.25,7.81,9.35,11.34,12.84},
                {7.78,9.49,11.14,13.28,14.86},
                {9.24,11.07,12.83,15.09,16.75},
        
        {10.64,12.59,14.45,16.81,18.55},
        {12.02,14.07,16.01,18.48,20.3},
        {13.36,15.51,17.53,20.1,22},
        {14.68,16.92,19.02,21.7,23.6},
        {15.99,18.31,20.5,23.2,25.2},
        
        {17.28,19.68,21.9,24.7,26.8},
        {18.55,21,23.3,26.2,28.3},
        {19.81,22.4,24.7,27.7,29.8},
        {21.1,23.7,26.1,29.1,31.3},
        {22.3,25,27.5,30.6,32.8},
        
        {23.5,26.3,28.8,32,34.3},
        {24.8,27.6,30.2,33.4,35.7},
        {26,28.9,31.5,34.8,37.2},
        {27.2,30.1,32.9,36.2,38.6},
        {28.4,31.4,34.2,37.6,40},
        
        {29.6,32.7,35.5,38.9,41.4},
        {30.8,33.9,36.8,40.3,42.8},
        {32,35.2,38.1,41.6,44.2},
        {33.2,36.4,39.4,43,45.6},
        {34.4,37.7,40.6,44.3,46.9},
        
        {35.6,38.9,41.9,45.6,48.3},
        {36.7,40.1,43.2,47,49.6},
        {37.9,41.3,44.5,48.3,51},
        {39.1,42.6,45.7,49.6,52.3},
        {40.3,43.8,47,50.9,53.7},
        
        {51.8,55.8,59.3,63.7,66.8},
        {63.2,67.5,71.4,76.2,79.5},
        {74.4,79.1,83.3,88.4,92},
        {85.5,90.5,95,100.4,104.2},
        
        {96.6,101.9,106.6,112.3,116.3},
        {107.6,113.1,118.1,124.1,128.3},
        {118.5,124.3,129.6,135.8,140.2}};
        
        
        if(gl >=31 && gl <=39){
            res = tabChi[29][alfa];
        }else if(gl >= 40 && gl <=49){
            res = tabChi[30][alfa];
        }else if(gl >= 50 && gl <=59){
            res = tabChi[31][alfa];
        }else if(gl >=60 && gl <= 69){
            res = tabChi[32][alfa];
        }else if(gl >= 70 && gl >= 79){
            res = tabChi[33][alfa];
        }else if(gl >= 80 && gl <= 89){
            res = tabChi[34][alfa];
        }else if(gl >= 90 && gl <= 99){
            res = tabChi[35][alfa];
        }else if(gl == 100){
            res = tabChi[36][alfa];
        }else if(gl >= 0 && gl <= 30){
            res = tabChi[gl][alfa];
        }
        
        System.out.println("1 -"+gl);
        System.out.println("2 -"+alfa);
        System.out.println("3 -"+res);
        
        return res;
    }
}
