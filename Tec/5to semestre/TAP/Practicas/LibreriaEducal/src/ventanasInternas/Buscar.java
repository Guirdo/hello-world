package ventanasInternas;

import assets.Tabla;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Buscar extends VentanaInterna {

    public Buscar() {
        super("Buscar");
        this.setLocation(10, 10);

        //Panel 1 -----------------------------------------------------------------(Inicio)
        JPanel panel_1 = new JPanel();
        FlowLayout layoutPanel_1 = new FlowLayout(FlowLayout.LEFT);
        panel_1.setLayout(layoutPanel_1);
        layoutPanel_1.setHgap(10);
        layoutPanel_1.setVgap(10);

        JLabel txt1 = new JLabel("Busca por:");
        JComboBox opciones = new JComboBox(new String[]{"Titulo", "Autor", "Editorial"});
        JTextField busqueda = new JTextField(15);
        JButton buscar = new JButton("Buscar");
        JTextArea separador = new JTextArea(1,11);
        separador.setBackground(this.getBackground());
        separador.setEditable(false);
        separador.setBorder(null);
        JButton modificar = new JButton("Modificar elemento");

        panel_1.add(txt1);
        panel_1.add(opciones);
        panel_1.add(busqueda);
        panel_1.add(buscar);
        panel_1.add(separador);
        panel_1.add(modificar);
        //Panel 1 -----------------------------------------------------------------(Fin)

        //Panel 2 -----------------------------------------------------------------(Inico)
        JPanel panel_2 = new JPanel();
        GridLayout layoutPanel_2 = new GridLayout();
        panel_2.setLayout(layoutPanel_2);

        Tabla t = new Tabla();
        JScrollPane scroll = new JScrollPane(t);
        panel_2.add(scroll);  
        //Panel 2 -----------------------------------------------------------------(Fin)
        
        //Panel 3-----------------------------------------------------------------(Inicio)
        JPanel panel_3 = new JPanel();
        GridBagConstraints gb1 = new GridBagConstraints();
        panel_3.setLayout(new GridBagLayout());

        JLabel informacion = new JLabel("Información");
        informacion.setFont(new Font("Arial", 1, 20));
        informacion.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gb1.fill = GridBagConstraints.HORIZONTAL;
        gb1.weightx=1.0;
        gb1.gridx = 2;
        gb1.gridy = 0;
        gb1.gridwidth = 1;
        gb1.gridheight = 1;
        panel_3.add(informacion, gb1);

        JLabel txtTitulo = new JLabel("Titulo: ");
        gb1.gridx = 0;
        gb1.gridy = 1;
        gb1.gridwidth = 1;
        panel_3.add(txtTitulo, gb1);
        JTextArea titulo = new JTextArea(3, 20);
        titulo.setBorder(null);
        titulo.setBackground(this.getBackground());
        titulo.setWrapStyleWord(true);
        titulo.setLineWrap(true);
        titulo.setEditable(false);
        gb1.gridx = 1;
        gb1.gridy = 1;
        panel_3.add(titulo, gb1);

        JLabel txtAutor = new JLabel("Autor: ");
        gb1.gridx = 0;
        gb1.gridy = 2;
        panel_3.add(txtAutor, gb1);
        JTextArea autor = new JTextArea(1, 20);
        autor.setBorder(null);
        autor.setBackground(this.getBackground());
        autor.setEditable(false);
        gb1.gridx = 1;
        gb1.gridy = 2;
        panel_3.add(autor, gb1);

        JLabel txtEditorial = new JLabel("Editorial: ");
        gb1.gridx = 0;
        gb1.gridy = 3;
        panel_3.add(txtEditorial, gb1);
        JTextArea editorial = new JTextArea(1, 20);
        editorial.setBorder(null);
        editorial.setBackground(this.getBackground());
        editorial.setEditable(false);
        gb1.gridx = 1;
        gb1.gridy = 3;
        panel_3.add(editorial, gb1);

        JLabel txtSipnosis = new JLabel("Sipnosis: ");
        gb1.gridx = 3;
        gb1.gridy = 1;
        gb1.gridwidth = 1;
        gb1.gridheight = 2;
        panel_3.add(txtSipnosis, gb1);
        JTextArea sipnosis = new JTextArea(10, 20);
        sipnosis.setBorder(null);
        sipnosis.setBackground(this.getBackground());
        sipnosis.setWrapStyleWord(true);
        sipnosis.setLineWrap(true);
        sipnosis.setEditable(false);
        gb1.gridx = 4;
        gb1.gridy = 1;
        gb1.gridwidth = 1;
        gb1.gridheight = 2;
        panel_3.add(sipnosis, gb1);
        //Panel  3-----------------------------------------------------------------(Fin)

        this.add(panel_1, BorderLayout.NORTH);
        this.add(panel_2, BorderLayout.CENTER);
        this.add(panel_3, BorderLayout.SOUTH);
        //this.pack();
    }
}
