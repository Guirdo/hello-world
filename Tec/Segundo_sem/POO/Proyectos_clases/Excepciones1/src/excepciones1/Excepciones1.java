package excepciones1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class Excepciones1 {

    static int arreglo[];

    public static void main(String[] args) {
        int numEle = 0, num;
        String respuesta;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el numero de elementos a ingresar en el arreglo: ");
            num = sc.nextInt();

            verificar(numEle);
            
            arreglo= new int[numEle];
            
            for(int i=0;i<arreglo.length;i++){
                
                try{
                    
                }catch()
                
                System.out.print("Ingrese el valor del elemento #"+(i+1)+": ");
                num = sc.nextInt();
                verificarElemento(num);
            }
        } catch (ExcepcionNum e) {
            respuesta = e.getMessage();
        } catch(InputMismatchException e){
            respuesta = e.getMessage();
        }
    }

    static void verificar(int numEle) throws ExcepcionNum, InputMismatchException {
        if (numEle <= 0) {
            throw new ExcepcionNum("Error, el numero de elementos debe ser mayor a cero...");
        }
    }
    
    static void verificarElemento(int num) throws ExcepcionNum, InputMismatchException {
        if (num <= 0) {
            throw new ExcepcionNum("Error, el numero debe ser mayor a cero...");
        }
    }
}

class ExcepcionNum extends Exception {

    public ExcepcionNum(String msg) {
        super(msg);
    }

}
