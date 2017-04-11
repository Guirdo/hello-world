#include <stdio.h>

int main(int argc, char const *argv[]) {
  int i=1,dig,num;
  int ama=0,rosa=0,rojo=0,verde=0,azul=0;

  printf("Ingrese el numero de autos: ");
  scanf("%d",&num);

  if(num > 0){

    for (i = 1; i <= num; i++) {

      printf("Ingrese el ultimo digito de la matricula del auto #%d: ",i);
      scanf("%d",&dig);

      switch (dig) {
        case 1:
          ama++;
          break;
        case 2:
          ama++;
          break;
        case 3:
          rosa++;
          break;
        case 4:
          rosa++;
          break;
        case 5:
          rojo++;
          break;
        case 6:
          rojo++;
          break;
        case 7:
          verde++;
          break;
        case 8:
          verde++;
          break;
        case 9:
          azul++;
          break;
        case 0:
          azul++;
          break;
        default:
          printf("Error: introduzca un solo digito.\n");
          i=i-1;
      }
    }

    printf("El numero de calcomanias amarillas es de: %d\n",ama);
    printf("El numero de calcomanias rosas es de: %d\n",rosa);
    printf("El numero de calcomanias rojas es de: %d\n",rojo);
    printf("El numero de calcomanias verdes es de: %d\n",verde);
    printf("El numero de calcomanias azules es de: %d\n",azul);

  }

  return 0;
}
