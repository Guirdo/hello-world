/*
 * Hola!
 */
package generadorfiguras;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class GeneradorFiguras extends JFrame implements MouseListener, Serializable {

    private ArrayList<Figura> figuras;
    private JPanel lienzo;
    private JColorChooser godete;
    private Color color;
    private int pos;
    private JLabel lbl_1, lbl_2, lblBase, lblAltura;
    private JTextField tf_1, tf_2, tfBase, tfAltura;
    private JFileChooser chooser;

    public GeneradorFiguras() {
        this.setTitle("Generador de figuras");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 580);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        color = new Color(0, 0, 0);
        godete = new JColorChooser(new Color(0, 0, 0));
        pos = -1;
        figuras = new ArrayList<>();

        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        JMenuBar menu = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem exportar = new JMenuItem("Exportar a png");

        lienzo = new JPanel();
        lienzo.setBounds(130, 10, 500, 500);
        lienzo.setLayout(null);
        lienzo.setBackground(Color.WHITE);
        lienzo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        lbl_1 = new JLabel("Radio: ");
        lbl_2 = new JLabel("Lado: ");

        lbl_1.setVisible(false);
        lbl_2.setVisible(false);

        tf_1 = new JTextField();
        tf_2 = new JTextField();

        tf_1.setVisible(false);
        tf_2.setVisible(false);

        lbl_1.setBounds(650, 20, 50, 25);
        tf_1.setBounds(705, 20, 30, 25);
        lbl_2.setBounds(650, 55, 50, 25);
        tf_2.setBounds(705, 55, 30, 25);

        this.add(lbl_1);
        this.add(tf_1);
        this.add(lbl_2);
        this.add(tf_2);

        JToggleButton circulo = new JToggleButton(new ImageIcon("src\\imagenes\\circulo.png"));
        circulo.setBounds(10, 10, 100, 100);
        circulo.addActionListener((ActionEvent) -> {
            lbl_1.setVisible(true);
            lbl_2.setVisible(false);
            tf_1.setVisible(true);
            tf_2.setVisible(false);
            lbl_1.setText("Radio");
        });

        JToggleButton cuadrado = new JToggleButton(new ImageIcon("src\\imagenes\\cuadrado.png"));
        cuadrado.setBounds(10, 120, 100, 100);
        cuadrado.addActionListener((ActionEvent) -> {
            lbl_1.setVisible(true);
            lbl_2.setVisible(false);
            tf_1.setVisible(true);
            tf_2.setVisible(false);
            lbl_1.setText("Lado");
        });

        JToggleButton triangulo = new JToggleButton(new ImageIcon("src\\imagenes\\triangulo.png"));
        triangulo.setBounds(10, 230, 100, 100);
        triangulo.addActionListener((ActionEvent) -> {
            lbl_1.setVisible(true);
            lbl_2.setVisible(true);
            tf_1.setVisible(true);
            tf_2.setVisible(true);
            lbl_1.setText("Base");
            lbl_2.setText("Altura");
        });

        JToggleButton rectangulo = new JToggleButton(new ImageIcon("src\\imagenes\\rectan.png"));
        rectangulo.setBounds(10, 340, 100, 100);
        rectangulo.addActionListener((ActionEvent) -> {
            lbl_1.setVisible(true);
            lbl_2.setVisible(true);
            tf_1.setVisible(true);
            tf_2.setVisible(true);
            lbl_1.setText("Base");
            lbl_2.setText("Altura");
        });

        ButtonGroup bg = new ButtonGroup();
        bg.add(circulo);
        bg.add(cuadrado);
        bg.add(triangulo);
        bg.add(rectangulo);

        JButton dibujar = new JButton("Dibujar");
        dibujar.setBounds(650, 210, 90, 20);
        dibujar.addActionListener((ActionEvent) -> {
            if (circulo.isSelected()) {
                figuras.add(new Circulo(color, Integer.parseInt(tf_1.getText())));
                tf_1.setText("");
            } else if (cuadrado.isSelected()) {
                figuras.add(new Cuadrado(color, Integer.parseInt(tf_1.getText())));
                tf_1.setText("");
            } else if (triangulo.isSelected()) {
                figuras.add(new Triangulo(color, Integer.parseInt(tf_1.getText()), Integer.parseInt(tf_2.getText())));
                tf_1.setText("");
                tf_2.setText("");
            } else {
                figuras.add(new Rectangulo(color, Integer.parseInt(tf_1.getText()), Integer.parseInt(tf_2.getText())));
                tf_1.setText("");
                tf_2.setText("");
            }

            this.redibujarLienzo();
            color = Color.BLACK;
        });

        JButton cambiarColor = new JButton("Color");
        cambiarColor.setBounds(650, 250, 90, 20);
        cambiarColor.addActionListener((ActionEvent) -> {
            if (pos == -1) {
                color = godete.showDialog(null, "Selecciona un color", new Color(0, 0, 0));
            } else {
                color = godete.showDialog(null, "Selecciona un color", new Color(0, 0, 0));
                figuras.get(pos).setVisible(false);
                figuras.get(pos).setColor(color);
                figuras.get(pos).setVisible(true);
                color = Color.BLACK;
                pos = -1;
            }
        });

        JButton cambiarTam = new JButton("Tamaño");
        cambiarTam.setBounds(650, 280, 90, 20);
        cambiarTam.addActionListener((ActionEvent) -> {
            if (pos != -1) {
                figuras.get(pos).setVisible(false);
                if (figuras.get(pos) instanceof Circulo && !tf_1.getText().isEmpty()) {
                    ((Circulo) figuras.get(pos)).cambiarTamano(Integer.parseInt(tf_1.getText()));
                    tf_1.setText("");
                } else if (figuras.get(pos) instanceof Cuadrado && !tf_1.getText().isEmpty()) {
                    ((Cuadrado) figuras.get(pos)).cambiarTamano(Integer.parseInt(tf_1.getText()));
                    tf_2.setText("");
                } else if (figuras.get(pos) instanceof Triangulo && !tf_1.getText().isEmpty() && !tf_2.getText().isEmpty()) {
                    ((Triangulo) figuras.get(pos)).cambiarTamano(Integer.parseInt(tf_1.getText()), Integer.parseInt(tf_2.getText()));
                    tf_1.setText("");
                    tf_2.setText("");
                } else if (figuras.get(pos) instanceof Rectangulo && !tf_1.getText().isEmpty() && !tf_2.getText().isEmpty()) {
                    ((Rectangulo) figuras.get(pos)).cambiarTamano(Integer.parseInt(tf_1.getText()), Integer.parseInt(tf_2.getText()));
                    tf_1.setText("");
                    tf_2.setText("");
                }
            }

            figuras.get(pos).setVisible(true);
        }
        );

        guardar.addActionListener(
                (ActionEvent) -> {
                    chooser.setFileFilter(new FileNameExtensionFilter("Archivo binario dat", "dat"));
                    int opcion = chooser.showSaveDialog(this);
                    if (opcion == 0) {
                        FlujoSalidaObjeto salida = null;
                        try {
                            salida = new FlujoSalidaObjeto(new FileOutputStream(chooser.getSelectedFile()));

                            for (int i = 0; i < figuras.size(); i++) {
                                figuras.get(i).removeMouseListener(this);
                                figuras.get(i).removeMouseMotionListener(figuras.get(i));
                                salida.writeUnshared(figuras.get(i));
                                figuras.get(i).addMouseListener(this);
                                figuras.get(i).addMouseMotionListener(figuras.get(i));
                            }
                            salida.flush();
                            salida.close();
                        } catch (FileNotFoundException ex) {
                            System.out.println("Flujo FNF: " + ex.getMessage());
                        } catch (IOException ex) {
                            System.out.println("Flujo IOEx" + ex.getMessage());
                        }
                    }
                }
        );
        abrir.addActionListener((ActionEvent ActionEvent) -> {
                    chooser.setFileFilter(new FileNameExtensionFilter("Archivo binario dat", "dat"));
                    int opcion = chooser.showOpenDialog(this);

                    if (opcion == 0) {
                        FlujoEntradaObjeto entrada = null;
                        try {
                            entrada = new FlujoEntradaObjeto(new FileInputStream(chooser.getSelectedFile()));

                            while (true) {
                                Figura fig = (Figura) entrada.readUnshared();

                                fig.addMouseListener(this);
                                fig.addMouseMotionListener(fig);

                                figuras.add(fig);
                            }
                        } catch (FileNotFoundException ex) {

                        } catch (IOException ex) {
                            try {
                                if (entrada != null) {
                                    entrada.close();
                                }
                            } catch (IOException ex1) {

                            }
                            System.out.println("Termino el ciclo");
                        } catch (ClassNotFoundException ex) {

                        }

                        this.redibujarLienzo();
                    }
                }
        );

        exportar.addActionListener(
                (ActionEvent) -> {
                    chooser.setFileFilter(new FileNameExtensionFilter("Imagenes png", "png"));
                    int opcion = chooser.showSaveDialog(this);

                    if (opcion == 0) {

                        int w = lienzo.getWidth();
                        int h = lienzo.getHeight();
                        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                        Graphics2D g = bi.createGraphics();
                        lienzo.paint(g);
                        g.dispose();

                        File file = chooser.getSelectedFile();
                        try {
                            ImageIO.write(bi, "png", file);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );

        archivo.add(abrir);

        archivo.add(guardar);

        archivo.add(exportar);

        menu.add(archivo);

        this.setJMenuBar(menu);

        this.add(circulo);

        this.add(cuadrado);

        this.add(triangulo);

        this.add(rectangulo);

        this.add(dibujar);

        this.add(cambiarColor);

        this.add(cambiarTam);

        this.add(lienzo);
    }

    private void redibujarLienzo() {
        lienzo.removeAll();

        for (int i = 0; i < figuras.size(); i++) {
            lienzo.add(figuras.get(i));
        }

        lienzo.repaint();
        lienzo.revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new GeneradorFiguras().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < figuras.size(); i++) {
            if (e.getSource().equals(figuras.get(i))) {
                pos = i;
                break;
            }
        }

        if (figuras.get(pos) instanceof Circulo) {
            lbl_1.setVisible(true);
            lbl_2.setVisible(false);
            tf_1.setVisible(true);
            tf_2.setVisible(false);
            lbl_1.setText("Radio");
        } else if (figuras.get(pos) instanceof Cuadrado) {
            lbl_1.setVisible(true);
            lbl_2.setVisible(false);
            tf_1.setVisible(true);
            tf_2.setVisible(false);
            lbl_1.setText("Lado");
        } else if (figuras.get(pos) instanceof Triangulo || figuras.get(pos) instanceof Rectangulo) {
            lbl_1.setVisible(true);
            lbl_2.setVisible(true);
            tf_1.setVisible(true);
            tf_2.setVisible(true);
            lbl_1.setText("Base");
            lbl_2.setText("Altura");
        }

//        for (int i = 0; i < figuras.size(); i++) {
//            if(i==pos){
//                figuras.get(i).setBorder(true);
//            }else{
//                figuras.get(i).setBorder(false);
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < figuras.size(); i++) {
            if (e.getSource().equals(figuras.get(i))) {
                pos = i;
                break;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
