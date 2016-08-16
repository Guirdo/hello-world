import java.util.*;

public class JanKenPon {
  public static void main(String[] args) {

	   //Declaracion del metodo Random
	   Random rnd = new Random();
	   //Variables
	   int piedra = 0,papel = 1, tijera = 2,opcUs;
	   double opcJava = rnd.nextDouble()*(2 - 0 +1) + 0;//(Maximo - minimo + 1) - minimo: en este caso, el maximo es 2 y el minimo 0. Java escoge
	   double opcJavaRe;
	   //Declaracion de metodo Scanner
 	   Scanner sc = new Scanner(System.in);

	   //Java escoge y ahora se redondea
	   opcJavaRe = Math.floor(opcJava);

	   //Entrada de datos
	   System.out.print("Introduce un numero entre el 0 y 2: ");
	   opcUs = sc.nextInt();

	   //Aqui le decimos al usuario que opcion escogio.
	   switch (opcUs) {
	      case 0: System.out.println("Escogiste Piedra."); break;
	      case 1: System.out.println("Escogiste Papel."); break;
	      case 2: System.out.println("Escogiste Tijeras."); break;
	   }

	   //Anunciamos que escogio Java
	   if (opcJavaRe == 0) {
		   System.out.println("Java escogio Piedra.");
	   }
	   else if (opcJavaRe == 1) {
	  	 System.out.println("Java escogio Papel.");
	   }
	   else if (opcJavaRe == 2) {
		   System.out.println("Java escogio Tijeras.");
	   }

	   //Mostramos el mensaje de ganador.
	   //Java escogiendo Piedra
	   if (opcJavaRe == 0 && opcUs == 0) {
	  	 System.out.println("Empate.");
	   }
	   else if (opcJavaRe == 0 && opcUs == 1) {
		   System.out.println("Ganaste.");
	   }
	   else if (opcJavaRe == 0 && opcUs == 2) {
		   System.out.println("Perdiste.");
	   }

	   //Ahora si Java escoge Papel
	   if (opcJavaRe == 1 && opcUs == 0) {
	 	   System.out.println("Perdiste.");
	   }
	   else if (opcJavaRe == 1 && opcUs == 1) {
		   System.out.println("Empate.");
	   }
	   else if (opcJavaRe == 1 && opcUs == 2) {
		   System.out.println("Ganaste.");
	   }

	   //Java escogiendo Tijeras
	   if (opcJavaRe == 2 && opcUs == 0) {
		   System.out.println("Ganaste.");
	   }
	   else if (opcJavaRe == 2 && opcUs == 1) {
		   System.out.println("Perdiste.");
	   }
	   else if (opcJavaRe == 2 && opcUs == 2) {
		   System.out.println("Empate.");
	   }

  }
}
