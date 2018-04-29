import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Ventana extends JFrame {

    public Ventana(){
        initIU();
    }

    public void initIU(){
        this.setSize(540,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Memorama");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        //Creacion de la tarjetas
        crearTarjetas();
        acomodarTarjetas();
    }

    public void crearTarjetas(){
        for(int i=0;i<8;i++){
            String cara = "C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Memorama\\src\\caras\\"+i+".jpg";
            tarjetas.add(new Tarjeta(cara,espalda,x,y));
            x+=100;
            tarjetas.add(new Tarjeta(cara,espalda,x,y));
            x+=100;
        }

        for(int i=0;i<tarjetas.size();i++){
            int finalI = i;
            tarjetas.get(i).addActionListener((ActionEvent e)->{
                String dic1 = "";
                String dic2 = "";
                int pos1 = 0;
                int pos2 = 0;
                if(!flag){
                   flag = true;
                   pos1 = finalI;
                   tarjetas.get(pos1).setVolteado(true);
                   dic1 = tarjetas.get(pos1).getIcon().toString();
                }else{
                    pos2 = finalI;
                    tarjetas.get(pos2).setVolteado(true);
                    dic2 = tarjetas.get(pos2).getIcon().toString();

                    if(!comparar(dic1,dic2)){
                        JOptionPane.showMessageDialog(null,"¡CHECALO!");
                        tarjetas.get(pos1).setVolteado(false);
                        tarjetas.get(pos2).setVolteado(false);
                    }else{
                        parejas++;
                        comprobarGanado();
                    }
                }
            });
        }
    }

    public void acomodarTarjetas(){
        for(int i=0;i<tarjetas.size();i++){
            tarjetas.get(i).setBounds(x,y,100,140);
            x+=100;

            this.add((JButton) tarjetas.get(i));

            if(x==410){
                x=10;
                y+=140;
            }
        }
    }

    public boolean comparar(String dic1, String dic2){
        if(dic1.equals(dic2)){
           return true;
        }else{
            return false;
        }
    }

    public void comprobarGanado(){
        if(parejas == 8){
            System.out.println("Has ganados");
        }
    }

  //Declaracion de variables y objetos
    int x = 10;
    int y= 10;
    int parejas = 0;
    boolean flag = false;
    ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    JButton jugar = new JButton("Jugar");
    String espalda = "C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Memorama\\src\\espalda\\nintendo.jpg";
    // Declaracion de variables y objetos

}
