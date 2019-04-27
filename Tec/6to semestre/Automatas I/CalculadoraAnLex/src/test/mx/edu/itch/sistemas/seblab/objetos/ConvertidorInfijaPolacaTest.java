package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.ParentesisException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.Assert.*;

public class ConvertidorInfijaPolacaTest {

    private ConvertidorInfijaPolaca ci;

    @Before
    public void setUp() throws Exception {
        ci = new ConvertidorInfijaPolaca("48.2+10b");
    }


    @Test
    public void darPrefija() {
        ArrayList<String> array= new ArrayList<>();

        array.add("2d");
        array.add("3d");
        array.add("5d");
        array.add("/");
        array.add("4d");
        array.add("+");
        array.add("-");

        try {
            assertEquals(array,ci.darPrefija());
        } catch (ParentesisException e) {
            e.printStackTrace();
        }
    }
}