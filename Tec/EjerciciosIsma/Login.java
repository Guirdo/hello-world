import javax.swing.*;

public class Login{
  public static void main(String[] args) {
    JPasswordField jpf = new JPasswordField();
    String usuario=JOptionPane.showInputDialog(null,"Usuario","Entrada",JOptionPane.QUESTION_MESSAGE);
    JOptionPane.showConfirmDialog(null,new Object[]{"Contraseña",jpf},"Login",JOptionPane.OK_CANCEL_OPTION);

    char p[] = jpf.getPassword();
    String pass = new String(p);

    JOptionPane.showMessageDialog(null,usuario+"\n"+pass,"Salida",JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }
}
