import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Ventana extends JFrame {
    long inicio = System.currentTimeMillis();

    //Declaración de objetos
    JPanel panel;

    JTextField rest1X1 = new JTextField("0");
    JTextField rest1X2 = new JTextField("0");
    JTextField rest1B = new JTextField("0");

    JTextField rest2X1 = new JTextField("0");
    JTextField rest2X2 = new JTextField("0");
    JTextField rest2B = new JTextField("0");

    JTextField rest3X1 = new JTextField("0");
    JTextField rest3X2 = new JTextField("0");
    JTextField rest3B = new JTextField("0");

    JTextField rest4B = new JTextField("0");
    JButton ingresar = new JButton("Ingrese");

    JTextField funObjX1 = new JTextField("0");
    JTextField funObjX2 = new JTextField("0");

    Grafica grafica;

    //fin de declaracion de objetos

    public Ventana (){
        initUI();
    }

    public void initUI(){
        setJMenuBar(new MenuSuperior());
        crearPanel();
        pack();

        setTitle("Método gráfico");
        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        System.out.println(System.currentTimeMillis()-inicio);
    }

    public void crearPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        int y = 20;

        //Declaracion de textos
        JLabel titulo = new JLabel("Restricciones");
        JLabel texto1 = new JLabel("x1 + ");
        JLabel texto2 = new JLabel("x2 <= ");
        JLabel texto3 = new JLabel("x1 + ");
        JLabel texto4 = new JLabel("x2 <= ");
        JLabel texto5 = new JLabel("x1 + ");
        JLabel texto6 = new JLabel("x2 <= ");
        JLabel texto7 = new JLabel("x1x2 >= ");
        JLabel texto8 = new JLabel("Max Z =");
        JLabel texto9 = new JLabel("x1 + ");
        JLabel texto10 = new JLabel("x2");
        //

        texto8.setBounds(20,y,60,20);
        funObjX1.setBounds(80,y,20,20);
        texto9.setBounds(100,y,40,20);
        funObjX2.setBounds(140,y,20,20);
        texto10.setBounds(160,y,20,20);
        y+=30;

        titulo.setBounds(30,y,100,20);
        panel.add(titulo);
        y+=30;

        //Primer restricción
        rest1X1.setBounds(20,y,25,20);
        texto1.setBounds(45,y,40,20);
        rest1X2.setBounds(85,y,25,20);
        texto2.setBounds(110,y,45,20);
        rest1B.setBounds(155,y,25,20);
        y+=25;

        //Segundo renglón
        rest2X1.setBounds(20,y,25,20);
        texto3.setBounds(45,y,40,20);
        rest2X2.setBounds(85,y,25,20);
        texto4.setBounds(110,y,45,20);
        rest2B.setBounds(155,y,25,20);
        y+=25;

        //Tercer renglón
        rest3X1.setBounds(20,y,25,20);
        texto5.setBounds(45,y,40,20);
        rest3X2.setBounds(85,y,25,20);
        texto6.setBounds(110,y,45,20);
        rest3B.setBounds(155,y,25,20);
        y+=25;

        //Cuarto renglón
        texto7.setBounds(40,y,60,20);
        rest4B.setBounds(100,y,20,20);
        y+=40;

        ingresar.addActionListener((ActionEvent event) ->{
            entradaDatos();
        });
        ingresar.setBounds(90,y,90,20);

        //Agregando objetos
        panel.add(rest1X1);
        panel.add(texto1);
        panel.add(rest1X2);
        panel.add(texto2);
        panel.add(rest1B);

        panel.add(rest2X1);
        panel.add(texto3);
        panel.add(rest2X2);
        panel.add(texto4);
        panel.add(rest2B);

        panel.add(rest3X1);
        panel.add(texto5);
        panel.add(rest3X2);
        panel.add(texto6);
        panel.add(rest3B);

        panel.add(texto7);
        panel.add(rest4B);

        panel.add(texto8);
        panel.add(funObjX1);
        panel.add(texto9);
        panel.add(funObjX2);
        panel.add(texto10);

        panel.add(ingresar);

        add(panel);
    }

    public void entradaDatos(){
        int x1_1 = Integer.parseInt(rest1X1.getText());
        int x2_1 = Integer.parseInt(rest1X2.getText());
        int x1_2 = Integer.parseInt(rest2X1.getText());
        int x2_2 = Integer.parseInt(rest2X2.getText());
        int x1_3 = Integer.parseInt(rest3X1.getText());
        int x2_3 = Integer.parseInt(rest3X2.getText());

        int b1 = Integer.parseInt(rest1B.getText());
        int b2 = Integer.parseInt(rest2B.getText());
        int b3 = Integer.parseInt(rest3B.getText());
        int b4 = Integer.parseInt(rest4B.getText());

        int x1_fun = Integer.parseInt(funObjX1.getText());
        int x2_fun = Integer.parseInt(funObjX2.getText());

        this.grafica = new Grafica(x1_1,x2_1,x1_2,x2_2,x1_3,x2_3,x1_fun,x2_fun,b1,b2,b3,b4);

        grafica.setVisible(true);

        this.dispose();

    }


}
