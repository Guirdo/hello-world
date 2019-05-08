package mx.edu.itch.seblab.principal;

import mx.edu.itch.seblab.clases.Negocio;
import mx.edu.itch.seblab.generadores.GeneradorPDF;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Ventana;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Principal extends Ventana implements KeyListener{

    private int contadorDias;
    private DefaultTableModel modelo;
    private JTextField tfNumVenta;

    public Principal(){
        super("Ventas - Metodo MonteCarlo",new MigLayout("wrap"
                                ,"10[]10"
                                ,"10[]10[]10"));

        contadorDias=0;

        this.initUI();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void initUI() {

        tfNumVenta = new JTextField(16);
        modelo = new DefaultTableModel(new Object[]{"Dia","Numero de ventas al día reales"},0);
        JTable tabla = new JTable(modelo);
        Boton btnIngresar = new Boton("Ingresar");
        Boton btnCalcular = new Boton("Calcular");
        btnCalcular.setFont(new Font("Arial",1,18));
        JTextField tfProducto = new JTextField(15);
        JTextField tfRenta = new JTextField(15);
        JTextField tfServicios = new JTextField(15);
        JTextField tfSalarioAdmin = new JTextField(15);
        JTextField tfSalarioVentas = new JTextField(15);
        JTextField tfCostoProUnidad = new JTextField(15);
        JTextField tfVentaUnidad = new JTextField(15);
        JSpinner spNumEsc = new JSpinner(new SpinnerNumberModel(5,5,50,1));
        //Etiqueta lblGastosQuincinal = new Etiqueta("",new Font("Arial",1,12));
        //Etiqueta lblGastosDiario= new Etiqueta("",new Font("Arial",1,12));

        /**
         * Zona del manejo de eventos
         */

        btnIngresar.addActionListener((ActionEvent)->{
            this.addRowToModel();
        });

        tfNumVenta.addKeyListener(this);

        btnCalcular.addActionListener((ActionEvent)->{
             String producto = tfProducto.getText();
             double renta = Double.parseDouble(tfRenta.getText());
             double servicios = Double.parseDouble(tfServicios.getText());
             double salarioAdministrativos = Double.parseDouble(tfSalarioAdmin.getText());
             double salarioVentas = Double.parseDouble(tfSalarioVentas.getText());
             double costoProUni = Double.parseDouble(tfCostoProUnidad.getText());
             double precioVentaUni = Double.parseDouble(tfVentaUnidad.getText());
             int numEscenarios = (int) spNumEsc.getValue();


            int [] datosHistoricos = new int[modelo.getRowCount()];
            for(int i=0;i<modelo.getRowCount();i++){
                datosHistoricos[i]=(int)modelo.getValueAt(i,1);
            }

            Negocio negocio = new Negocio(producto,datosHistoricos,renta,servicios,salarioAdministrativos,salarioVentas,costoProUni,precioVentaUni);

            //Negocio negocio = new Negocio("Tazas",datosHistoricos,0,0,0,0,0,0);

            try {
                new GeneradorPDF(negocio,numEscenarios).generarPDF();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        /**
         * Zona de layout de la interfaz grafica
         */
        JPanel pnlHistoricos = new JPanel(new MigLayout("wrap 2","[]20[]","[]15[]7[]7[]"));
        pnlHistoricos.add(new Etiqueta("Datos historicos",new Font("Arial",1,16)),"wrap");
        pnlHistoricos.add(new Etiqueta("Numero de ventas al dia reales:",new Font("Arial",0,12)),"left");
        pnlHistoricos.add(new JScrollPane(tabla),"w 570::,h :300:,span 1 3,center");
        pnlHistoricos.add(tfNumVenta,"");
        pnlHistoricos.add(btnIngresar,"top,growx");

        JPanel pnlNegocio = new JPanel(new MigLayout("wrap 5","[]15[]15[]15[]30[100::]","[]15[]7[]7[]7[]7[]"));
        pnlNegocio.setBorder(BorderFactory.createLineBorder(PaletaColores.SILVER));
        pnlNegocio.add(new Etiqueta("Datos del negocio",new Font("Arial",1,16)),"wrap");
        pnlNegocio.add(new Etiqueta("Producto: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfProducto,"wrap");
        pnlNegocio.add(new Etiqueta("Renta: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfRenta);
        pnlNegocio.add(new Etiqueta("Servicios: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfServicios,"");
        pnlNegocio.add(btnCalcular,"span 1 3,growx,growy");
        pnlNegocio.add(new Etiqueta("Salario administrativos: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfSalarioAdmin,"");
        pnlNegocio.add(new Etiqueta("Salario ventas: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfSalarioVentas,"");
        pnlNegocio.add(new Etiqueta("Costo Produccion unidad: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfCostoProUnidad,"");
        pnlNegocio.add(new Etiqueta("Precio venta unidad: ",new Font("Arial",0,12)),"");
        pnlNegocio.add(tfVentaUnidad,"");
        pnlNegocio.add(new Etiqueta("Numero escenarios: ",new Font("Arial",0,12)));
        pnlNegocio.add(spNumEsc,"right");

        //pnlNegocio.add(new Etiqueta("Gasto operativo quincenal: ",new Font("Arial",0,12)),"");
        //pnlNegocio.add(lblGastosQuincinal,"");
        //pnlNegocio.add(new Etiqueta("Gasto operativo diario: ",new Font("Arial",0,12)),"");
        //pnlNegocio.add(lblGastosDiario,"");



        this.add(pnlHistoricos);
        this.add(pnlNegocio);

    }

    private void addRowToModel() {
        int numVentas = Integer.parseInt(tfNumVenta.getText());
        contadorDias++;

        modelo.addRow(new Object[]{contadorDias,numVentas});

        tfNumVenta.setText("");
        tfNumVenta.requestFocus();
    }

    public static void main(String[] args) {
        new Principal().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            this.addRowToModel();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
