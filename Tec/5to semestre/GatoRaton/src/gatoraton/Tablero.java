package gatoraton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero extends JFrame {

    //Atributos
    private Boton[][] listaBotones;
    private JPanel pnlMesa, pnlOpciones;
    private boolean gato;
    private int clicks;

    public Tablero() {
        this.setTitle("Gato y al raton");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gato = false;
        clicks = 0;

        pnlMesa = new JPanel();
        pnlMesa.setBounds(0, 0, 350, 400);
        pnlMesa.setLayout(null);
        crearJuego();

        pnlOpciones = new JPanel();
        pnlOpciones.setBounds(350, 0, 150, 400);

        add(pnlMesa);
    }

    public void crearJuego() {
        listaBotones = new Boton[3][3];
        Boton b;
        int x = 25;
        int y = 25;

        // TODO arreglar para un arreglo bidimensional
        for (int i = 0; i < 3; i++) {
            final int FINALI = i;
            for (int j = 0; j < 3; j++) {
                b = new Boton();
                b.setBounds(x, y, 100, 100);
                
                final int FINALJ = j;
                b.addActionListener((ActionEvent) -> {
                    if (!listaBotones[FINALI][FINALJ].getEsClickeado()) {
                        listaBotones[FINALI][FINALJ].setEsClickeado(true);

                        listaBotones[FINALI][FINALJ].setAnimal(gato);
                        gato = !gato;

                        clicks++;
                        if (clicks >= 4) {
                            victoria();
                        }
                    }

                });

                listaBotones[i][j] = b;
                pnlMesa.add(listaBotones[i][j]);

                x += 100;
                if (x == 325) {
                    x = 25;
                    y += 100;
                }
            }
        }

    }

    public void victoria() {
        //Por renglon
        for(int i=0;i<3;i++){
            if(listaBotones[i][0].getAnimal().equals(ABORT)){
                if(listaBotones[i][2].getAnimal() == listaBotones[i][0].getAnimal()){
                    JOptionPane.showMessageDialog(null,"Has ganado");
                }
                break;
            }
        }
    }
}
