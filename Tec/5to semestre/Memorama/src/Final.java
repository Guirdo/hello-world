
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Final extends JDialog{
    //Atributos
    private JLabel mensaje,contador;
    private JButton si,no;
    private static boolean continuar;
    private Timer reloj;
    private int tiempo;

    public Final(){
        setTitle("¡Has ganado!");
        setSize(215,150);
        setLocationRelativeTo(null);
        setModal(true);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        tiempo=9;

        mensaje = new JLabel("¿Deseas jugar de nuevo?");
        mensaje.setBounds(20,10,200,20);
        mensaje.setFont(new Font("Arial",1,13));

        contador=new JLabel();
        contador.setText(""+tiempo);
        contador.setBounds(95,40,30,15);
        contador.setFont(new Font("Arial",1,12));

        si = new JButton();
        si.setText("Si");
        si.setBounds(45,70,50,30);
        si.setFont(new Font("Arial",1,12));
        si.addActionListener((ActiveEvent) ->{
            continuar=true;
            reloj.stop();
            dispose();
        });

        no = new JButton();
        no.setText("No");
        no.setBounds(105,70,50,30);
        no.setFont(new Font("Arial",1,12));
        no.addActionListener((ActiveEvent) ->{
            continuar=false;
            dispose();
        });

        reloj = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempo--;
                contador.setText(""+tiempo);
                if (tiempo==-1){
                    System.exit(0);
                }
            }
        });

        reloj.start();

        add(mensaje);
        add(contador);
        add(si);
        add(no);
    }

    public static boolean getContinuar(){
        return continuar;
    }
}
