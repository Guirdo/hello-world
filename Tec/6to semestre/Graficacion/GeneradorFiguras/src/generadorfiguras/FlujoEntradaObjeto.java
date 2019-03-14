package generadorfiguras;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class FlujoEntradaObjeto extends ObjectInputStream{

    public FlujoEntradaObjeto(InputStream in) throws IOException {
        super(in);
    }
    
    @Override
    protected void readStreamHeader(){
        
    }

}
