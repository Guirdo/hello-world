
package actividadpilas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Botones extends JFrame implements ActionListener {
    JButton boton1, boton2, boton3, boton4;
    JLabel texto;
    pila acc= new pila();

    public Botones() {
        setLayout(null);
        boton1=new JButton("ALTAS");
        boton1.setBounds(100,200,100,30);
        boton1.addActionListener(this);
        add(boton1);
        boton2=new JButton("BAJAS");
        boton2.setBounds(100,250,100,30);
        boton2.addActionListener(this);
        add(boton2);
        boton3=new JButton("LISTADOS");
        boton3.setBounds(100,300,100,30);
        boton3.addActionListener(this);
        add(boton3);
        boton4=new JButton("SALIR");
        boton4.setBounds(110,400,80,30);
        boton4.addActionListener(this);
        add(boton4);
        texto=new JLabel("Manejo de pilas.");
        texto.setBounds(80,10,400,200);
        texto.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC, 18));
        add(texto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==boton4) {
            setTitle("Saliendo...");
            try{
                System.exit(0);
            } catch(Exception excep) {
            System.exit(0);
            }
        }
        if(e.getSource()==boton1){
            setTitle("Menú pilas.");
            int i=0;
            int num = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de elementos.","Entrada",JOptionPane.QUESTION_MESSAGE));
            if(acc.getTam()==0){
                acc.setTam(num);
            }else{
                i=acc.cont;
            }
            for(int j=i;j<num;j++)
            acc.Alta_Elem();
        }
        if(e.getSource()==boton2){
            acc.Contenido();
            acc.Baja_Elem();
            acc.Contenido();
        }
        if(e.getSource()==boton3){
            acc.Contenido();
        }
        
    }
    
}
