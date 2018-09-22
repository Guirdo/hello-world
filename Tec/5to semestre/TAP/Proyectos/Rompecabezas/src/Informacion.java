import javax.swing.*;

public class Informacion extends JFrame {

    private JLabel imagen;
    private JTextArea info;

    public Informacion(String artista){
        setTitle("¡Información que expresiona!");
        setBounds(800,180,400,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        imagen = new JLabel();
        imagen.setBounds(45,25,300,300);
        imagen.setIcon(new ImageIcon("src\\imagenes\\"+artista+".png"));

        info = new JTextArea();
        info.setText(datosArtistaObra(artista));
        info.setBounds(15,350,350,100);
        info.setEditable(false);

        add(imagen);
        add(info);
        setVisible(true);
    }

    public String datosArtistaObra(String artista){
        String salida="";
        switch (artista){
            case "kandinsky":
                salida = "    Autor: Vassily Kandinsky\n" +
                        "    Título original: Einige Kreise\n" +
                        "    Museo: Guggenheim, Nueva York (Estados Unidos)\n" +
                        "    Técnica: Óleo (140.3 x 140.7 cm.)\n";
                break;
            case "kirchner":
                salida = "    Autor: Ernst Ludwig Kirchner\n"+
                        "    Título original: Sitzendes Mädchen\n" +
                        "    Museo: Minneapolis Institute of Arts, Minneapolis (Estados Unidos)\n" +
                        "    Técnica: Óleo (91 x 81 cm.)\n";
                break;
                default:
                    salida = "Hola mundo";
        }

        return salida;
    }
}
