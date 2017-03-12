import java.util.Scanner;

public class MeMaEdad {
	public static void main(String[] args){

		int ano,mes,mesAct = 8, anoAct = 2016;
		Scanner sc = new Scanner(System.in);

		try{
			//Entrada de datos
			System.out.print("Ingresa año: ");
			ano = sc.nextInt();

			if(anoAct - ano >= 18){

				if(anoAct - ano == 18){
					System.out.print("Ingresa mes: ");
					mes = sc.nextInt();

					if(mes <= mesAct){
						System.out.print("Mayor de edad.");
					}
					else{
						System.out.println("Menor de edad.");
					}
				}
				if(anoAct - ano > 18){
					System.out.print("Mayor de edad.");
				}
			}
			else{
				System.out.println("Menor de edad.");
			}
		}
		catch(Exception e){
			System.out.println("Error...");
		}
		System.exit(0);
	}

}
