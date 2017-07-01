package excepapp;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class ExcepApp {

    public static void main(String[] args) {
        int num, seleccion = 0, numero = 0;
        String respuesta = null;
        String menu[] = {"Agregar", "Buscar", "Eliminar", "Modificar", "Vizualizar", "Salir"};
        NumerosEnteros numeros = new NumerosEnteros();

        do {
            seleccion = JOptionPane.showOptionDialog(null, null, "Menú principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, null);

            try {
                switch (seleccion) {
                    //Agregar
                    case 0:
                        num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero entero", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                        numeros.agregarElemento(num);
                        JOptionPane.showMessageDialog(null, "El elemento ha sido agregado", "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    //Buscar    
                    case 1:
                        if (!numeros.arregloVacio()) {
                            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero a buscar en el arreglo", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                            String resultado = numeros.buscar(numero);
                            JOptionPane.showMessageDialog(null, resultado, "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    //Eliminar    
                    case 2:
                        if (!numeros.arregloVacio()) {
                            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero a eliminar en el arreglo", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                            numeros.eliminarElemento(numero);
                            JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado", "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    //Modificar    
                    case 3:
                        if (!numeros.arregloVacio()) {
                            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero a modificar en el arreglo", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                            int numeroNuevo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo numero a modificar en el arreglo", "Entrada de datos", JOptionPane.QUESTION_MESSAGE));
                            numeros.modificarElemento(numero, numeroNuevo);
                            JOptionPane.showMessageDialog(null, "El elemento ha sido modificado", "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    //Vizualizar    
                    case 4:
                        if (!numeros.arregloVacio()) {
                            JOptionPane.showMessageDialog(null, numeros.toString(), "Elementos en el arreglo", JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Error, el tipo de dato no es valido...", "Mensaje de error", JOptionPane.QUESTION_MESSAGE);
                //System.out.println("El tipo de dato no es valido...");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, el dato introducido debe ser numerico...", "Mensaje de error", JOptionPane.QUESTION_MESSAGE);
                //System.out.println("El dato introducido debe ser numerico...");
            } catch (ExcepcionArregloVacio e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de error", JOptionPane.QUESTION_MESSAGE);
            } catch (ExcepcionNoEncontrado e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de error", JOptionPane.QUESTION_MESSAGE);
            }

        } while (seleccion != 5);

    }

}
