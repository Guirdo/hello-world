public class MetodoQuicksort {

    static int[] arreglo = {14,6,2,8,3,5,1,9,12};
    static int primero = 0;
    static int ultimo = arreglo.length-1;

    public static void main(String[] args){

        //Se imprime el arreglo antes de usar quicksort
        for(int i=0;i<arreglo.length;i++){
            System.out.println(arreglo[i]);
        }

        System.out.println("----------------");
        quicksort(primero,ultimo);

        //Se imprime el arreglo despues de usar quicksort
        for(int i=0;i<arreglo.length;i++){
            System.out.println(arreglo[i]);
        }

        System.exit(0);
    }

    //Metodo para intercambiar lugares entre elementos
    //del arreglo
    public static void intercambiar(int i, int j){
        int aux = arreglo[i];
        arreglo[i]=arreglo[j];
        arreglo[j]=aux;
    }

    //Implementación del metodo recursivo del Quicksort
    public static void quicksort(int primero,int ultimo){

        int i,j,central;
        int pivote;

        central = (primero+ultimo)/2;
        pivote = arreglo[central];
        i = primero;
        j = ultimo;

        do{
            while (arreglo[i] < pivote) i++;
            while (arreglo[j] > pivote) j--;

            if (i <= j){
                intercambiar(i,j);
                i++;
                j--;
            }
        }while (i <= j);

        if(primero < j) quicksort(primero,j);
        if(i < ultimo) quicksort(i,ultimo);
    }

}
