package mx.edu.itch.isc.seblab.principal;

import mx.edu.itch.isc.seblab.componentes.Boton;
import mx.edu.itch.isc.seblab.componentes.BotonPresion;
import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Pantalla extends JFrame {

    public Boton btnCuadrado,btnTriangulo,btnRectangulo,btnCirculo;
    public BotonPresion btnTextura1,btnTextura2,btnTextura3,btnTextura4;
    public BotonPresion btnPunto,btnLineas,btnTelar;
    public Boton btnBorrar;

    public JPanel lienzo;

    public Pantalla() throws HeadlessException {
        // Configuraciones fundamentales
        this.setTitle("Generar figuras");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new MigLayout("wrap 2","[][]",""));

        lienzo = new JPanel();
        lienzo.setLayout(null);
        lienzo.setBackground(PaletaColores.LINX_WHITE);

        this.add(panelMenu(),"w 200,growy");
        this.add(lienzo,"w :600:,h :600:,push x,push y,growx,growy");

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private JPanel panelMenu(){
        JPanel pnl = new JPanel(new MigLayout("wrap"
                ,"","[]10[]20[]10[][]20[]10[][]25[]"));

        btnRectangulo = new Boton(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/rectangulo.png"));
        btnCuadrado = new Boton(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/cuadrado.png"));
        btnCirculo = new Boton(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/circulo.png"));

        ButtonGroup bgTexturas = new ButtonGroup();
        btnTextura1 =new BotonPresion(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/icono1.png"));
        btnTextura2 =new BotonPresion(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/icono2.png"));
        btnTextura3 =new BotonPresion(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/icono3.png"));
        btnTextura4 =new BotonPresion(Imagen.obtenerImagen(this,"/mx/edu/itch/isc/seblab/texturas/icono4.png"));

        btnPunto = new BotonPresion("Punto");
        btnLineas= new BotonPresion("Lineas");
        btnTelar = new BotonPresion("Telar");
        bgTexturas.add(btnTextura1);
        bgTexturas.add(btnTextura2);
        bgTexturas.add(btnTextura3);
        bgTexturas.add(btnTextura4);
        bgTexturas.add(btnPunto);
        bgTexturas.add(btnLineas);
        bgTexturas.add(btnTelar);
        btnTextura1.setSelected(true);

        btnBorrar = new Boton("Borrar");

        pnl.setBackground(PaletaColores.LINX_WHITE);

        pnl.add(new JLabel("Figuras"));
        pnl.add(btnRectangulo,"split 3");
        pnl.add(btnCuadrado);
        pnl.add(btnCirculo);
        pnl.add(new JLabel("Textura"));
        pnl.add(btnTextura1,"split 3,w 55,h 55");
        pnl.add(btnTextura2,"w 55,h 55");
        pnl.add(btnTextura3,"w 55,h 55");
        pnl.add(btnTextura4,"w 55,h 55");
        pnl.add(new JLabel("Entramado"));
        pnl.add(btnPunto,"split 2");
        pnl.add(btnLineas);
        pnl.add(btnTelar);
        pnl.add(btnBorrar,"growx");

        return pnl;
    }

}
