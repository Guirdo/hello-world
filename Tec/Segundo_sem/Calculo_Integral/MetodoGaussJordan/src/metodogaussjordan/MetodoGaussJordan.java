/*
 * Hola!
 */
package metodogaussjordan;

import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class MetodoGaussJordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double matriz[][] = new double[3][4];
        String salida="";
        
        //Entrada de la matriz
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                matriz[i][j]=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el numero en:"
                                                                             + "\nFila: "+i+
                                                                                "\nColumna: "+j,"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
            }
        }
        
        //Impresion de la matriz
        JOptionPane.showMessageDialog(null,imprimirMatriz(matriz),"Matriz original",JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null,imprimirMatriz(metodoGaussJordan(matriz)),"Metodo de Gauss Jordan",JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
    
    static double[][] metodoGaussJordan(double matriz[][]){
        double renglon1[]=new double[4];
        double renglon2[]=new double[4];
        double renglon3[]=new double[4];
        double div;
        
        //Celda 3 1
        for(int i=0;i<4;i++){
            //Se le asigna valores a las filas 1 y 3
            renglon1[i]=-matriz[0][i]*matriz[2][0];
            renglon3[i]=matriz[2][i]*matriz[0][0];
        }
        for(int i=0;i<4;i++){
            matriz[2][i]=renglon3[i]+renglon1[i];
        }
        System.out.println("3 1"+imprimirMatriz(matriz));
        
        //Cels 2 1
        for(int i=0;i<4;i++){
            renglon1[i]=matriz[0][i]*matriz[1][0];
            renglon2[i]=-matriz[1][i]*matriz[0][0];
        }
        for(int i=0;i<4;i++){
            matriz[1][i]=renglon2[i]+renglon1[i];
        }
        System.out.println("2 1"+imprimirMatriz(matriz));
        
        //Celda 3 2
        for(int i=0;i<4;i++){
            renglon2[i]=matriz[1][i]*matriz[2][1];
            renglon3[i]=-matriz[2][i]*matriz[1][1];
        }
        for(int i=0;i<4;i++){
            matriz[2][i]=renglon3[i]+renglon2[i];
        }
        System.out.println("3 2"+imprimirMatriz(matriz));
        
        //Celda 1 3
        div=matriz[2][2];
        for(int i=0;i<4;i++){
            matriz[2][i]/=div;
        }
        for(int i=0;i<4;i++){
            renglon1[i]=matriz[0][i]*matriz[2][2];
            renglon3[i]=-matriz[2][i]*matriz[0][2];
        }
        for(int i=0;i<4;i++){
            matriz[0][i]=renglon3[i]+renglon1[i];
        }
        System.out.println("1 3"+imprimirMatriz(matriz));
        
        //Celda 2 3
        for(int i=0;i<4;i++){
            renglon2[i]=matriz[1][i]*matriz[2][2];
            renglon3[i]=-matriz[2][i]*matriz[1][2];
        }
        for(int i=0;i<4;i++){
            matriz[1][i]=renglon3[i]+renglon2[i];
        }
        System.out.println("2 3"+imprimirMatriz(matriz));
        
        //Celda 1 2
        for(int i=0;i<4;i++){
            renglon1[i]=matriz[0][i]*matriz[1][1];
            renglon2[i]=-matriz[1][i]*matriz[0][1];
        }
        for(int i=0;i<4;i++){
            matriz[0][i]=renglon1[i]+renglon2[i];
        }
        System.out.println("1 2"+imprimirMatriz(matriz));
        
        div=matriz[0][0];
        for(int i=0;i<4;i++){
            matriz[0][i]/=div;
        }
        System.out.println("1 1"+imprimirMatriz(matriz));
        
        div=matriz[1][1];
        for(int i=0;i<4;i++){
            matriz[1][i]/=div;
        }
        System.out.println("2 2"+imprimirMatriz(matriz));
        
        return matriz;
    }
    
    
    static String imprimirMatriz(double matriz[][]){
        String salida="";
        
        for(int i=0;i<3;i++){
            salida+="| ";
            for(int j=0;j<4;j++){
                salida+=matriz[i][j]+" ";
                if(j==2){
                    salida+=": ";
                }
            }
            salida+="|\n";
        }
        
        return salida;
    }
    
}
