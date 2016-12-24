SubProceso in<-darPul(pul)
	Definir in Como Real;
	
	in<-pul*2.54;
FinSubProceso

Proceso sin_titulo
	Definir pul Como Real;
	
	Escribir Sin Saltar "Ingrese la medida en pulgadas";
	Leer pul;
	
	Escribir pul," pulgadas es equivalente a ",darPul(pul)," cm";
FinProceso
