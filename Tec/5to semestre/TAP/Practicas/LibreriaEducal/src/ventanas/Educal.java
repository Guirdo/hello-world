package ventanas;

import assets.Escritorio;
import clases.ConexionBD;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import ventanasInternas.Agregar;
import ventanasInternas.Buscar;

public class Educal extends JFrame {

    private ConexionBD conexion;
    private Escritorio panel;

    public Educal(ConexionBD c) {
        this.conexion = c;
        this.setTitle("Libreria Educal");
        this.setLocation(0, 0);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());

        //JMenuBar----------------------------------------(Inicio)
        JMenuBar menu = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem salirArchivo = new JMenuItem("Salir");
        salirArchivo.addActionListener((ActionEvent) -> {
            System.exit(0);
        });
        JMenuItem estadistica = new JMenuItem("Estadistica");
        archivo.add(estadistica);
        archivo.add(salirArchivo);
        menu.add(archivo);
        this.setJMenuBar(menu);
        //JMenuBar----------------------------------------(Fin)

        //Desktop----------------------------------------------------------(Inicio)
        panel = new Escritorio();
        Buscar buscarVI = new Buscar();
        Agregar agregarVI = new Agregar();
        panel.add(buscarVI);
        panel.add(agregarVI);

        //Desktop----------------------------------------------------------(Fin)
        //Columna de botones----------------------------------------(Inicio)
        Image img;
        JPanel columnaBotones = new JPanel();
        columnaBotones.setLayout(new GridLayout(5, 1, 0, 0));

        JButton buscar = new JButton("Buscar");
        img = new ImageIcon(getClass().getResource("/imagenes/iconos/buscar.png")).getImage();
        buscar.setIcon(new ImageIcon(img));
        buscar.setMnemonic('b');
        buscar.addActionListener((ActionEvent) -> {
            buscarVI.setVisible(true);
            buscarVI.moveToFront();
        });

        JButton agregar = new JButton("Agregar");
        img = img = new ImageIcon(getClass().getResource("/imagenes/iconos/agregar.png")).getImage();
        agregar.setIcon(new ImageIcon(img));
        agregar.setMnemonic('a');
        agregar.addActionListener((ActionEvent) -> {
            agregarVI.setVisible(true);
            agregarVI.moveToFront();
        });

        JButton venta = new JButton("Venta");
        img =img = new ImageIcon(getClass().getResource("/imagenes/iconos/venta.png")).getImage();
        venta.setIcon(new ImageIcon(img));
        venta.setMnemonic('v');
        venta.addActionListener((ActionEvent) -> {

        });

        JButton salir = new JButton("Salir");
        salir.setMnemonic('s');
        salir.addActionListener((ActionEvent) -> {
            System.exit(0);
        });

        columnaBotones.add(buscar);
        columnaBotones.add(agregar);
        columnaBotones.add(venta);
        columnaBotones.add(salir);

        //Columna de botones----------------------------------------(Fin)
        this.add(columnaBotones, BorderLayout.WEST);
        this.add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
            //InicioSesion is = new InicioSesion();
            //is.setVisible(true);
            new Educal(null).setVisible(true);
    }

}
