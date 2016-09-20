package calculadora;

import javax.swing.*;

public class Principal {
    public static void main(String[] args){
        
        int seleccionEvento,eventLiDif=0,eventLiRank=0,eventLiCom=0,numC=0,eventLu=0,puntos=0;
        String mensaje = null;
        String[] num={"1","2","3"};
        String[] eventos = {"Tokens","Medley Festa","Score Match","Salir"};
        String[] combo = {"N/C","C","B","A","S"};
        String[] rank = {"N/R","C","B","A","S"};
        String[] dificultad = {"Easy","Normal","Hard","Expert"};
        String[] lugar = {"1°","2°","3°","4","Inconsistente"};
        
        Tokens token = new Tokens();
        Medley med = new Medley();
        Score sco = new Score();
        
        JOptionPane.showMessageDialog(null,"¡Bienvenido a Calculadora SIF!","CalculadoraSIF",JOptionPane.INFORMATION_MESSAGE);
        
        do{
            seleccionEvento = JOptionPane.showOptionDialog(null, "Escoge el tipo de evento, o elige salir de la app.", "Tipo de evento", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eventos, "Tokens");
            JOptionPane.showMessageDialog(null, "Haz escogido "+eventos[seleccionEvento]);
            
            switch (seleccionEvento){
                
                case 0:
                    eventLiDif=JOptionPane.showOptionDialog(null,"Dificultad de la cancion de evento:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificultad,"Easy");
                    eventLiRank=JOptionPane.showOptionDialog(null,"Score Rank obtenido:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,rank,"N/R");
                    eventLiCom=JOptionPane.showOptionDialog(null,"Combo logrado:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,combo,"N/C");
                
                    puntos=token.sacarPuntos(eventLiDif,eventLiRank,eventLiCom);
                    JOptionPane.showMessageDialog(null,"Puntos obtenidos: "+puntos);
                break;
                
                case 1:
                    eventLiDif=JOptionPane.showOptionDialog(null,"Dificultad del Medley:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificultad,"Easy");
                    numC=JOptionPane.showOptionDialog(null,"Numero de canciones:",eventos[1],JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,num,3);
                    eventLiRank=JOptionPane.showOptionDialog(null,"Score Rank obtenido:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,rank,"N/R");
                    eventLiCom=JOptionPane.showOptionDialog(null,"Combo logrado:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,combo,"N/C");
                
                    puntos=med.sacarPunMed(eventLiDif, numC, eventLiRank, eventLiCom);
                    //mensaje=med.mostrarMensaje(eventLiDif,numC, puntos);
                
                    JOptionPane.showMessageDialog(null,"Puntos obtenidos: "+puntos);
                    //JOptionPane.showMessageDialog(null,mensaje);
                break;
                
                case 2:
                    eventLiDif=JOptionPane.showOptionDialog(null,"Dificultad del Score Match:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificultad,"Easy");
                    eventLu=JOptionPane.showOptionDialog(null,"Lugar en el Score \nMatch más frecuente:","Score Match",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, lugar, null);
                    eventLiRank=JOptionPane.showOptionDialog(null,"Score Rank obtenido:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,rank,"N/R");
                
                    puntos=sco.sacarPuntos(eventLiDif, eventLu, eventLiRank);
                    JOptionPane.showMessageDialog(null,"Puntos obtenidos: "+puntos);
                break;    
                
            }
            
            /*if(seleccionEvento==0){
                eventLiDif=JOptionPane.showOptionDialog(null,"Dificultad de la cancion de evento:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificultad,"Easy");
                eventLiRank=JOptionPane.showOptionDialog(null,"Score Rank obtenido:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,rank,"N/R");
                eventLiCom=JOptionPane.showOptionDialog(null,"Combo logrado:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,combo,"N/C");
                
                puntos=token.sacarPuntos(eventLiDif,eventLiRank,eventLiCom);
                JOptionPane.showMessageDialog(null,"Puntos obtenidos: "+puntos);
            }else if(seleccionEvento==1){
                eventLiDif=JOptionPane.showOptionDialog(null,"Dificultad del Medley:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificultad,"Easy");
                numC=JOptionPane.showOptionDialog(null,"Numero de canciones:",eventos[1],JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,num,3);
                eventLiRank=JOptionPane.showOptionDialog(null,"Score Rank obtenido:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,rank,"N/R");
                eventLiCom=JOptionPane.showOptionDialog(null,"Combo logrado:",eventos[0],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,combo,"N/C");
                
                puntos=med.sacarPunMed(eventLiDif, numC, eventLiRank, eventLiCom);
                //mensaje=med.mostrarMensaje(eventLiDif,numC, puntos);
                
                JOptionPane.showMessageDialog(null,"Puntos obtenidos: "+puntos);
                //JOptionPane.showMessageDialog(null,mensaje);
            }else if(seleccionEvento==2){
                eventLiDif=JOptionPane.showOptionDialog(null,"Dificultad del Score Match:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificultad,"Easy");
                eventLu=JOptionPane.showOptionDialog(null,"Lugar en el Score \nMatch más frecuente:","Score Match",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, lugar, null);
                eventLiRank=JOptionPane.showOptionDialog(null,"Score Rank obtenido:",eventos[1],JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,rank,"N/R");
                
                puntos=sco.sacarPuntos(eventLiDif, eventLu, eventLiRank);
                JOptionPane.showMessageDialog(null,"Puntos obtenidos: "+puntos);
            }*/   
            
        }while(seleccionEvento != 3);
        
    }
    
}
