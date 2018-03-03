/*
 * Hola!
 */
package cuestionariodiana;

import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class CuestionarioDiana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Variables
        int correcta=0, seleccion, i=0;
        try{
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"¿En dónde surge la probabilidad?", "Pregunta 1",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) México", "b) España", "c) Estados Unidos", "d) Francia" },"a) México");
        		if (seleccion ==3){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: surgió en otro país.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"La probabilidad surge debido a:", "Pregunta 2",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Números", "b) Juegos de azar", "c) Una plática", "d) Libros" },"a) Números");
        		if (seleccion ==1){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: surgió de otra forma.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"¿Entre qué siglos surge la probabilidad?", "Pregunta 3",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) XVI y XVII", "b) XVIII y XIX", "c) XV y XVI", "d) XVII y XVIII" },"a) XVI y XVII");
        		if (seleccion ==0){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: surge en siglos diferentes.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Trataron de resolver algunos problemas relacionados con los juegos de azar:", "Pregunta 4",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Bayes y Tomas", "b) Pierre Fermat y Baise Pascal", "c) Dogson y Fisher", "d) Gregor Mendez y Andrei Kolmorogoro" },"a) Bayes y Tomas");
        		if (seleccion ==1){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: fueron otros personajes.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"En el siglo XX la probabilidad fue convertida en axiomas, a este desarrollo axiomatico se le conoce como:", "Pregunta 5",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Probabilidad clásica", "b) Probabilidad inferencial", "c) Probabilidad aleatoria", "d) Probabilidad moderna" },"a) Probabilidad clásica");
        		if (seleccion ==3){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: se le conoce de otra forma.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"¿Por qué es importante la probabilidad?", "Pregunta 6",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Es necesaria", "b) Define el futuro", "c) Es posible ajustar de manera exacta diferentes resultados", "d) Ninguna de las anteriores" },"a) Es necesaria");
        		if (seleccion ==2){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: Es por otro motivo.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"¿De qué fue el primer libro publicado sobre la probabilidad?", "Pregunta 7",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Teorías", "b) Experimentos", "c) Biografía", "d) Juegos de azar" },"a) Teorías");
        		if (seleccion ==3){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: fue de sobre otra cosa.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"¿Quién definió la probabilidad de forma axiomática?", "Pregunta 8",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Paul Levy", "b) Andrei Kolmogorov", "c) Galileo Galilei", "d) Pierre Fermat" },"a) Paul Levy");
        		if (seleccion ==1){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: fue otra persona.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{//9
        		seleccion = JOptionPane.showOptionDialog( null,"La probabilidad trata con los problemas de:", "Pregunta 9",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Azar o aleatorios", "b) Suerte y destino", "c) Dados", "d) Los juegos" },"a) Azar o aleatorios");
        		if (seleccion ==0){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: se refiere a otros problemas.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Es la casualidad caso  fortuito. No tiene causa: ", "Pregunta 10",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Suerte", "b) Aleatorio", "c) Probabilidad", "d) Azar" },"a) Suerte");
        		if (seleccion ==3){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: es otro concepto.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"¿A qué fue primeramente aplicada la probabilidad?", "Pregunta 11",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Problemas socioeconómicos", "b) Al clima", "c) Estadística", "d) Juegos de azar" },"a) Problemas socioeconómicos");
        		if (seleccion ==3){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: aplicada a algo distinto.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Es un resultado posible que se consigue al hacer determinada acción:", "Pregunta 12",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Espacio muestral", "b) Evento", "c) Experimento", "d) Combinación" },"a) Espacio muestral");
        		if (seleccion ==1){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: se refiere a otro concepto.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Es una regla de la probabilidad: ", "Pregunta 13",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Integración", "b) Multiplicación de matrices", "c) Regla de la adición", "d) Regla de derivación" },"a) Integración");
        		if (seleccion ==2){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: tu respuesta no pertenece a la rama de Probabilidad.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Fue el jugador que cuestionó a Blaise Pascal sobre la probabilidad y este, a su vez, comenzó a interesarse por ello:", "Pregunta 14",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Antoine Gombaud, Chevalier De Méré", "b) Andrei Kolmogorov", "c) Conde de Buffon", "d) Pierre Fermat" },"a) Antoine Gombaud, Chevalier De Méré");
        		if (seleccion ==0){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: fue otra persona.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Son algunos conceptos que pertenecen a la probabilidad: ", "Pregunta 15",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Matriz, Vector", "b) Límite, Asíntota", "c) Permutación, Combinación", "d) Ninguna de las anteriores" },"a) Matriz, Vector");
        		if (seleccion ==2){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: seleccionaste los conceptos equivocados.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Todos los elementos de un tema de referencia son denominados: ", "Pregunta 16",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Muestra", "b) Unión", "c) Conjunto Universo", "d) Total de datos" },"a) Muestra");
        		if (seleccion ==2){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: tienen otro nombre.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Un conjunto sin elementos tiene el nombre de: ", "Pregunta 17",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Conjunto negativo", "b) Conjunto vacío", "c) Conjunto complemento", "d) Experimento" },"a) Conjunto negativo");
        		if (seleccion ==0){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: tienen otro nombre.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"Es otro de los métodos utilizados en la probabilidad: ", "Pregunta 18",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Potencias", "b) Ciclos", "c) Números binarios", "d) Diagrama de árbol" },"a) Potencias");
        		if (seleccion ==3){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: el método que seleccionaste no es parte de la Probabilidad.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"La probabilidad es una rama de: ", "Pregunta 19",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Las matemáticas", "b) La física", "c) El azar", "d) La estadística" },"a) Las matemáticas");
        		if (seleccion ==0){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: pertenece a otra ciencia.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	i=0;
        	do{
        		seleccion = JOptionPane.showOptionDialog( null,"La probabilidad de que un evento ocurra o no es expresada comúnmente en:", "Pregunta 20",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] { "a) Decimales", "b) Porcentaje", "c) Conjuntos", "d) Sin unidades" },"a) Decimales");
        		if (seleccion ==1){
           		correcta++;
           		i=2;
        		}
        		else{
        			JOptionPane.showMessageDialog(null,"Error: es expresada de otra forma.","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        			i+=1;
        		}
        	}while(i<2);
        	JOptionPane.showMessageDialog(null, "Obtuviste "+correcta+" respuestas correctas.\nTu calificación es de: "+(5*correcta)+" puntos.", "correctas", JOptionPane.INFORMATION_MESSAGE);
        }//catch
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error.", "Error.", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
    
}
