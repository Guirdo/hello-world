public class MetodoShellsort {

    static int[] arreglo = {34,12,5,65,1,5,
                            45,32,13,10,9};


    public static void main(String[] args){
        for(int i=0;i<arreglo.length;i++)
            System.out.print(arreglo[i]+"  ");

        System.out.println("\n--------------");
        shellsort();

        for(int i=0;i<arreglo.length;i++)
            System.out.print(arreglo[i]+"  ");
    }

    //Metodo para intercambiar lugares entre elementos
    //del arreglo
    public static void intercambiar(int i, int j){
        int aux = arreglo[i];
        arreglo[i]=arreglo[j];
        arreglo[j]=aux;
    }

    //Metodo Shellsort
    public static void shellsort(){
        int intervalo, i, j, k;
        int n= arreglo.length;
        intervalo = n / 2;
        while (intervalo > 0)
        {
            for (i = intervalo; i < n; i++)
            {
                j = i - intervalo;
                while (j >= 0)
                {
                    k = j + intervalo;
                    if (arreglo[j] <= arreglo[k])
                        j = -1; // par de elementos ordenado
                    else
                    {
                        intercambiar(j, j+1);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
    }
}
