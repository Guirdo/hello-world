package principal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LogIn extends JDialog{
    
    private String direccionIP,nickName;
    
    public LogIn(){
        this.setTitle("Inicia sesión");
        this.setSize(195, 195);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        //Direcion IP
        JLabel lbl_1 = new JLabel("Dirección IP:");
        lbl_1.setBounds(15, 10, 90 , 20);
        JTextField jtfIP = new JTextField();
        jtfIP.setBounds(15, 31, 150, 20);
        
        //Nombre de usuario
        JLabel lbl_2 = new JLabel("Nombre de usuario: ");
        lbl_2.setBounds(15, 60, 120 , 20);
        JTextField jtfNickName = new JTextField();
        jtfNickName.setBounds(15, 85, 150, 20);
        
        JButton conectar = new JButton("Conectar");
        conectar.setBounds(75, 120, 90, 25);
        conectar.addActionListener((ActionEvent)->{
            direccionIP=jtfIP.getText();
            nickName = jtfNickName.getText();
            this.dispose();
        });
        
        add(lbl_1);
        add(jtfIP);
        add(lbl_2);
        add(jtfNickName);
        add(conectar);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public String getNickName() {
        return nickName;
    }
    
    
}
