package generadorfiguras;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FlujoSalidaObjeto extends ObjectOutputStream {
    
    public FlujoSalidaObjeto(FileOutputStream fl) throws IOException{
        super(fl);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        
    }

}
