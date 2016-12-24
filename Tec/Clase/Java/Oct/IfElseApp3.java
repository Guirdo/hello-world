import javax.swing.*;

public class IfElseApp3{
  public static void main(String[] args) {
    String sexo;
    int edad;

    try {
      Object obSexo = JOptionPane.showInputDialog(null,"Sexo: ","Entrada de datos...",JOptionPane.QUESTION_MESSAGE,null,new Object[]{"Femenino","Masculino"},"Femenino");
      sexo = obSexo.toString();
      edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Edad: ","Entrada de datos...",JOptionPane.INFORMATION_MESSAGE));

      if (edad > 0 && edad <= 120) {
        if (edad >= 1 && edad <=12) {
          if (sexo == "Masculino") {
            JOptionPane.showMessageDialog(null,"Eres un niño menor de edad.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }else{
            JOptionPane.showMessageDialog(null,"Eres una niña menor de edad.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }
        }else if (edad >=13 && edad <= 17) {
          if (sexo == "Masculino") {
            JOptionPane.showMessageDialog(null,"Eres un adolescente menor de edad.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }else{
            JOptionPane.showMessageDialog(null,"Eres una adolescente menor de edad.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }
        }else if (edad >=18 && edad <= 30) {
          if (sexo == "Masculino") {
            JOptionPane.showMessageDialog(null,"Eres un joven adulto.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }else{
            JOptionPane.showMessageDialog(null,"Eres una joven adulta.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }
        }else if (edad >=31 && edad <= 65) {
          if (sexo == "Masculino") {
            JOptionPane.showMessageDialog(null,"Eres un hombre adulto.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }else{
            JOptionPane.showMessageDialog(null,"Eres una mujer adulta.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }
        }else{
          if (sexo == "Masculino") {
            JOptionPane.showMessageDialog(null,"Eres un adulto mayor.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }else{
            JOptionPane.showMessageDialog(null,"Eres una adulta mayor.","Salida de datos...",JOptionPane.INFORMATION_MESSAGE);
          }
        }//If
      }else {
          JOptionPane.showMessageDialog(null,"Error la edad debe estar en el rango de 1 a 120 años","Error de entrada...",JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Error...","Error...",JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    System.exit(0);
  }
}
