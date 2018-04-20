import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Ventana extends JFrame{

    public Ventana(){
        iniciarIU();
    }

    private void iniciarIU() {
        setTitle("Rompete la cabeza");
        setSize(800,700);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarBotones(false);
        ponerImganesEnBotones(false);

        crearMenuSup();
        acomodarMesa();
        //otroPanel();
    }

    private void otroPanel(){
        JPanel panel = new JPanel();
        GridBagConstraints conte = new GridBagConstraints();
        conte.gridx = 3;
        conte.gridy = 0;
        conte.gridheight = 2;
        conte.gridwidth = 2;
        conte.weighty = 1.0;
        conte.weightx = 1.0;
        conte.fill = GridBagConstraints.BOTH;
        panel.setBackground(Color.WHITE);
        panel.setSize(100,this.getHeight());

        JButton jugar = new JButton("Jugar");
        jugar.addActionListener((ActionEvent event) ->{
            mesa.removeAll();
            inicializarBotones(true);
            ponerImganesEnBotones(true);
            acomodarMesa();
            mesa.revalidate();
            mesa.repaint();
        });

        panel.add(jugar);

        add(panel,conte);
    }

    private void acomodarMesa(){
        GridBagConstraints conte = new GridBagConstraints();
        conte.gridx = 0;
        conte.gridy = 0;
        conte.gridheight = 3;
        conte.gridwidth = 3;
        conte.weighty = 1.0;
        conte.weightx = 1.0;
        conte.fill = GridBagConstraints.BOTH;

        imprimirRevueltos();

        add(mesa,conte);
    }

    private void crearMenuSup(){
        JMenu archivo = new JMenu("Archivo");

        JMenuItem cerrar = new JMenuItem("Cerrar");
        cerrar.setToolTipText("Cerrar la aplicacion");
        cerrar.addActionListener((ActionEvent event) ->{
            System.exit(0);
        });
        archivo.add(cerrar);

        JMenu iniciar = new JMenu("Iniciar");

        JMenuItem jugar = new JMenuItem("Jugar",KeyEvent.VK_J);
        jugar.addActionListener((ActionEvent event) ->{
            mesa.removeAll();
            inicializarBotones(true);
            ponerImganesEnBotones(true);
            acomodarMesa();
            mesa.revalidate();
            mesa.repaint();
        });
        iniciar.add(jugar);

        JMenu configuracion = new JMenu("Configuración");

        JMenuItem dificultad = new JMenuItem("Dificultad");
        dificultad.addActionListener((ActionEvent event) ->{
           Object selec = JOptionPane.showInputDialog(null,"","Seleccione la dificultad",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Facil","Intermedio","Dificil"},"Facil");
           dificultadElegida = selec.toString();

           switch (dificultadElegida){
               case "Facil":
                   numCeldas = 9;
                   lado = 3;
                   break;
               case "Intermedio":
                   numCeldas = 16;
                   lado = 4;
                   break;
           }

            mesa.removeAll();
            inicializarBotones(false);
            ponerImganesEnBotones(false);
            acomodarMesa();
            mesa.revalidate();
            mesa.repaint();
        });
        JMenuItem elegirImagen = new JMenuItem("Elegir imagen...");
        elegirImagen.addActionListener((ActionEvent event) ->{
            Object selec = JOptionPane.showInputDialog(null,"","Seleccione la imagen",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Platero","Momo","Ignacio"},"Platero");
            imagenSeleccionada = selec.toString().toLowerCase();
            mesa.removeAll();
            inicializarBotones(false);
            ponerImganesEnBotones(false);
            acomodarMesa();
            mesa.revalidate();
            mesa.repaint();
        });
        configuracion.add(dificultad);
        configuracion.add(elegirImagen);

        menuSuperior.add(archivo);
        menuSuperior.add(iniciar);
        menuSuperior.add(configuracion);

        setJMenuBar(menuSuperior);
    }

    private void imprimirRevueltos(){
        mesa.setLayout(new GridLayout(lado  ,lado));

        for (int i =0;i<numCeldas;i++){
            mesa.add(revueltos[i]);
        }
    }

    private void ponerImganesEnBotones(boolean revolver){

        for(int i=0;i<numCeldas;i++){
            revueltos[i].setIcon(new ImageIcon("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Rompezabezas\\src\\imagenes\\"+imagenSeleccionada+"\\"+(i+1)+".png"));
        }

        if(revolver){
            Random alea = new Random();

            for (int j = 0;j<numCeldas;j++){
                int randomPos = alea.nextInt(numCeldas);
                JButton temp = revueltos[j];
                revueltos[j] = revueltos[randomPos];
                revueltos[randomPos] = temp;
            }

        }
    }

    private void inicializarBotones(boolean activar){
        revueltos = new JButton[numCeldas];

        for(int i=0;i<numCeldas;i++){
            revueltos[i] = new JButton();
            revueltos[i].addActionListener((ActionEvent event)->{
                if(anterior.isEmpty()){
                    pulsadoAnterior = (JButton) event.getSource();
                    anterior = pulsadoAnterior.getIcon().toString();
                }else{
                    pulsadoActual = (JButton) event.getSource();
                    actual = pulsadoActual.getIcon().toString();

                    int a = 0;
                    int b = 0;

                    for(int j = 0;j < numCeldas;j++){
                        if(actual.equals(revueltos[j].getIcon().toString())){
                            a = j;
                        }if(anterior.equals(revueltos[j].getIcon().toString())){
                            b = j;
                        }
                    }

                    revueltos[a].setIcon(new ImageIcon(anterior));
                    revueltos[b].setIcon(new ImageIcon(actual));

                    anterior = "";
                    actual = "";

                    comprobarCorrrectos();
                }
            });
            revueltos[i].setEnabled(activar);
        }
    }

    private void comprobarCorrrectos(){
        boolean incorrecto = false;

        for(int i=0;i<numCeldas;i++){
            if(!revueltos[i].getIcon().toString().equals("C:\\Users\\aldom\\Documents\\Codigo\\hello-world\\Tec\\4to semestre\\Topicos\\Rompezabezas\\src\\imagenes\\"+imagenSeleccionada+"\\"+(i+1)+".png")){
                incorrecto = true;
            }
        }

        if(!incorrecto){
            JOptionPane.showMessageDialog(null,"Bien hecho","Has ganado",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }

    //Declaracion de atributos
    JButton[] revueltos;
    JButton pulsadoAnterior,pulsadoActual;
    JPanel mesa = new JPanel();
    JMenuBar menuSuperior = new JMenuBar();
    String dificultadElegida = "Facil";
    String imagenSeleccionada = "momo";
    String anterior = "";
    String actual= "";
    int numCeldas = 9;
    int lado = (int) Math.sqrt(numCeldas);
    //Declaracion de atributos
}
