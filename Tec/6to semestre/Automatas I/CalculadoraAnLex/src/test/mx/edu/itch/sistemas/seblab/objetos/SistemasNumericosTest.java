package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SistemasNumericosTest {

    private SistemasNumericos sn;
    @Before
    public void setUp() throws Exception {
         sn = new SistemasNumericos();
    }

    @Test
    public void decimalFlotante() {
        try {
            assertEquals(2.75,sn.convertirADecimal("10.11","b"),0);
        } catch (FormatoEquivocadoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertirBinarioDecimal()  {
        try {
            assertEquals(13,sn.convertirADecimal("1101","b"),0);
        } catch (FormatoEquivocadoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertirOctagonlaDecimal(){
        try {
            assertEquals(9,sn.convertirADecimal("11","o"),0);
        } catch (FormatoEquivocadoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertirHexDecimal() {
        try {
            assertEquals(26,sn.convertirADecimal("1A","X"),0);
        } catch (FormatoEquivocadoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void decimalBinario() {
        assertEquals("1111.010",sn.convertirASistema(15.252,"b",3));
    }

    @Test
    public void decimalOctal() {
        assertEquals("645.4",sn.convertirASistema(421.5,"o",1));
    }

    @Test
    public void decimalHexa() {
        assertEquals("1C2.8",sn.convertirASistema(450.5,"x",1));
    }

    @Test
    public void elevarDosTest() {
        assertEquals(2,Math.pow(2,1),0);
    }
}