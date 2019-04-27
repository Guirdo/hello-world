package mx.edu.itch.sistemas.seblab.objetos;

import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ClasificacionNumeros {

    private DefaultTableModel modeloBin;
    private DefaultTableModel modeloDec;
    private DefaultTableModel modeloOct;
    private DefaultTableModel modeloHex;
    private DefaultTableModel modeloReal;
    private ArrayList<String> numeros;

    public ClasificacionNumeros(ArrayList<String> numeros) throws FormatoEquivocadoException {
        this.numeros=numeros;
        this.modeloBin=new DefaultTableModel(new Object[]{"Binarios"},0);
        this.modeloDec=new DefaultTableModel(new Object[]{"Decimales"},0);
        this.modeloOct=new DefaultTableModel(new Object[]{"Octales"},0);
        this.modeloHex=new DefaultTableModel(new Object[]{"Hexadecimales"},0);
        this.modeloReal= new DefaultTableModel(new Object[]{"Reales"},0);

        this.clasificarNumeros();
    }

    private void clasificarNumeros() throws FormatoEquivocadoException {
        for(int i=0;i<numeros.size();i++){
            if(numeros.get(i).matches("[-]?[01]+([.][01]+)?[Bb]")){
                modeloBin.addRow(new Object[]{numeros.get(i)});
            }else if(numeros.get(i).matches("[-]?[0-9]+([.][0-9]+)?[Dd]")){
                String[] split = numeros.get(i).split("[Dd]");
                modeloDec.addRow(new Object[]{split[0]});
            }else if(numeros.get(i).matches("[-]?[0-7]+([.][0-7]+)?[Oo]")){
                modeloOct.addRow(new Object[]{numeros.get(i)});
            }else if(numeros.get(i).matches("[-]?[0-9A-Fa-f]+([.][0-9A-Fa-f]+)?[Xx]")){
                modeloHex.addRow(new Object[]{numeros.get(i)});
            }else if(numeros.get(i).matches("e")){
                modeloReal.addRow(new Object[]{numeros.get(i)});
            }else{
                System.out.println(numeros.get(i));
                throw new FormatoEquivocadoException("¡Formato de numero erroneo! Clasificación de numeros.");
            }
        }
    }

    public DefaultTableModel getModeloBin() {
        return modeloBin;
    }

    public DefaultTableModel getModeloDec() {
        return modeloDec;
    }

    public DefaultTableModel getModeloOct() {
        return modeloOct;
    }

    public DefaultTableModel getModeloHex() {
        return modeloHex;
    }

    public DefaultTableModel getModeloReal() {
        return modeloReal;
    }

    public ArrayList<String> getNumeros() {
        return numeros;
    }
}
