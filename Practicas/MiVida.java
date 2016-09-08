  import java.util.*;

  public class MiVida{
    public static void main(String[] args) {

      //Declarando las variables
      String persona = "Yo",felicidad = "Soy feliz";
      int dias=1,anios=1,esperanzaDeVida,diasTotales,diasVivo=1;
      boolean muerte=false;
      Scanner sc = new Scanner(System.in);
      Random muerteAccidental = new Random();

      //Entrada de datos
      try {
        System.out.print("¿Cuantos años piensas vivir?: ");
        esperanzaDeVida = sc.nextInt();

        diasTotales = 365 * esperanzaDeVida;
        int diaMuerte = (int) Math.floor(muerteAccidental.nextDouble()*(diasTotales-0+1)-0);

        do {
          dias=1;
          do {
            System.out.println("Dia "+dias+" del año #"+anios);
            System.out.println("-"+persona+" como sopa.");
            System.out.println("-"+persona+" trabajo 8 horas al día");
            System.out.println("-"+persona+" duermo 6 horas al día");
            System.out.println("-"+persona+" soy feliz\n");

            dias++;
            diasVivo++;

            if (diasVivo==diaMuerte) {
              muerte=true;
              break;
            }
          } while (dias<=365);

          anios++;

          if (muerte==true) {
            break;
          }
        } while (anios <= esperanzaDeVida);

        if (muerte==true) {
          System.out.println("He muerto porque un borracho se habia quedado dormido al volante...");
        }
        else if (muerte==false) {
          System.out.println("Aun me queda tiempo por vivir...");
        }

      }
      catch (Exception e) {
        System.out.println("No seas idiota, introduce bien los datos...");
      }
    }

  }
