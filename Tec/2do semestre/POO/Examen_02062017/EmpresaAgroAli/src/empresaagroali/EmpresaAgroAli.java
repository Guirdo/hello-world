/*
 * Hola!
 */
package empresaagroali;

import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastián Méndez <ITCH>
 */
public class EmpresaAgroAli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int continuar = 0, seleccion = 0, opc = 0;
        String ed = "Entrada de datos";
        String fechaCad, nombre, paisOri, codigo, fecEnva, numLote;
        double temp;
        ObjectOutputStream salida = null;
        ObjectInputStream entrada = null;
        String[] menu = {"Agregar datos", "Vizualizar datos", "Salir"};
        String[] tipoProducto = {"Fresco", "Refrigerado", "Congelado"};
        String[] tipoCongelado = {"Por Aire", "Por agua", "Por Nitrogeno"};

        try {
            salida = new ObjectOutputStream(new FileOutputStream("productos.dat", true));

            do {
                opc = JOptionPane.showOptionDialog(null, null, "Menu principal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, null);

                switch (opc) {
                    //Agregar datos
                    case 0:
                        continuar = 0;
                        while (continuar == 0) {
                            seleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de producto", ed, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipoProducto, null);
                            switch (seleccion) {
                                //Fresco
                                case 0:
                                    nombre = JOptionPane.showInputDialog(null, "Nombre", ed, JOptionPane.QUESTION_MESSAGE);
                                    fechaCad = JOptionPane.showInputDialog(null, "Fecha de caducidad", ed, JOptionPane.QUESTION_MESSAGE);
                                    paisOri = JOptionPane.showInputDialog(null, "Pais de origen", ed, JOptionPane.QUESTION_MESSAGE);
                                    fecEnva = JOptionPane.showInputDialog(null, "Fecha de envasado", ed, JOptionPane.QUESTION_MESSAGE);
                                    numLote = JOptionPane.showInputDialog(null, "Numero de lote", ed, JOptionPane.QUESTION_MESSAGE);
                                    //alm.agregarProducto(new Fresco(fecEnva, paisOri, fechaCad, numLote, nombre));
                                    salida.writeUnshared(new Fresco(fecEnva, paisOri, fechaCad, numLote, nombre));
                                    break;
                                //Refrigerado
                                case 1:
                                    nombre = JOptionPane.showInputDialog(null, "Nombre", ed, JOptionPane.QUESTION_MESSAGE);
                                    fechaCad = JOptionPane.showInputDialog(null, "Fecha de caducidad", ed, JOptionPane.QUESTION_MESSAGE);
                                    paisOri = JOptionPane.showInputDialog(null, "Pais de origen", ed, JOptionPane.QUESTION_MESSAGE);
                                    codigo = JOptionPane.showInputDialog(null, "Codigo", ed, JOptionPane.QUESTION_MESSAGE);
                                    fecEnva = JOptionPane.showInputDialog(null, "Fecha de envasado", ed, JOptionPane.QUESTION_MESSAGE);
                                    numLote = JOptionPane.showInputDialog(null, "Numero de lote", ed, JOptionPane.QUESTION_MESSAGE);
                                    temp = Double.parseDouble(JOptionPane.showInputDialog(null, "Temperatura de mantenimiento recomendada", ed, JOptionPane.QUESTION_MESSAGE));
                                    //alm.agregarProducto(new Refrigerado(codigo, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                    salida.writeUnshared(new Refrigerado(codigo, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                    break;
                                //Congelado
                                case 2:
                                    seleccion = JOptionPane.showOptionDialog(null, "Seleccione metodo de congelacion", ed, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipoCongelado, null);
                                    switch (seleccion) {
                                        //Por aire
                                        case 0:
                                            nombre = JOptionPane.showInputDialog(null, "Nombre", ed, JOptionPane.QUESTION_MESSAGE);
                                            fechaCad = JOptionPane.showInputDialog(null, "Fecha de caducidad", ed, JOptionPane.QUESTION_MESSAGE);
                                            paisOri = JOptionPane.showInputDialog(null, "Pais de origen", ed, JOptionPane.QUESTION_MESSAGE);
                                            fecEnva = JOptionPane.showInputDialog(null, "Fecha de envasado", ed, JOptionPane.QUESTION_MESSAGE);
                                            numLote = JOptionPane.showInputDialog(null, "Numero de lote", ed, JOptionPane.QUESTION_MESSAGE);
                                            temp = Double.parseDouble(JOptionPane.showInputDialog(null, "Temperatura de mantenimiento recomendada", ed, JOptionPane.QUESTION_MESSAGE));
                                            double nit = Double.parseDouble(JOptionPane.showInputDialog(null, "% de nitrogeno", ed, JOptionPane.QUESTION_MESSAGE));
                                            double oxi = Double.parseDouble(JOptionPane.showInputDialog(null, "% de oxigeno", ed, JOptionPane.QUESTION_MESSAGE));
                                            double dio = Double.parseDouble(JOptionPane.showInputDialog(null, "% de dioxido de carbono", ed, JOptionPane.QUESTION_MESSAGE));
                                            //alm.agregarProducto(new PorAire(nit, oxi, dio, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                            salida.writeUnshared(new PorAire(nit, oxi, dio, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                            break;
                                        //Por agua
                                        case 1:
                                            nombre = JOptionPane.showInputDialog(null, "Nombre", ed, JOptionPane.QUESTION_MESSAGE);
                                            fechaCad = JOptionPane.showInputDialog(null, "Fecha de caducidad", ed, JOptionPane.QUESTION_MESSAGE);
                                            paisOri = JOptionPane.showInputDialog(null, "Pais de origen", ed, JOptionPane.QUESTION_MESSAGE);
                                            fecEnva = JOptionPane.showInputDialog(null, "Fecha de envasado", ed, JOptionPane.QUESTION_MESSAGE);
                                            numLote = JOptionPane.showInputDialog(null, "Numero de lote", ed, JOptionPane.QUESTION_MESSAGE);
                                            temp = Double.parseDouble(JOptionPane.showInputDialog(null, "Temperatura de mantenimiento recomendada", ed, JOptionPane.QUESTION_MESSAGE));
                                            double sali = Double.parseDouble(JOptionPane.showInputDialog(null, "Salinidad gramos/litro de agua", ed, JOptionPane.QUESTION_MESSAGE));
                                            //alm.agregarProducto(new PorAgua(sali, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                            salida.writeUnshared(new PorAgua(sali, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                            break;
                                        case 2:
                                            nombre = JOptionPane.showInputDialog(null, "Nombre", ed, JOptionPane.QUESTION_MESSAGE);
                                            fechaCad = JOptionPane.showInputDialog(null, "Fecha de caducidad", ed, JOptionPane.QUESTION_MESSAGE);
                                            paisOri = JOptionPane.showInputDialog(null, "Pais de origen", ed, JOptionPane.QUESTION_MESSAGE);
                                            fecEnva = JOptionPane.showInputDialog(null, "Fecha de envasado", ed, JOptionPane.QUESTION_MESSAGE);
                                            numLote = JOptionPane.showInputDialog(null, "Numero de lote", ed, JOptionPane.QUESTION_MESSAGE);
                                            temp = Double.parseDouble(JOptionPane.showInputDialog(null, "Temperatura de mantenimiento recomendada", ed, JOptionPane.QUESTION_MESSAGE));
                                            String met = JOptionPane.showInputDialog(null, "Metodo de congelacion", ed, JOptionPane.QUESTION_MESSAGE);
                                            int tiempo = Integer.parseInt(JOptionPane.showInputDialog(null, "Tiempo de exposicion al nitrogeno", ed, JOptionPane.QUESTION_MESSAGE));
                                            //alm.agregarProducto(new PorNitrogeno(met, tiempo, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                            salida.writeUnshared(new PorNitrogeno(met, tiempo, fecEnva, paisOri, temp, fechaCad, numLote, nombre));
                                            break;
                                    }
                                    break;
                            }
                            continuar = JOptionPane.showOptionDialog(null, "¿Desea ingresar otro producto?", "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        }
                        break;
                    //Vizualizar datos    
                    case 1:
                        String sal = "";
                        Producto pro;
                        try {
                            entrada = new ObjectInputStream(new FileInputStream("productos.dat"));

                            while (true) {
                                System.out.println("Ira");
                                pro = (Producto) entrada.readUnshared();
                                sal = pro.toString();
                                JOptionPane.showMessageDialog(null, sal, "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (ClassNotFoundException | IOException ex) {
                            if (sal.equals("")) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                }
            } while (opc != 2);

            /*for (int i = 0; i < alm.tam(); i++) {
                JOptionPane.showMessageDialog(null, alm.vizualizaProducto(i), "Salida de datos", JOptionPane.INFORMATION_MESSAGE);
            }*/
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }

        System.exit(0);
    }

}
