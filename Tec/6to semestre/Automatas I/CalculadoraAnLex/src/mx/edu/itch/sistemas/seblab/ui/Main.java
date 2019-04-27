package mx.edu.itch.sistemas.seblab.ui;

import mx.edu.itch.sistemas.seblab.Imagen.Imagen;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.*;
import mx.edu.itch.sistemas.seblab.ManejadorArchivo.ManejadorArchivoTexto;
import mx.edu.itch.sistemas.seblab.excepciones.FormatoEquivocadoException;
import mx.edu.itch.sistemas.seblab.excepciones.ParentesisException;
import mx.edu.itch.sistemas.seblab.objetos.Calculadora;
import mx.edu.itch.sistemas.seblab.objetos.ClasificacionNumeros;
import mx.edu.itch.sistemas.seblab.objetos.ConvertidorInfijaPolaca;
import mx.edu.itch.sistemas.seblab.objetos.SistemasNumericos;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

/**
 *
 */

public class Main extends Ventana implements KeyListener {

    private AreaTexto atOperacion;
    private AreaTexto atValidacion;
    private ClasificacionNumeros cn;
    private JTable tabBin, tabDec,tabOct,tabHex,tabReal;
    private Etiqueta lblDecimal,lblOctal,lblHexa,lblBinario;
    private JSpinner spnFlotante;

    public Main() {
        super("Calculadora", new MigLayout("wrap 4","[]10[]15[]15[]10"
                                                    ,"10[]15[]15[]10")); //
        this.setIconImage(Imagen.obtenerImagen(this,"/mx/edu/itch/sistemas/seblab/imagenes/icono.png").getImage());
        this.ponerBackground(PaletaColores.LINX_WHITE);
        tabBin=new JTable(new DefaultTableModel(new Object[]{"Binarios"},0));
        tabDec=new JTable(new DefaultTableModel(new Object[]{"Decimales"},0));
        tabOct=new JTable(new DefaultTableModel(new Object[]{"Octales"},0));
        tabHex=new JTable(new DefaultTableModel(new Object[]{"Hexadecimales"},0));
        tabReal=new JTable(new DefaultTableModel(new Object[]{"Reales"},0));

        this.add(darBarra(),"north");
        this.add(darPanelPrincipal(),"span 1 3");
        //this.add(darPanelTablas());
        this.add(new Etiqueta("Clasificación de números",1,16),"span 3");
        this.add(new JScrollPane(tabBin),"w :120:150,h 120::150");
        this.add(new JScrollPane(tabDec),"w :120:150,h 120::150");
        this.add(new JScrollPane(tabOct),"w :120:150,h 120::150");
        this.add(new JScrollPane(tabHex),"w :120:150,h 120::150");
        this.add(new JScrollPane(tabReal),"w :120:150,h 120::150");

        this.pack();
        this.setLocationRelativeTo(null);

        new Presentacion("Proyecto final","Programa que recibe una operación aritmética, que puede ser entre " +
                                    "diferentes sistemas numéricos (ya sea binario, octal, decimal y hexadecimal). " +
                                    "Tambien evalua la construcción de la operación, " +
                                    "como el formato de los números y los paréntesis.",
                new MigLayout(Presentacion.RESTRICCION,Presentacion.RESTRICCION_COLS,
                                    Presentacion.RESTRICCION_FILAS)).setVisible(true);
    }


    private JToolBar darBarra(){
        JToolBar tbBarra = new JToolBar(JToolBar.HORIZONTAL);
        tbBarra.setLayout(new FlowLayout(FlowLayout.LEFT));
        tbBarra.setFloatable(false);

        Boton btnAbrir = new Boton("Abrir",Imagen.obtenerImagen(this,"/mx/edu/itch/sistemas/seblab/imagenes/abrir.png")
                                            ,null,null);
        btnAbrir.setBorder(null);
        btnAbrir.addActionListener((ActionEvent)->{
            ManejadorArchivoTexto ma = new ManejadorArchivoTexto(atOperacion);

            try {
                ma.abrirArchivo(atOperacion);
            } catch (FileNotFoundException e) {
                //Dialogo modal de error
            }

        });

        tbBarra.add(btnAbrir);

        return tbBarra;
    }

    private JPanel darPanelPrincipal(){
        JPanel pnl = new JPanel(new MigLayout("wrap 4",
                                "[150,left]10[110,right]15[]10[]",
                                "[]5[]10[]10[]5[]5[20]10[]5[20]10[]5[20]10[]5[20]15[]"));

        pnl.setBackground(PaletaColores.LINX_WHITE);
        atOperacion= new AreaTexto(4,45,true,null, PaletaColores.PROTOSS_PYLON);
        atOperacion.addKeyListener(this);

        SpinnerNumberModel modelo = new SpinnerNumberModel(1,1,10,1);
        spnFlotante = new JSpinner(modelo);

        Boton btnCalcular = new Boton("Calcular",PaletaColores.EMERALD,PaletaColores.LINX_WHITE);

        lblDecimal = new Etiqueta("",0,13);
        lblBinario = new Etiqueta("",0,13);
        lblOctal = new Etiqueta("",0,13);
        lblHexa = new Etiqueta("",0,13);

        atValidacion = new AreaTexto(2,41,false,new Font("Arial",1,14));
        atValidacion.setBackground(PaletaColores.AZURE_2);
        atValidacion.setBorder(BorderFactory.createLineBorder(PaletaColores.SILVER,2));

        //Creacion de metodos para Eventos
        btnCalcular.addActionListener((ActionEvent)->{
            this.calcular();
        });

        pnl.add(new Etiqueta("Operación",1,14),"span 4 1");
        pnl.add(new JScrollPane(atOperacion),"span 4 1,growx, pushx");
        pnl.add(new JLabel("Presición punto flotante: "),"");
        pnl.add(spnFlotante,"");
        pnl.add(btnCalcular,"span 2 1,grow x,push x");
        pnl.add(new Etiqueta("Resultado",1,15),"span 4");
        pnl.add(new Etiqueta("Decimal: ",1,13),"span 4");
        pnl.add(lblDecimal,"span 4,right");
        pnl.add(new Etiqueta("Octal: ",1,13),"span 4");
        pnl.add(lblOctal,"span 4,right");
        pnl.add(new Etiqueta("Binario",1,13),"span 4");
        pnl.add(lblBinario,"span 4,right");
        pnl.add(new Etiqueta("Hexadecimal",1,13),"span 4");
        pnl.add(lblHexa,"span 4,right");
        pnl.add(new JScrollPane(atValidacion),"span 4,growx, pushx");

        return pnl;
    }

    private void calcular(){
        String operacion = atOperacion.getText();

        try {
            ConvertidorInfijaPolaca cip = new ConvertidorInfijaPolaca(operacion);
            Calculadora c = new Calculadora(cip.darPrefija());
            SistemasNumericos sn = new SistemasNumericos();
            cn = new ClasificacionNumeros(cip.darNumeros());
            double resultado = c.calcular();
            int presicion = (int) spnFlotante.getValue();

            lblDecimal.setText(String.format("%."+presicion+"f",resultado));
            if(resultado>=0){
                lblBinario.setText(""+ sn.convertirASistema(resultado,"b",presicion));
                lblOctal.setText(""+sn.convertirASistema(resultado,"o",presicion));
                lblHexa.setText(""+sn.convertirASistema(resultado,"x",presicion));
            }else{
                lblBinario.setText("-"+ sn.convertirASistema(-resultado,"b",presicion));
                lblOctal.setText("-"+sn.convertirASistema(-resultado,"o",presicion));
                lblHexa.setText("-"+sn.convertirASistema(-resultado,"x",presicion));
            }

            atValidacion.setText("Operacion correctamente construida");
            atValidacion.setBackground(PaletaColores.EMERALD);

            //TODO Pasar los numeros a las tablas
            tabBin.setModel(cn.getModeloBin());
            tabDec.setModel(cn.getModeloDec());
            tabOct.setModel(cn.getModeloOct());
            tabHex.setModel(cn.getModeloHex());
            tabReal.setModel(cn.getModeloReal());
        } catch (ParentesisException | FormatoEquivocadoException e) {
            atValidacion.setText(e.getMessage());
            atValidacion.setBackground(PaletaColores.POMEGRANATE);
        }
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            this.calcular();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            this.calcular();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            this.calcular();
        }
    }
}
