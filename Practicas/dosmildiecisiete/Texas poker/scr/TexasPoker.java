import java.util.Scanner;

public class TexasPoker{

  public static void main(String[] args){
   Baraja baraja = new Baraja();
   Carta[] manoUsuario = new Carta[2];
   Carta[] manoPC = new Carta[2];
   Carta[] mesa = new Carta[5];
   char continuar,retirada = 'n';
   int cont=0;

   Scanner sc = new Scanner(System.in);

   System.out.print("Desea jugar? s o n: ");
   continuar = sc.next().charAt(0);

   if(continuar == 's'){
    System.out.println("Vamos a jugar");
    baraja.barajear();

    //Reparte las cartas
    for(int i=0;i<2;i++){
      manoUsuario[i]=baraja.darCarta();
      manoPC[i]=baraja.darCarta();
    }

    //Mano del usuario
    for(int i=0;i<2;i++){
     System.out.println(manoUsuario[i].imprimir());
    }

    //Mano PC
    for(int i=0;i<2;i++){
     System.out.println(manoPC[i].imprimir());
    }

    for(int i=0;i<5;i++){
      mesa[i]= baraja.darCarta();
    }

    while(retirada == 'n'){
      String flow = "";
      if(cont == 0){
        for(int i=0;i<3;i++){
          flow += mesa[i].imprimir()+"  ";
        }

        //Imprime las cartas
        System.out.println(flow);
        System.out.println("Desea retirarse? s o n: ");
        retirada = sc.next().charAt(0);

      }else{
        if(cont == 1){
          for(int i=0;i<4;i++){
            flow += mesa[i].imprimir()+"  ";
          }

          System.out.println(flow);
          System.out.println("Desea retirarse? s o n: ");
          retirada = sc.next().charAt(0);
        }if(cont == 2){
          for(int i=0;i<5;i++){
            flow += mesa[i].imprimir()+"  ";
          }

          System.out.println(flow);

          retirada = 's';
        }
      }

      cont++;
    }//while de la jugada

    /*
     * TODO En esta parte ira donde se evalua quien gano y con que mano
     */

    //Devolver cartas a la baraja y completar esta
    for(int i=0;i<5;i++){
      if(i<2){
        baraja.devolverCarta(manoUsuario[i]);
        baraja.devolverCarta(manoPC[i]);
      }
      baraja.devolverCarta(mesa[i]);
    }

    System.out.println("El juego ha terminado");

   }else{
     System.exit(0);
   }

  }

}
