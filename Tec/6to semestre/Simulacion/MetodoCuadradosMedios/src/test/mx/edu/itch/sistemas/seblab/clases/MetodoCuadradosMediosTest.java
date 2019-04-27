package mx.edu.itch.sistemas.seblab.clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetodoCuadradosMediosTest {

    MetodoCuadradosMedios mcm;

    @BeforeEach
    void setUp() {
        mcm = new MetodoCuadradosMedios("7543");
    }

    @Test
    void metodoCuadradosMedios() {
        int cont = 10;

        while(mcm.findRandomNumber() && cont>1){
            cont--;
        }

        assertEquals(0.1778,mcm.getNumeroAleatorio(),0);
    }
}