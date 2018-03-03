
import java.util.*;
import javax.swing.*;

class Operaciones{

  private ArrayList <Integer> arreglo;

  public ArrayList <Integer> getArreglo(){
    return arreglo;
  }

  //Ciclo para ordenar los elementos
  private ArrayList <Integer> ordenar(ArrayList <Integer> lista){
    int aux;
    for (int i = 0; i < (lista.size()-1); i++) {
        for (int x = i + 1; x<lista.size(); x++) {
            if (lista.get(x) <lista.get(i)) {
                aux = lista.get(i);
                lista.set(i,lista.get(x));
                lista.set(x,aux);
            }
        }
    }
    return lista;
  }

  //Metodo sobrecargado (o eso creo ¡jajaja!)
  public int[] ordenar(int[] list){
    int aux;
    for (int i = 0; i < (list.length-1); i++) {
        for (int x = i + 1; x<list.length; x++) {
            if (list[x] <list[i]) {
                aux = list[i];
                list[i]=list[x];
                list[x]=aux;
            }
        }
    }
    return list;
  }

  public void union(int[] con1,int[] con2){
    int aux;
    //Creacion del arreglo dinamico
    ArrayList <Integer> lista=new ArrayList<>();

    for(int i=0;i<con1.length;i++){
      lista.add(con1[i]);
    }

    for (int i=0;i<con2.length ;i++ ) {
      lista.add(con2[i]);
    }

    lista=ordenar(lista);

    for (int i=0;i<lista.size() ;i++ ) {
      for (int j=i+1;j<lista.size() ;j++ ) {
        if (lista.get(j)==lista.get(i)) {
          lista.remove(j);
        }
      }
    }

    this.arreglo=lista;
  }

  public void inter(int[] con1, int[] con2){
    //Creacion del arreglo dinamico
    ArrayList <Integer> lista=new ArrayList<>();

    for(int i=0;i<con1.length;i++){
      for (int j=0;j<con2.length ;j++ ) {
        if (con1[i]==con2[j]) {
          lista.add(con1[i]);
        }
      }
    }

    lista=ordenar(lista);
    this.arreglo=lista;
  }

  public void comple(int[] con1, int[] con2){
    int con=0;
    //Creacion del arreglo dinamico
    ArrayList <Integer> lista=new ArrayList<>();

    for(int i=0;i<con1.length;i++){
      for (int j=0;j<con2.length ;j++ ) {
        if (con1[i]==con2[j])
          con++;
      }
      if (con==0) {
        lista.add(con1[i]);
      }
      con=0;
    }

    lista=ordenar(lista);
    this.arreglo=lista;
  }

  public void difA_B(int[] con1, int[] con2){
    int con=0;
    //Creacion del arreglo dinamico
    ArrayList <Integer> lista = new ArrayList<Integer>();
    ArrayList <Integer> nums = new ArrayList<Integer>();

    for (int i=0;i<con1.length ;i++ ){
      lista.add(con1[i]);
    }

    for (int i=0;i<lista.size() ;i++ ) {
      for (int j=0;j<con2.length ;j++ ) {
        if (lista.get(i)==con2[j]) {
          nums.add(con2[j]);
        }
      }
    }

    for (int i=0;i<nums.size() ;i++ ) {
      lista.remove(lista.indexOf(nums.get(i)));
    }

    lista=ordenar(lista);
    this.arreglo=lista;
  }

  public void difB_A(int[] con1, int[] con2){
    int con=0;
    //Creacion del arreglo dinamico
    ArrayList <Integer> lista = new ArrayList<Integer>();
    ArrayList <Integer> nums = new ArrayList<Integer>();

    for (int i=0;i<con2.length ;i++ ){
      lista.add(con1[i]);
    }

    for (int i=0;i<lista.size() ;i++ ) {
      for (int j=0;j<con1.length ;j++ ) {
        if (lista.get(i)==con1[j]) {
          nums.add(con1[j]);
        }
      }
    }

    for (int i=0;i<nums.size() ;i++ ) {
      lista.remove(lista.indexOf(nums.get(i)));
    }

    lista=ordenar(lista);
    this.arreglo=lista;
  }

  public void difSim(int[] con1, int[] con2){
    //Creacion del arreglo dinamico
    ArrayList <Integer> lista=new ArrayList<>();
    ArrayList <Integer> nums=new ArrayList<>();

    for(int i=0;i<con1.length;i++){
      lista.add(con1[i]);
    }

    for (int i=0;i<con2.length ;i++ ) {
      lista.add(con2[i]);
    }

    lista=ordenar(lista);

    for (int i=0;i<lista.size() ;i++ ) {
      for (int j=i+1;j<lista.size() ;j++ ) {
        if (lista.get(j)==lista.get(i)) {
          lista.remove(j);
        }
      }
    }

    inter(con1,con2);
    nums=getArreglo();

    for (int i=0;i<nums.size() ;i++ ) {
      lista.remove(lista.indexOf(nums.get(i)));
    }

    lista=ordenar(lista);

    this.arreglo=lista;
  }

}//Operaciones

public class Conjuntos{
  public static void main(String[] args) {
    int ent=0,num1=0,num2=0;
    boolean pasa=false;
    String ele1="",ele2="";

    //Arreglos necesarios
    String[] operaciones={"Unión","Interseccion","Complemento","Diferencia","Diferencia Simetrica"};
    Operaciones mets = new Operaciones();

    //Seleccion de operacion
    Object opcs=JOptionPane.showInputDialog(null,"Seleccione la operacion a realizar entre los dos arreglos","Seleccion",JOptionPane.QUESTION_MESSAGE,null,operaciones,null);
    String opc=opcs.toString();

    if(opc.equals("Complemento")){
      ele1="Universo";
      ele2="X";
    }else{
      ele1="X";
      ele2="Y";
    }

    do {
      try {
        num1=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de elementos del conjunto "+ele1,"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        if (num1<=0) {
          JOptionPane.showMessageDialog(null,"Error, la cantidad de datos a introducir debe mayor a 0","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
      }catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error, el dato debe ser numerico","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      }
    } while (num1<=0);
    int[] lista1= new int[num1];

    for (int i=0;i<num1 ;i++ ) {
      do {
        try {
          ent=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el elemento #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE));

          lista1[i]=ent;
          pasa=true;
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error, el dato debe ser numerico","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          pasa=false;
        }
      } while (pasa==false);
    }

    do {
      try {
        num2=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de elementos del conjunto "+ele2,"Entrada de datos",JOptionPane.QUESTION_MESSAGE));
        if (num2<=0) {
          JOptionPane.showMessageDialog(null,"Error, la cantidad de datos a introducir debe mayor a 0","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
      }catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error, el dato debe ser numerico","Mensaje de error",JOptionPane.ERROR_MESSAGE);
      }
    } while (num2<=0);
    int[] lista2= new int[num2];

    for (int i=0;i<num2 ;i++ ) {
      do {
        try {
          ent=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el elemento #"+(i+1),"Entrada de datos",JOptionPane.QUESTION_MESSAGE));

          lista2[i]=ent;
          pasa=true;
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error, el dato debe ser numerico","Mensaje de error",JOptionPane.ERROR_MESSAGE);
          pasa=false;
        }
      } while (pasa==false);
    }

    lista1=mets.ordenar(lista1);
    lista2=mets.ordenar(lista2);

    String elSal="{",el1Sal="{";
    for (int i=0;i<lista1.length ;i++ ) {
      elSal+=""+lista1[i]+", ";
    }

    for (int i=0;i<lista2.length ;i++ ) {
      el1Sal+=""+lista2[i]+", ";
    }

    String sal="";
    ArrayList <Integer> union;

    if (opc.equals("Union")) {
      mets.union(lista1,lista2);
      sal+="X U Y= {";
    }else if (opc.equals("Interseccion")) {
      mets.inter(lista1,lista2);
      sal+="X n Y= {";
    }else if (opc.equals("Complemento")) {
      mets.comple(lista1,lista2);
      sal+="X^C= {";
    }else if (opc.equals("Diferencia")) {
      mets.difA_B(lista1,lista2);
      union=mets.getArreglo();

      sal+="X - Y= {";
      for (int i=0;i<union.size() ;i++ ) {
        sal+=union.get(i)+", ";
      }
      sal+="}";

      mets.difB_A(lista1,lista2);
      union=mets.getArreglo();
      sal+="\nY - X= {";
      for (int i=0;i<union.size() ;i++ ) {
        sal+=union.get(i)+", ";
      }
      sal+="}";
    }else if (opc.equals("Diferencia Simetrica")) {
      mets.difSim(lista1,lista2);
    }

    if (!opc.equals("Diferencia")) {
      //Obteccion del arreglo final
      union = mets.getArreglo();

      sal+="{";
      for (int i=0;i<union.size() ;i++ ) {
        sal+=union.get(i)+", ";
      }
      sal+="}";
    }

    JOptionPane.showMessageDialog(null,ele1+"= "+elSal+"}\n"+
                                      ele2+"= "+el1Sal+"}\n\n"+
                                      opc+": \n"+
                                      sal,"Resultado",JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }

}
