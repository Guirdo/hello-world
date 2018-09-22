import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Tablero extends JFrame {

    //Atributos inicio
    private ArrayList<Boton> listaBotones;
    private Boton pulsadoAnterior,pulsadoActual;
    private String anterior,actual,salSeg,salMin,salidaCronometro;
    private int numeroPiezas,ladoPieza, segundos,minutos;
    private JPanel panelRompecabezas,panelOpciones,panelCronometro,panelJugar;
    private Boton jugar, informacion;
    private JComboBox jcArtistas,jcDificultad;
    private Informacion info;
    private String artista,dificultad;
    private JLabel lblArtista,lblDificultad,lblCronometro;
    private boolean estadoJugable;
    private Timer reloj;
    private JTextArea registroCronometro;
    //Atributos fin


    public Tablero(){
        setTitle("Rompecabezas expresionista");
        setLayout(null);
        setBounds(200,200,550,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listaBotones = new ArrayList<>();
        dificultad="facil";
        artista="kandinsky";
        numeroPiezas=9;
        ladoPieza=100;
        anterior="";
        actual="";
        salMin="";
        salSeg="";
        minutos=0;
        segundos=0;
        estadoJugable=false;
        salidaCronometro="";
        info = null;

        panelRompecabezas = new JPanel();
        panelRompecabezas.setLayout(null);
        panelRompecabezas.setBounds(0,0,360,361);
        panelRompecabezas.setBorder(BorderFactory.createTitledBorder("Rompecabezas"));
        panelRompecabezas.setBackground(Color.WHITE);
        crearPiezas(false);

        panelOpciones = new JPanel();
        panelOpciones.setLayout(null);
        panelOpciones.setBounds(360,0,173,145);
        panelOpciones.setBorder(BorderFactory.createTitledBorder("Opciones"));
        crearBotonesOpcion();

        panelCronometro = new JPanel();
        panelCronometro.setLayout(null);
        panelCronometro.setBounds(360,145,173,150);
        panelCronometro.setBorder(BorderFactory.createTitledBorder("Cronometro"));
        cronometraje();

        panelJugar = new JPanel();
        panelJugar.setLayout(null);
        panelJugar.setBounds(360,295,173,66);
        panelJugar.setBorder(BorderFactory.createTitledBorder("Jugar"));
        crearBotonesJugar();

        add(panelRompecabezas);
        add(panelOpciones);
        add(panelCronometro);
        add(panelJugar);
    }

    public void cronometraje(){
        //Cronometro
        lblCronometro = new JLabel("00:00");
        lblCronometro.setBounds(70,20,50,20);
        lblCronometro.setFont(new Font("Arial",1,14));
        reloj = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;

                if(segundos > 59){
                    minutos++;
                    segundos=0;
                }

                if(segundos < 10){
                    salSeg = "0"+segundos;
                }else {
                    salSeg = segundos+"";
                }

                if (minutos < 10){
                    salMin = "0"+minutos;
                }else{
                    salMin = minutos+"";
                }

                salidaCronometro = salMin+":"+salSeg;

                lblCronometro.setText(salidaCronometro);
            }
        });

        //Registro
        registroCronometro = new JTextArea();
        registroCronometro.setBounds(25,45,120,90);
        registroCronometro.setEditable(false);

        panelCronometro.add(lblCronometro);
        panelCronometro.add(registroCronometro);
    }

    public void crearBotonesJugar(){
        //Boton Ayuda
        informacion = new Boton();
        informacion.setIcon(new ImageIcon("src\\imagenes\\informacion.png"));//Icon made by Freepik from www.flaticon.com
        informacion.setBounds(120,25,30,30);
        informacion.addActionListener((ActiveEvent)->{
            if(estadoJugable){
                if(info == null){
                    info = new Informacion(artista);
                }
            }
        });

        //Boton Jugar
        jugar = new Boton();
        jugar.setIcon(new ImageIcon("src\\imagenes\\jugar.png"));//Icon made by Appzgear from www.flaticon.com 
        jugar.setBounds(25,25,90,30);
        jugar.addActionListener((ActionEvent)->{
            estadoJugable=true;
            jcArtistas.setEnabled(false);
            jcDificultad.setEnabled(false);
            reloj.start();

            panelRompecabezas.removeAll();
            listaBotones = new ArrayList<>();
            crearPiezas(true);
            panelRompecabezas.revalidate();
            panelRompecabezas.repaint();
            jugar.setEnabled(false);
        });

        panelJugar.add(informacion);
        panelJugar.add(jugar);
    }

    public void crearBotonesOpcion(){
        //JCombo Artistas
        lblArtista = new JLabel("Artista");
        lblArtista.setBounds(25,25,60,15);
        lblArtista.setFont(new Font("Arial",2,12));

        jcArtistas = new JComboBox();
        jcArtistas.addItem("Kandinsky");
        jcArtistas.addItem("Kirchner");
        jcArtistas.setBounds(25,45,100,20);
        jcArtistas.addActionListener((ActiveEvent)->{
            artista=jcArtistas.getSelectedItem().toString().toLowerCase();

            panelRompecabezas.removeAll();
            listaBotones = new ArrayList<>();
            crearPiezas(false);
            panelRompecabezas.revalidate();
            panelRompecabezas.repaint();
        });

        //JCombo Dificultad
        lblDificultad = new JLabel("Dificultad");
        lblDificultad.setBounds(25,80,60,15);
        lblDificultad.setFont(new Font("Arial",2,12));

        jcDificultad = new JComboBox();
        jcDificultad.addItem("Facil");
        jcDificultad.addItem("Medio");
        jcDificultad.addItem("Dificil");
        jcDificultad.setBounds(25,100,100,20);
        jcDificultad.addActionListener((ActiveEvent)->{
            dificultad=jcDificultad.getSelectedItem().toString().toLowerCase();
            ponerDificultad(dificultad);

            panelRompecabezas.removeAll();
            listaBotones = new ArrayList<>();
            crearPiezas(false);
            panelRompecabezas.revalidate();
            panelRompecabezas.repaint();
        });

        panelOpciones.add(lblArtista);
        panelOpciones.add(jcArtistas);
        panelOpciones.add(lblDificultad);
        panelOpciones.add(jcDificultad);
    }

    public void crearPiezas(boolean revolver){
        int x=30;
        int y=30;
        Boton b;

        //Inicializo y pongo imagen a los botones
        for(int i=0;i<numeroPiezas;i++){
            b = new Boton();
            b.setIcon(new ImageIcon("src\\imagenes\\"+artista+"\\"+dificultad+"\\"+i+".png"));
            b.setBorder(null);
            b.addActionListener((ActionEvent event)->{
                if(estadoJugable){
                    if (anterior.isEmpty()){
                        pulsadoAnterior = (Boton) event.getSource();
                        anterior = pulsadoAnterior.getIcon().toString();
                    }else{
                        pulsadoActual = (Boton) event.getSource();
                        actual = pulsadoActual.getIcon().toString();

                        int piezaA = 0;
                        int piezaB = 0;

                        for(int j = 0;j < numeroPiezas;j++){
                            if(actual.equals(listaBotones.get(j).getIcon().toString())){
                                piezaA = j;
                            }if(anterior.equals(listaBotones.get(j).getIcon().toString())){
                                piezaB = j;
                            }
                        }

                        listaBotones.get(piezaA).setIcon(new ImageIcon(anterior));
                        listaBotones.get(piezaB).setIcon(new ImageIcon(actual));

                        anterior = "";
                        actual = "";

                        comprobarGanado();
                    }
                }
            });

            listaBotones.add(b);
        }

        //Revuelvo el arraylist solo si el juego empezo
        if (revolver){
            Random aleatorio = new Random();
            for(int i=0;i<numeroPiezas;i++){
                int randomPos = aleatorio.nextInt(numeroPiezas);
                Boton temp = listaBotones.get(i);
                listaBotones.set(i,listaBotones.get(randomPos));
                listaBotones.set(randomPos,temp);
            }
        }

        //Pongo limites a los botones
        for (int i=0;i<numeroPiezas;i++){
            listaBotones.get(i).setBounds(x,y,ladoPieza,ladoPieza);
            x+=ladoPieza;
            if(x==330){
                x=30;
                y+=ladoPieza;
            }
            panelRompecabezas.add(listaBotones.get(i));
        }

    }

    public void comprobarGanado(){
        boolean incorrecto = false;

        for(int i=0;i<numeroPiezas;i++){
            if(!listaBotones.get(i).getIcon().toString().equals("src\\imagenes\\"+artista+"\\"+dificultad+"\\"+i+".png")){
                incorrecto=true;
                break;
            }
        }

        if (!incorrecto){
            reloj.stop();
            new Final().setVisible(true);
            if(Final.getContinuar()){
                if(info!=null){
                    info.dispose();
                    info=null;
                }
                estadoJugable=false;
                jcArtistas.setEnabled(true);
                jcDificultad.setEnabled(true);
                jugar.setEnabled(true);
                registroCronometro.setText(registroCronometro.getText()+salidaCronometro+"\n");
                salMin="";
                salSeg="";
                minutos=0;
                segundos=0;
                salidaCronometro="00:00";
                lblCronometro.setText(salidaCronometro);

                panelRompecabezas.removeAll();
                listaBotones = new ArrayList<>();
                crearPiezas(false);
                panelRompecabezas.revalidate();
                panelRompecabezas.repaint();
            }else{
                System.exit(0);
            }
        }
    }

    public void ponerDificultad(String dificultad){
        switch (dificultad){
            case "facil":
                ladoPieza=100;
                numeroPiezas=9;
                break;
            case "medio":
                ladoPieza=75;
                numeroPiezas=16;
                break;
            case "dificil":
                ladoPieza=60;
                numeroPiezas=25;
                break;
        }
    }

}