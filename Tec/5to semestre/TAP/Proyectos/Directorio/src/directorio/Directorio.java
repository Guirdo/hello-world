/*
 * Hola!
 */
package directorio;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Directorio extends JFrame implements WindowListener {

    //Atributos
    private JPanel pnlAgregar;
    private static volatile ArrayList<Persona> listaPersona;
    private AutoGuardado autoG;
    private JTable tabla;
    private JScrollPane sclTabla;
    private JButton agregar, eliminar;
    private JMenuBar menu;
    public static JLabel mensaje;
    private Object[][] matriz;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private final File ORIGINAL = new File("src\\datos.dat");
    private final File TEMPORAL = new File("src\\datostmp.dat");
    private final String[] ENCABEZADOS = {"Nombre", "Edad"};
    private boolean guardado;
    private Timer tempo;

    public Directorio() {
        //Set's básicos de la ventana
        setTitle("Directorio");
        setSize(470, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.addWindowListener(this);

        listaPersona = new ArrayList<>();
        guardado = true;
        autoG = new AutoGuardado();
        autoG.start();

        //Panel de agregar
        pnlAgregar = new JPanel();
        pnlAgregar.setBounds(20, 10, 415, 180);
        pnlAgregar.setLayout(null);
        pnlAgregar.setBorder(BorderFactory.createTitledBorder("Agregar datos"));
        this.crearAgregar();

        try {
            if (ORIGINAL.exists()) {
                entrada = new DataInputStream(new FileInputStream(ORIGINAL));
                while (true) {
                    String nom = entrada.readUTF();
                    int edad = (int) entrada.readInt();
                    listaPersona.add(new Persona(nom, edad));
                }
            }
        } catch (IOException e) {

        }

        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ex) {

        }

        if (listaPersona.size() == 0) {
            matriz = new Object[0][0];
        } else {
            crearMatriz();
        }

        //Tabla
        tabla = new JTable(new DefaultTableModel(matriz, ENCABEZADOS));
        sclTabla = new JScrollPane(tabla);
        sclTabla.setBounds(20, 205, 300, 200);

        //Boton eliminar
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(345, 280, 80, 25);
        eliminar.addActionListener((ActionEvent) -> {
            if (listaPersona.size() != 0) {
                listaPersona.remove(tabla.getSelectedRow());
                crearMatriz();
                tabla.setModel(new DefaultTableModel(matriz, ENCABEZADOS));
                guardado = false;
                AutoGuardado.detener = false;
            }
        });

        //Label de autoguardado
        mensaje = new JLabel("¡Bienvenido!");
        mensaje.setBounds(20, 415, 200, 25);
        mensaje.setFont(new Font("Arial", 2, 12));

        tempo = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje.setText("");
            }
        });
        tempo.setRepeats(false);

        //JMenuBar
        menu = new JMenuBar();
        crearMenu();

        //Agregar objetos a la ventana
        add(pnlAgregar);
        add(sclTabla);
        add(eliminar);
        add(mensaje);
        this.setJMenuBar(menu);
    }

    public void recuperacion() {
        /**
         * Si el archo temporal existe (ya sea porque el programa se cerro
         * inesperadamente), preguntara si desea remplazar el archivo original y
         * correctamente guardado por el archivo temporal del autoguardado.
         */
        if (TEMPORAL.exists()) {
            String fecha = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader("src\\datosRecuperacion.txt"));
                fecha = br.readLine();
            } catch (FileNotFoundException e) {

            } catch (IOException ex) {

            }

            new Recuperacion(fecha).setVisible(true);
            if (Recuperacion.remplazar) {
                listaPersona = new ArrayList<>();
                try {
                    entrada = new DataInputStream(new FileInputStream(TEMPORAL));
                    while (true) {
                        String nom = entrada.readUTF();
                        int edad = (int) entrada.readInt();
                        listaPersona.add(new Persona(nom, edad));
                    }

                } catch (IOException e) {

                }

                try {
                    if (entrada != null) {
                        entrada.close();
                    }
                } catch (IOException ex) {

                }

                crearMatriz();
                tabla.setModel(new DefaultTableModel(matriz, ENCABEZADOS));
                TEMPORAL.delete();
            } else {
                TEMPORAL.delete();
            }
        }
    }

    public void crearMenu() {
        //Archivo
        JMenu archivo = new JMenu("Archivo");
        JMenuItem guardar = new JMenuItem("Guardar");
        guardar.addActionListener((ActionEvent) -> {
            try {
                salida = new DataOutputStream(new FileOutputStream("src\\datos.dat"));
                for (int i = 0; i < listaPersona.size(); i++) {
                    salida.writeUTF(listaPersona.get(i).getNombre());
                    salida.writeInt(listaPersona.get(i).getEdad());
                }
                salida.close();
                guardado = true;
                AutoGuardado.detener = true;
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
            mensaje.setText("Guardado");
            tempo.start();
        });
        guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        
        //Configuracion
        JMenuItem cfg = new JMenuItem("Configuración");
        cfg.addActionListener((ActionEvent) -> {
            new Configuracion().setVisible(true);
        });
        cfg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));

        //Salir
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener((ActionEvent) -> {
            cerrandoVentana();
        });
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));

        archivo.add(guardar);
        archivo.add(cfg);
        archivo.add(new JSeparator());
        archivo.add(salir);
        menu.add(archivo);
    }

    public void crearMatriz() {
        matriz = new Object[listaPersona.size()][2];

        for (int i = 0; i < listaPersona.size(); i++) {
            matriz[i][0] = listaPersona.get(i).getNombre();
            matriz[i][1] = listaPersona.get(i).getEdad();
        }
    }

    public void crearAgregar() {
        //Label nombre
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30, 35, 60, 20);
        lblNombre.setFont(new Font("Arial", 0, 12));

        //TextFiel nombre
        JTextField nombre = new JTextField();
        nombre.setBounds(30, 55, 150, 25);

        //Label edad
        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setBounds(30, 90, 60, 20);
        lblEdad.setFont(new Font("Arial", 0, 12));

        //TextFiel edad
        JTextField edad = new JTextField();
        edad.setBounds(30, 110, 150, 25);

        //Boton agregar
        agregar = new JButton("Agregar");
        agregar.setBounds(300, 75, 100, 25);
        agregar.setFont(new Font("Arial", 1, 13));
        agregar.addActionListener((ActionEvent) -> {

            if (!nombre.getText().isEmpty() && !edad.getText().isEmpty()) {
                listaPersona.add(new Persona(nombre.getText(), Integer.parseInt(edad.getText())));
                crearMatriz();
                tabla.setModel(new DefaultTableModel(matriz, ENCABEZADOS));

                guardado = false;
                AutoGuardado.detener = false;
                nombre.setText("");
                edad.setText("");
            }

        });

        //Agregar al panel
        pnlAgregar.add(agregar);
        pnlAgregar.add(nombre);
        pnlAgregar.add(lblNombre);
        pnlAgregar.add(edad);
        pnlAgregar.add(lblEdad);
    }

    public static ArrayList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void cerrandoVentana() {
        if (!guardado) {
            AutoGuardado.detener = true;
            new Cerrando().setVisible(true);
            AutoGuardado.detener = false;
        } else {
            TEMPORAL.delete();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Directorio dic = new Directorio();
        dic.setVisible(true);
        dic.recuperacion();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        cerrandoVentana();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
