import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Ventana extends JFrame {

    public Ventana(){
        iniciarIU();
    }

    //Metodo principal
    public static void main(String []args){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }

    //Trabajo
    public String imprimirListaDesordenada(){
        String salida = "";

        for(int i = 0; i< listaDesordenada.size(); i++){
            salida+="  " + listaDesordenada.get(i)+"\n";
        }

        return salida;
    }

    public String imprimirLista(){
        String salida = "";

        for(int i = 0; i< lista.size(); i++){
            salida+= "  " + lista.get(i)+"\n";
        }

        return salida;
    }

    public void ordenar(){
        for(int i=2;i<lista.size();i++){
            for(int j=0;j<lista.size();j++){
                if((j+1) < lista.size()){
                    int valueA = lista.get(j).toUpperCase().charAt(0);
                    int valueB = lista.get(j+1).toUpperCase().charAt(0);
                    if(valueA>valueB){
                        String aux = lista.get(j);
                        lista.set(j, lista.get(j+1));
                        lista.set(j+1, aux);
                    }
                }
            }
        }
    }

    //Ventana
    public void iniciarIU(){
        setSize(470,480);
        setLocationRelativeTo(null);
        setTitle("Metodo burbuja");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        texto1.setBounds(20,20,150,25);
        dato.setBounds(20,50,100,25);
        ingresar.setBounds(130,50,90,25);
        desordenados.setBounds(240,20,190,190);
        ordenados.setBounds(240,230,190,190);
        ordenar.setBounds(60,320,90,25);

        ingresar.addActionListener((ActionEvent e) ->{
            String nom = dato.getText();
            listaDesordenada.add(nom);
            dato.setText("");
            desordenados.setText(imprimirListaDesordenada());
        });

        ordenar.addActionListener((ActionEvent e)->{
            lista = listaDesordenada;
            ordenar();
            ordenados.setText(imprimirLista());
        });

        //add
        add(texto1);
        add(dato);
        add(ingresar);
        add(desordenados);
        add(ordenados);
        add(ordenar);
    }

    //Declaracion de atributos y objetos
    JLabel texto1 = new JLabel("Ingrese un nombre");
    JTextField dato = new JTextField("");
    JButton ingresar = new JButton("Ingresar");
    JButton ordenar = new JButton("ORDENAR");
    JTextArea desordenados = new JTextArea();
    JTextArea ordenados = new JTextArea();
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<String> listaDesordenada = new ArrayList<>();
}
