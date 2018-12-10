package ventanas;

import clases.ConexionBD;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InicioSesion extends JFrame implements KeyListener {

    private String usuario, contrasena;
    private ConexionBD conexion;
    private JPasswordField contra;
    private JTextField user;

    public InicioSesion() {
        this.setTitle("LogIn");
        this.setSize(200, 215);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(layout);
        layout.setHgap(13);
        layout.setVgap(15);

        JLabel txt1 = new JLabel("Nombre de usuario:");
        JLabel txt2 = new JLabel("Contraseña:");
        contra = new JPasswordField(15);
        contra.addKeyListener(this);
        user = new JTextField(15);
        user.addKeyListener(this);

        JButton iniciar = new JButton("Iniciar");
        iniciar.addActionListener((ActionEvent) -> {
            this.iniciarSesion();
        });

        JButton cancelar = new JButton("Cancelar");
        cancelar.addActionListener((ActionEvent) -> {
            System.exit(0);
        });

        this.add(txt1);
        this.add(user);
        this.add(txt2);
        this.add(contra);
        this.add(iniciar);
        this.add(cancelar);
    }

    void iniciarSesion() {
        this.usuario = user.getText();
        this.contrasena = String.valueOf(contra.getPassword());

        try {
            conexion = new ConexionBD(usuario, contrasena);

            Educal e = new Educal(conexion);
            e.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
            user.setText("");
            contra.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == user) {
                contra.requestFocus();
            } else if (e.getSource() == contra) {
                this.iniciarSesion();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
