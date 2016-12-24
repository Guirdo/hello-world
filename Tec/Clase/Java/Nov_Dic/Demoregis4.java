import javax.swing.JOptionPane;

//creacion y definicion de la clase empleado
    class Usuario{
    	public String tUsuario, nombre;
    	public int consumo, gasto, gasto1, gasto2, gasto3;
    	public double pago, cuotaMinima, costoExc, toPago, toPago1, toPago2, toPago3, totalCobro;
    }//clasUsuario

public class Demoregis4 {
    public static void main(String[] args) {
    	//Declaracion de variable.
    	int nObjUsu, consu=0, gastoTotalAguaAgr = 0, gastoTotalAguaCom = 0, gastoTotalAguaDom = 0, gastoTotalAguaInd = 0;
        String tipoUsuario, nomUsu, datos = "";
        double cuotaMin=0, totalPago=0, costoAguaExc = 0, cobroTotalInd = 0, cobroTotalArg = 0, cobroTotalCom = 0, cobroTotalDom = 0, totalCob = 0;
    	try{
    		nObjUsu=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el n�mero de Usuarios a registrar", "Entrada de datos...", JOptionPane.INFORMATION_MESSAGE));
        if(nObjUsu > 0){ //Validaci�n de la cantidad de empleados.
        	//Declaracion de arreglos en objeto de tipo usuario.
    			Usuario[] arrayUsuario = new Usuario[nObjUsu];
    			for(int i = 0; i < nObjUsu; i++)
    				arrayUsuario[i] = new Usuario();
    		  //Lectura de los datos al arreglo arrayUsuario.
    		  for(int i = 0; i < nObjUsu; i++){
    		      do{ //Validacion del nombre y asignacion de arreglo.
    		          //lectura de nombre.
    		          nomUsu = JOptionPane.showInputDialog(null, "Nombre: ", "Entrada de datos...", JOptionPane.INFORMATION_MESSAGE);
    			        if(!nomUsu.isEmpty())
    				        arrayUsuario[i].nombre = nomUsu;
    			        else
    				        JOptionPane.showMessageDialog(null, "Error el nombre del estudiante esta vacio...", "Mensaje de error...", JOptionPane.ERROR_MESSAGE);
			        }while(nomUsu.isEmpty());
			        //lectura del tipo de usuario
			        do{
    		          Object usuario = JOptionPane.showInputDialog(null, "Tipo de usuario", "Entrada de datos...", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Agricola", "Comercial", "Domestico", "Industrial"}, "Agricola");
       		        tipoUsuario = usuario.toString();
       			      if(!tipoUsuario.isEmpty())
       		           arrayUsuario[i].tUsuario = tipoUsuario;
			        }while(tipoUsuario.isEmpty());
			        //Luectura del cunsumo.
			        do{//Validacion en el consumo de agua
       		         consu = Integer.parseInt(JOptionPane.showInputDialog(null, "Consumo de agua", "Entrada de datos...", JOptionPane.INFORMATION_MESSAGE));
       		         arrayUsuario[i].consumo = consu;
       			       if(consu <=0)
       				        JOptionPane.showMessageDialog(null, "Error el consumo de agua debe ser mayor o igual a cero", "Mensaje de error...", JOptionPane.ERROR_MESSAGE);
       		    }while(consu <= 0);

       		     //Realizaci�n de c�lculos en base al tipo de usuario
       		      if(arrayUsuario[i].tUsuario == "Agricola"){
       				      gastoTotalAguaAgr += consu;
       				      arrayUsuario[i].gasto += gastoTotalAguaAgr;
       			        if(consu > 0 && consu <= 5000){
       				          cuotaMin = 68.00;
                        arrayUsuario[i].cuotaMinima += cuotaMin;
       				          costoAguaExc = 0;
       				          arrayUsuario[i].costoExc += costoAguaExc;
       			        }
       			        if(consu > 5000 && consu <= 20000){
       				          cuotaMin = 68.00;
       				          arrayUsuario[i].cuotaMinima += cuotaMin;
       				          costoAguaExc = (consu -5000)*0.18;
       				          arrayUsuario[i].costoExc += costoAguaExc;
       			        }
       			        if(consu > 20000){
       				          cuotaMin = 68.00;
       			            arrayUsuario[i].cuotaMinima += cuotaMin;
       				          costoAguaExc = ((consu - 5000)*0.18) + ((consu - 20000)*0.36);
       				          arrayUsuario[i].costoExc += costoAguaExc;
       			        }
       				  //calculo del pago total del usuario
       				  totalPago = 0.0;
       				  //totalizacion del cobro total por usuario
       				  cobroTotalArg = totalPago;
       				  arrayUsuario[i].toPago += cobroTotalArg;
       				  totalPago = cuotaMin + costoAguaExc;
       				  arrayUsuario[i].pago += totalPago;
       		    }//ifagricola

       		if(arrayUsuario[i].tUsuario == "Comercial"){
       			gastoTotalAguaCom += consu;
       			arrayUsuario[i].gasto1 += gastoTotalAguaCom;
       			if(consu > 0 && consu <= 5000){
   					cuotaMin = 375.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       			}
       			if(consu > 5000 && consu <= 20000){
       			 	cuotaMin = 375.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       				costoAguaExc = (consu -5000)*0.95;
       				arrayUsuario[i].costoExc += costoAguaExc;
       			}
       		    if(consu > 20000){
       		     	cuotaMin = 375.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       				costoAguaExc = ((consu - 5000)*0.95) + ((consu - 20000)*1.90);
       				arrayUsuario[i].costoExc += costoAguaExc;
       		    }
       				//calculo del pago total del usuario
       				totalPago = 0.0;
       				//totalizacion del cobro total por usuario
       				cobroTotalCom = totalPago;
       				arrayUsuario[i].toPago1 += cobroTotalCom;
       				totalPago = cuotaMin + costoAguaExc;
       				arrayUsuario[i].pago += totalPago;
       		}//ifcomercial
       		if(arrayUsuario[i].tUsuario == "Domestico"){
       			gastoTotalAguaDom += consu;
       			arrayUsuario[i].gasto2 += gastoTotalAguaDom;
       			if(consu > 0 && consu <= 5000){
       				cuotaMin = 150.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       			}
       			if(consu > 5000 && consu <= 20000){
       			 	cuotaMin = 150.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       				costoAguaExc = (consu -5000)*0.44;
       				arrayUsuario[i].costoExc += costoAguaExc;
       			}
       		    if(consu > 20000){
       		     	cuotaMin = 150.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       				costoAguaExc = ((consu - 5000)*0.44) + ((consu - 20000)*0.88);
       				arrayUsuario[i].costoExc += costoAguaExc;
       		    }
       				//calculo del pago total del usuario
       				totalPago = 0.0;
       				//totalizacion del cobro total por usuario
       				cobroTotalDom = totalPago;
       				arrayUsuario[i].toPago2 += cobroTotalDom;
       				totalPago = cuotaMin + costoAguaExc;
       				arrayUsuario[i].pago +=totalPago;
       		}//ifDomestico
       		if(arrayUsuario[i].tUsuario == "Industrial"){
       			 	gastoTotalAguaInd += consu;
       				arrayUsuario[i].gasto3 += gastoTotalAguaInd;
       			if(consu > 0 && consu <= 5000){
       				cuotaMin = 825.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       			}
       			if(consu > 5000 && consu <= 20000){
       				cuotaMin = 825.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       				costoAguaExc = (consu -5000)*1.75;
       				arrayUsuario[i].costoExc += costoAguaExc;
       			}
       		    if(consu > 20000){
       		    	cuotaMin = 825.00;
       				arrayUsuario[i].cuotaMinima += cuotaMin;
       				costoAguaExc = ((consu - 5000)*1.75) + ((consu - 20000)*3.50);
       		   		arrayUsuario[i].costoExc += costoAguaExc;
       		    }
       				//calculo del pago total del usuario
       				totalPago = 0.0;
       				//totalizacion del cobro total por usuario
       				cobroTotalInd = totalPago;
       				arrayUsuario[i].toPago3 += cobroTotalInd;
       				totalPago = cuotaMin + costoAguaExc;
       				arrayUsuario[i].pago +=totalPago;
       		}//ifind
       		}//Finaliza capturar el dato.
       		//salida de resultados de usuarios que efectuara el usuario
       		for(int i = 0; i < nObjUsu; i++)
       		 datos += "Nombre del usuario: " + arrayUsuario[i].nombre + "\nTipo de usuario " + arrayUsuario[i].tUsuario + "\n Consumo de agua: " + arrayUsuario[i].consumo + "\n Cuota minima: $" + arrayUsuario[i].cuotaMinima + "\n costo excedente: $" + arrayUsuario[i].costoExc + "\n Total a pagar: $" + arrayUsuario[i].pago + "\n--------------------------------------------\n";
        	JOptionPane.showMessageDialog(null, datos, "Salida de datos...", JOptionPane.INFORMATION_MESSAGE);

        //calculo de datos a pagar
        for(int i = 0; i < nObjUsu; i++){
          totalCob = arrayUsuario[i].toPago + arrayUsuario[i].toPago1 + arrayUsuario[i].toPago2 + arrayUsuario[i].toPago3;
          arrayUsuario[i].totalCobro += totalCob;
        }

        //salida de datos
        datos = "Gasto total de agua por usuarios: "  + "\n - Agricola: " + gastoTotalAguaAgr + "\n - Comercial: " + gastoTotalAguaCom + " \n - Domestico: " + gastoTotalAguaDom + "\n - Industrial: "+ gastoTotalAguaInd + "\n Cobro total por usuario: " + "\n - Agricola: " + cobroTotalArg + "\n - Comercial: " + cobroTotalCom + "\n - Domestico: " + cobroTotalDom + "\n - Industrial: " + cobroTotalInd + "\n Total cobrado: ";
        JOptionPane.showMessageDialog(null, datos, "Salida de datos...", JOptionPane.INFORMATION_MESSAGE);
      }
    		else
   			  JOptionPane.showMessageDialog(null, " Error el n�mero de Usuarios debe ser mayor a cero", "Mensaje de error...", JOptionPane.ERROR_MESSAGE);
        }//try
        catch(Exception e){
        	JOptionPane.showMessageDialog(null, "Error, dato no valido, debe ser n�merico...", "Mensaje de error...", JOptionPane.ERROR_MESSAGE);
        }//chath
        System.exit(0);
    }
}
