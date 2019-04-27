package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    private Calculadora calculadora;
    private ConvertidorInfijaPolaca polaca;

    @Before
    public void setUp() throws Exception {
        polaca = new ConvertidorInfijaPolaca("2d-4d");
        calculadora = new Calculadora(polaca.darPrefija());
    }

    @Test
    public void calcularTest() {
        try {
            assertEquals(-2,calculadora.calcular(),0);
        } catch (FormatoEquivocadoException e) {
            e.printStackTrace();
        }
    }
}