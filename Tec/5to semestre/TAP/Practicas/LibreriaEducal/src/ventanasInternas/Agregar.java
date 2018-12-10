package ventanasInternas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class Agregar extends VentanaInterna {

    public Agregar() {
        super("Agregar");
        this.setLocation(120, 120);
        this.setLayout(new GridBagLayout());

        GridBagConstraints gb = new GridBagConstraints();
        gb.fill = GridBagConstraints.HORIZONTAL;

        JLabel subTituloLibro = new JLabel("Libro");
        subTituloLibro.setFont(new Font("Arial", 1, 20));
        gb.gridx = 3;
        gb.gridy = 0;
        this.add(subTituloLibro, gb);

        JLabel txtTitulo = new JLabel("Titulo: ");
        gb.gridx = 1;
        gb.gridy = 1;
        this.add(txtTitulo, gb);
        JTextArea titulo = new JTextArea(2, 15);
        titulo.setBorder(null);
        titulo.setWrapStyleWord(true);
        titulo.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(titulo);
        gb.gridx = 2;
        gb.gridy = 1;
        this.add(scroll, gb);

        JLabel txtAutor = new JLabel("Autor: ");
        gb.gridx = 1;
        gb.gridy = 2;
        this.add(txtAutor, gb);
        JTextArea txtAutor1 = new JTextArea(1, 15);
        txtAutor1.setBorder(null);
        txtAutor1.setBounds(75, 80, 125, 20);
        gb.gridx = 2;
        gb.gridy = 2;
        this.add(txtAutor1, gb);

        JLabel txtEditorial = new JLabel("Editorial: ");
        gb.gridx = 1;
        gb.gridy = 3;
        this.add(txtEditorial, gb);
        JTextArea editorial = new JTextArea(1, 15);
        editorial.setBorder(null);
        editorial.setBounds(95, 435, 240, 20);
        gb.gridx = 2;
        gb.gridy = 3;
        this.add(editorial, gb);

        JLabel txtPrecio = new JLabel("Precio: $");
        gb.gridx = 4;
        gb.gridy = 1;
        this.add(txtPrecio, gb);
        JTextArea precio = new JTextArea();
        gb.gridx = 5;
        gb.gridy = 1;
        this.add(precio, gb);

        JLabel txtCantidad = new JLabel("Cantidad:");
        gb.gridx = 4;
        gb.gridy = 2;
        this.add(txtCantidad, gb);
        JSpinner cantidad = new JSpinner();
        cantidad.setModel(new SpinnerNumberModel(3, 3, 100, 1));
        gb.gridx = 5;
        gb.gridy = 2;
        this.add(cantidad, gb);

        JButton nuevoAutor = new JButton("Nuevo Autor");
        gb.gridx = 4;
        gb.gridy = 3;
        this.add(nuevoAutor, gb);
        JButton nuevoEditor = new JButton("Nuevo Editor");
        gb.gridx = 5;
        gb.gridy = 3;
        this.add(nuevoEditor, gb);

        JLabel txtSipnosis = new JLabel("Sipnosis: ");
        gb.gridx = 1;
        gb.gridy = 4;
        this.add(txtSipnosis, gb);
        JTextArea sipnosis = new JTextArea(5,30);
        sipnosis.setBorder(null);
        sipnosis.setWrapStyleWord(true);
        sipnosis.setLineWrap(true);
        gb.gridx = 2;
        gb.gridy = 4;
        gb.gridheight=2;
        gb.gridwidth=3;
        this.add(sipnosis,gb);
        
        JButton agregar = new JButton("Agregar");
        gb.gridx = 2;
        gb.gridy = 6;
        gb.gridheight=1;
        gb.gridwidth=3;
        this.add(agregar,gb);
        this.pack();
    }
}
