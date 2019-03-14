/*
 * Alguien lee esto, no lo creo.
 */
package mision1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Diana Vzqx
 */
public class Mision1 extends JFrame implements MouseListener {

    private JPanel lienzo;
    private ArrayList<Figura> listaFiguras;
    private Color color;
    private int pos = -1;
    private JFileChooser chooser;

    public Mision1() {
        this.setTitle("Mision 1");
        this.setBounds(100, 100, 800, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#fc64d9"));
        this.setLayout(null);

        listaFiguras = new ArrayList<>();
        color = Color.BLACK;

        chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo binario dat", "dat");
        chooser.setFileFilter(filtro);

        JMenuBar menu = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem abrir = new JMenuItem("Abrir.");
        JMenuItem guardar = new JMenuItem("Guardar.");

        menu.add(archivo);
        archivo.add(abrir);
        archivo.add(guardar);

        this.setJMenuBar(menu);

        Image img;
        img = new ImageIcon(getClass().getResource("/imagenes/circulo.jpeg")).getImage();
        JButton btnCirculo = new JButton();
        btnCirculo.setIcon(new ImageIcon(img));
        btnCirculo.setBounds(10, 10, 102, 102);

        img = new ImageIcon(getClass().getResource("/imagenes/cuadrado.jpeg")).getImage();
        JButton btnCuadrado = new JButton();
        btnCuadrado.setIcon(new ImageIcon(img));
        btnCuadrado.setBounds(10, 122, 102, 102);

        img = new ImageIcon(getClass().getResource("/imagenes/triangulo.jpeg")).getImage();
        JButton btnTriangulo = new JButton();
        btnTriangulo.setIcon(new ImageIcon(img));
        btnTriangulo.setBounds(10, 234, 102, 102);

        img = new ImageIcon(getClass().getResource("/imagenes/rectangulo.jpeg")).getImage();
        JButton btnRectangulo = new JButton();
        btnRectangulo.setIcon(new ImageIcon(img));
        btnRectangulo.setBounds(10, 346, 102, 102);

        JButton btnColor = new JButton("Cambiar color");
        btnColor.setFont(new Font("Arial", 1, 9));
        btnColor.setBounds(5, 470, 115, 25);

        JButton btnTam = new JButton("Cambiar tamaño");
        btnTam.setFont(new Font("Arial", 1, 10));
        btnTam.setBounds(5, 510, 115, 25);

        lienzo = new JPanel();
        lienzo.setLayout(null);
        lienzo.setBackground(Color.WHITE);
        lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lienzo.setBounds(150, 10, 625, 540);

        btnCirculo.addActionListener((ActionEvent) -> {
            String radio = JOptionPane.showInputDialog(null, "Introduzca el radio del circulo.");

            Circulo cir = new Circulo(color, Integer.parseInt(radio));
            cir.addMouseListener(this);
            lienzo.add(cir);
            lienzo.repaint();
            lienzo.revalidate();
            listaFiguras.add(cir);
        });

        btnCuadrado.addActionListener((ActionEvent) -> {
            String lado = JOptionPane.showInputDialog(null, "Introduzca el lado del cuadrado.");

            Cuadrado cua = new Cuadrado(color, Integer.parseInt(lado));
            cua.addMouseListener(this);
            lienzo.add(cua);
            lienzo.repaint();
            lienzo.revalidate();
            listaFiguras.add(cua);
        });

        btnTriangulo.addActionListener((ActionEvent) -> {
            String base = JOptionPane.showInputDialog(null, "Introduzca la base del triangulo.");
            String altura = JOptionPane.showInputDialog(null, "Introduzca la altura del triangulo.");

            Triangulo tri = new Triangulo(color, Integer.parseInt(base), Integer.parseInt(altura));
            tri.addMouseListener(this);
            lienzo.add(tri);
            lienzo.repaint();
            lienzo.revalidate();
            listaFiguras.add(tri);
        });

        btnRectangulo.addActionListener((ActionEvent) -> {
            String base = JOptionPane.showInputDialog(null, "Introduzca la base del triangulo.");
            String altura = JOptionPane.showInputDialog(null, "Introduzca la altura del triangulo.");

            Rectangulo rec = new Rectangulo(color, Integer.parseInt(base), Integer.parseInt(altura));
            rec.addMouseListener(this);
            lienzo.add(rec);
            lienzo.repaint();
            lienzo.revalidate();
            listaFiguras.add(rec);
        });

        btnColor.addActionListener((ActionEvent) -> {
            JColorChooser cc = new JColorChooser();
            color = cc.showDialog(null, "Selecciona un color", Color.BLACK);
            if (pos != -1) {
                listaFiguras.get(pos).setVisible(false);
                listaFiguras.get(pos).setColor(color);
                listaFiguras.get(pos).setVisible(true);
            }
        });

        btnTam.addActionListener((ActionEvent) -> {
            if (pos != -1) {
                if (listaFiguras.get(pos) instanceof Circulo) {
                    String radio = JOptionPane.showInputDialog(null, "Introduzca el radio del circulo.");

                    ((Circulo) listaFiguras.get(pos)).cambiarTam(Integer.parseInt(radio));
                } else if (listaFiguras.get(pos) instanceof Cuadrado) {
                    String lado = JOptionPane.showInputDialog(null, "Introduzca el lado del cuadrado.");

                    ((Cuadrado) listaFiguras.get(pos)).cambiarTam(Integer.parseInt(lado));
                } else if (listaFiguras.get(pos) instanceof Triangulo) {
                    String base = JOptionPane.showInputDialog(null, "Introduzca la base del triangulo.");
                    String altura = JOptionPane.showInputDialog(null, "Introduzca la altura del triangulo.");

                    ((Triangulo) listaFiguras.get(pos)).cambiarTam(Integer.parseInt(base), Integer.parseInt(altura));
                } else if (listaFiguras.get(pos) instanceof Rectangulo) {
                    String base = JOptionPane.showInputDialog(null, "Introduzca la base del rectangulo.");
                    String altura = JOptionPane.showInputDialog(null, "Introduzca la altura del rectangulo.");

                    ((Rectangulo) listaFiguras.get(pos)).cambiarTam(Integer.parseInt(base), Integer.parseInt(altura));
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Aún no has dibujado nada", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        });

        abrir.addActionListener((ActionEvent) -> {
            int opcion = chooser.showOpenDialog(this);

            if (opcion == 0) {
                ObjectInputStream obs = null;
                lienzo.removeAll();
                try {
                    obs = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));

                    while (true) {
                        Figura fig = (Figura) obs.readUnshared();

                        fig.addMouseListener(this);
                        fig.addMouseMotionListener(fig);

                        listaFiguras.add(fig);
                        lienzo.add(fig);
                        lienzo.repaint();
                        
                    }
                } catch (FileNotFoundException ex) {

                } catch (IOException ex) {
                    try {
                        if (obs != null) {
                            obs.close();
                        }
                    } catch (IOException ex1) {

                    }
                } catch (ClassNotFoundException ex) {

                }
            }
        });

        guardar.addActionListener((ActionEvent) -> {
            int opcion = chooser.showSaveDialog(this);
            if (opcion == 0) {
                ObjectOutputStream oos = null;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));

                    for (int i = 0; i < listaFiguras.size(); i++) {
                        listaFiguras.get(i).removeMouseListener(this);
                        listaFiguras.get(i).removeMouseMotionListener(listaFiguras.get(i));

                        oos.writeUnshared(listaFiguras.get(i));

                        listaFiguras.get(i).addMouseListener(this);
                        listaFiguras.get(i).addMouseMotionListener(listaFiguras.get(i));
                    }
                    oos.flush();
                    oos.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("Flujo FNF: " + ex.getMessage());
                } catch (IOException ex) {
                    System.out.println("Flujo IOEx" + ex.getMessage());
                }
            }
        }
        );

        this.add(btnCirculo);
        this.add(btnCuadrado);
        this.add(btnTriangulo);
        this.add(btnRectangulo);
        this.add(btnColor);
        this.add(btnTam);
        this.add(lienzo);

    }

    public static void main(String[] args) {
        Mision1 ms = new Mision1();
        ms.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        for (int i = 0; i < listaFiguras.size(); i++) {
            if (e.getSource().equals(listaFiguras.get(i))) {
                pos = i;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < listaFiguras.size(); i++) {
            if (e.getSource().equals(listaFiguras.get(i))) {
                pos = i;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
