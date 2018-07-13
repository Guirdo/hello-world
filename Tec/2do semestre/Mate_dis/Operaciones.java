
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


