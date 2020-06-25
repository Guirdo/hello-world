package conversionsistemas;

import java.util.Scanner;

public class ConversionSistemas {

    public static void main(String[] args) {
        String numeroOrigen;
        char sistemaOrigen,sistemaDestino;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca su numero: ");
        numeroOrigen = sc.nextLine();

        System.out.println("Sistema binario(B), octal(O), decimo(D), hexadecimal(H) ");
        System.out.println("Introduzca el sistema numerico de su numero: ");
        sistemaOrigen = sc.nextLine().toUpperCase().charAt(0);
        
        System.out.println("Sistema binario(B), octal(O), decimo(D), hexadecimal(H) ");
        System.out.println("Introduzca el sistema numerico destino: ");
        sistemaDestino = sc.nextLine().toUpperCase().charAt(0);

        switch (sistemaOrigen) {
            case 'B':

                break;
            case 'O':

                break;
            case 'D':
                convertirDecimalASistema(numeroOrigen,sistemaDestino);
                break;
            case 'H':
                
                break;

        }
    }

    private static void convertirDecimalASistema(String numero, char sistemaDestino) {
        String array[] = numero.split("[.]");
        
    }

}
