package mx.edu.itch.isc.seblab.principal;

import mx.edu.itch.isc.seblab.automatas.AutomataSentencia;
import mx.edu.itch.isc.seblab.manejadores.ManejoCadenas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.StringTokenizer;

public class ManejadorPrincipal implements ActionListener, KeyListener {

    private Pantalla pantalla;

    public ManejadorPrincipal() {
        pantalla = new Pantalla();

        pantalla.tfCadena.addKeyListener(this);
        pantalla.btnIngresar.addActionListener(this);

        pantalla.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pantalla.btnIngresar){
            manejaEventoIngresar();
        }
    }

    private void manejaEventoIngresar() {
        String cadena = pantalla.tfCadena.getText();
        StringTokenizer tokenizer = new StringTokenizer(cadena," ()",true);

        AutomataSentencia sentenciaIf = new AutomataSentencia(12);
        ManejoCadenas manejoCadenas = new ManejoCadenas();
        int estado = 0;
        int entrada;
        String tokenActual;

        do {
            if(tokenizer.hasMoreTokens()){
                tokenActual = tokenizer.nextToken();
                if(manejoCadenas.esPalabraIF(tokenActual)){
                    entrada=0;
                }else if(manejoCadenas.esEspacio(tokenActual)){
                    entrada=1;
                }else if(manejoCadenas.esParentesisApertura(tokenActual)){
                    entrada=2;
                }else if(manejoCadenas.esVariable(tokenActual) && !manejoCadenas.esPalabraTHEN(tokenActual)){
                    entrada=3;
                }else if(manejoCadenas.esOperadorLogico(tokenActual)){
                    entrada=4;
                }else if(manejoCadenas.esNumeroReal(tokenActual)){
                    entrada=5;
                }else if(manejoCadenas.esParentesisCierre(tokenActual)){
                    entrada=6;
                }else if(manejoCadenas.esPalabraTHEN(tokenActual)){
                    entrada=7;
                }else if(manejoCadenas.esSignoIgual(tokenActual)){
                    entrada=8;
                }else{
                    entrada = -1;
                }
            }else{
                entrada = 9;
            }

            int nuevoEstado = entrada!=-1 ? sentenciaIf.getEstado(estado,entrada):-1;

            if(nuevoEstado == -1){
                break;
            }else{
                estado = nuevoEstado;
            }
        }while(!sentenciaIf.esEstadoFinal(estado));

        if(sentenciaIf.esEstadoFinal(estado)){
            pantalla.taResultado.setText("Cadena aceptada");
        }else{
            pantalla.taResultado.setText("Cadena no aceptada: \n"+sentenciaIf.getMensajeError(estado+1));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            this.manejaEventoIngresar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
