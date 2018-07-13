package clases;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Ventana extends JFrame {

    public Ventana(){
        initIU();
    }

    public void initIU(){
        this.setSize(540,620);
        this.setLocationRelativeTo(null);
        this.setTitle("Memorama");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setIconImage(new Image("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Memorama\\src\\caras\\1.jpg"));

        crearTarjetas();
        estadistica.setBounds(415,100,100,75);
        add(estadistica);

        cronometro.setBounds(415,200,40,40);
        add(cronometro);

        cro = new Cronometro();
        cro.start();
    }

    public void crearTarjetas(){
        //Poner imagenes en los botones
        double cont = 0;
        for(int i=0;i<16;i++){
            String cara = "C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Memorama\\src\\caras\\"+((int) Math.floor(cont))+".jpg";
            tarjetas[i] = new Tarjeta(cara,espalda);
            cont+=0.5;
        }

        //Shoflear los botones
        Random alea = new Random();
        for (int j = 0;j<tarjetas.length;j++){
            int randomPos = alea.nextInt(tarjetas.length);
            Tarjeta temp = tarjetas[j];
            tarjetas[j] = tarjetas[randomPos];
            tarjetas[randomPos] = temp;
        }

        //Agregar listener a los botones y las acciones al darle click
        for(int i=0;i<16;i++){
            final int finalI = i;
            tarjetas[i].addActionListener((ActionEvent e)->{
                //Primer clic
                if(flag==0){
                    flag++;
                    pos1 = finalI;
                    tarjetas[pos1].setVolteado(true);
                    dic1 = tarjetas[pos1].getIcon().toString();
                    eventoAnterior = e;
                }else if(flag==1){//Segundo clic
                    //Comprueba que el segundo clic no sea en la misma tarjeta
                    if(!eventoAnterior.getSource().equals(e.getSource())) {
                        flag++;
                        pos2 = finalI;
                        tarjetas[pos2].setVolteado(true);
                        dic2 = tarjetas[pos2].getIcon().toString();
                    }else{//Si es en la misma tarjeta, el contador de clic vuelve a cero y voltea la tarjeta
                        flag=0;
                        tarjetas[pos1].setVolteado(false);
                    }
                }

                //Los clic son en diferentes tarjetas
                if(pos1!=pos2 && flag==2){
                    //Si estan mal, los deja expuestos un momento
                    if(!dic1.equals(dic2)){
                        objHilo = new Hilo();
                        objHilo.start();
                    }else{//Si son correctas las deja así y las deshabilita
                        tarjetas[pos1].setEnabled(false);
                        tarjetas[pos2].setEnabled(false);

                        parejas++;
                    }

                    if(!comprobarGanado()){
                        intentos++;
                        texto = "Intentos: "+intentos+"\n"
                                +"Aciertos: "+parejas;

                        estadistica.setText(texto);

                        flag=0;
                    }


                }

            });
        }

        //Acomodar las tarjetas
        for(int i=0;i<tarjetas.length;i++){
            tarjetas[i].setBounds(x,y,100,140);
            x+=100;

            add(tarjetas[i]);

            if(x==410){
                x=10;
                y+=140;
            }
        }

    }

    public boolean comprobarGanado(){
        if(parejas == 8){
            JOptionPane.showMessageDialog(null,"¡Has ganado!");
            int selec = JOptionPane.showConfirmDialog(null,"¿Desea jugar de nuevo?","Jugar de nuevo",JOptionPane.YES_NO_OPTION);
            switch (selec){
                case 0:

                    System.out.println("Hola");

                    this.removeAll();
                    crearTarjetas();

                    intentos=0;
                    parejas=0;
                    texto = "Intentos: "+intentos+"\n"
                            +"Aciertos: "+parejas;
                    estadistica.setText(texto);

                    this.revalidate();
                    this.repaint();

                    break;

                case 1:
                    System.exit(0);
                    break;
            }
            return true;
        }else{
            return false;
        }
    }

  //Declaracion de variables y objetos
    int x = 10;
    int y= 10;
    int parejas = 0;
    int intentos = 0;
    int flag = 0;
    String texto = "Intentos: "+intentos+"\n"
            +"Aciertos: "+parejas;
    static Tarjeta []tarjetas = new Tarjeta[16];
    JTextArea estadistica = new JTextArea(texto);
    static JTextArea cronometro = new JTextArea();
    Cronometro cro;
    final String espalda = "C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Memorama\\src\\espalda\\nintendo.jpg";
    String dic1 = "";
    String dic2 = "";
    static int pos1 = 0;
    static int pos2 = 0;
    Hilo objHilo;
    int num1=0;
    int num2=0;
    ActionEvent eventoAnterior;
    static boolean estado = true;
    // Declaracion de variables y objetos

}
