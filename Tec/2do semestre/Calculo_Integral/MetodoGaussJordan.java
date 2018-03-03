import java.util.Scanner;

public class MetodoGaussJordan{
  
  public void MetodoGauss(){
    
    Scanner sc = new Scanner(System.in);
int i,j,k,n;
double a[][] = new double [5][6];
double cte,x1,x2,x3;
double x[] = new double [5];
System.out.println("\t\t\t\"METODO DE GAUSS\"");
System.out.println("Dame el numero de incognitas (de hasta 5) ");
n=sc.nextInt();
System.out.println("Ingrese coeficientes");
for(i=0;i<{
System.out.println("Renglon "+(i+1));
for(j=0;j&lt;=n;j++)
{
System.out.println(" Ingrese a "+(i+1)+" "+(j+1));
a[i][j]=sc.nextInt();
}
}
for(i=0;i for(j=i+1;j&lt;=n;j++){
cte=(-a[j][i])/(a[i][i]);
for(k=i;k a[j][k]=((a[i][k])*cte)+a[j][k];
}
}
}
x3=a[n-1][n]/a[n-1][n-1];
x2=(a[n-2][n]-x3*a[n-2][n-1])/a[n-2][n-2];
x1=(a[n-3][n]-x2*a[n-3][n-2]-x3*a[n-3][n-1])/a[n-3][n-3];
System.out.println("x0= "+x1+" \nx1= " +x2+" \nx2= " +x3);
}
  
  
  
  
  public static void main(String[] args){
    MetodoGauss();
  }
  
}