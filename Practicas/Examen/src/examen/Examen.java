/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import javax.swing.JOptionPane;
public class Examen {

    public static void main(String[] args) {
        double TotalM2 = 0, TotalM3 = 0;
        String Informacion = "";
        double kilometrosTotal = 0;
        double totalpesos = 0;
        int kilometros;
        int kilometroAmil = 0, kilometrosEmil;
        int selecIn=0;
        String []menu={"SI","NO"};
        while (selecIn==0){
            kilometros = Integer.parseInt(JOptionPane.showInputDialog(null, "INgrese el numero de los kilometros", "Entrada de dastos", JOptionPane.INFORMATION_MESSAGE));
        
           if(kilometros>0){
                Informacion = Informacion + "kilometros "+kilometros+"\n";
                if (kilometros < 300) {
                kilometrosTotal = kilometrosTotal + kilometros;
                totalpesos = totalpesos + 600;
                Informacion = Informacion + "Monto FIjo(300): 600 pesos\n";
            } else {
                if (kilometros > 300 && kilometros <= 1000) {
                    TotalM2 = ((kilometros - 300) * 1.25);
                    kilometrosTotal = kilometrosTotal + kilometros;
                    totalpesos = totalpesos + 600 + TotalM2;
                    Informacion = Informacion + "Monto FIjo(300): 600 pesos\n";
                    Informacion = Informacion + "KIlometros en exceso hasta 1000 (1.75) " + TotalM2+"\n";
                    Informacion = Informacion + "Monto A pagar: " + (TotalM2 + 600)+"\n";
                } else {
                    kilometroAmil = kilometros - 1000;
                    TotalM3 = ((kilometros - 100) * 1.75);
                    kilometrosTotal = kilometrosTotal + kilometros;
                    totalpesos = totalpesos + 600 + 875 + TotalM3;
                    Informacion = Informacion + "Monto FIjo(300): 600 pesos\n";
                    Informacion = Informacion + "KIlometros en exceso hasta 1000 (1.75) $875\n";
                    Informacion = Informacion + "KIlometros en exceso mas de mil (1.75) " + TotalM3+"\n";
                    Informacion = Informacion + "Monto A pagar: " + (TotalM2 + 600 + 875) +"\n";
                }
            }
               
           }
            
            selecIn=JOptionPane.showOptionDialog(null,"Desea Agregar otro mas","Menú",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,menu,"Nuevo producto");
        }
        
         Informacion = Informacion + "Monto total cobrado:" + totalpesos+"\n";
          Informacion = Informacion + "Total de kilometros recorridos"+kilometrosTotal+"\n";
        
        JOptionPane.showMessageDialog(null,"RESULTADO FINAL"+Informacion,"SALIDA DE DATOS",JOptionPane.INFORMATION_MESSAGE);
    }

}
