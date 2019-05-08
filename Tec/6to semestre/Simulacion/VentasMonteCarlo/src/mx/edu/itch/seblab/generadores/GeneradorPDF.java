package mx.edu.itch.seblab.generadores;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import mx.edu.itch.seblab.clases.Escenario;
import mx.edu.itch.seblab.clases.Negocio;
import com.itextpdf.layout.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GeneradorPDF {

    private Negocio negocio;
    private ArrayList<Escenario> escenarios;

    public GeneradorPDF(Negocio negocio,int numEscenarios) {
        this.negocio = negocio;
        this.escenarios = new ArrayList<>();

        for(int i =0;i<numEscenarios; i++) this.escenarios.add(new Escenario(negocio));
    }

    public void generarPDF() throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("src/mx/edu/itch/seblab/archivos/resultado.pdf"));
        Document document = new Document(pdf, PageSize.A3);
        document.setMargins(30, 30, 30, 30);

        //Tablas de negocio
        document.add(new Paragraph("Negocio de "+negocio.getProducto()).setBold());
        document.add(new Paragraph("\n Tabla de probabilidades \n").setBold());
        document.add(this.darTablaHistoricos());
        document.add(new Paragraph("Total de ventas reales en el periodo: "+negocio.getTotalVentaPeriodo()));
        document.add(new Paragraph("Costos y precios").setBold());
        document.add(this.darTablaNegocio());

        //Tablas escenarios
        document.add(new Paragraph("\n Escenarios \n").setBold());

        int cont = 1;
        for(Escenario esc : escenarios){
            document.add(new Paragraph("Escenario #"+cont));
            document.add(this.darTablaEscenario(esc));
            cont++;
        }

        //Tabla ventas estadisticas
        document.add(new Paragraph("\n Variables estadisticas \n").setBold());
        document.add(this.darTablaVariablesEstadisticas());
        document.add(new Paragraph("*Si en moda el resultado es 0 (cero), significa que no hay moda en ese escenario."));

        document.close();

        Desktop.getDesktop().open(new File("src/mx/edu/itch/seblab/archivos/resultado.pdf"));
    }

    private Table darTablaVariablesEstadisticas() {
        Table tabla = new Table(new float[]{15,15,15,15});
        tabla.setWidthPercent(60);

        tabla.addHeaderCell(new Cell().add("Maximo beneficio"));
        tabla.addHeaderCell(new Cell().add("Minimo beneficio"));
        tabla.addHeaderCell(new Cell().add("Media muestral"));
        tabla.addHeaderCell(new Cell().add("Moda"));

        for(Escenario esc : escenarios){
            tabla.addCell(""+esc.getMaximoBeneficio());
            tabla.addCell(""+esc.getMinimoBeneficio());
            tabla.addCell(""+esc.getMediaMuestral());
            tabla.addCell(""+esc.getModa());
        }

        return tabla;
    }

    private Table darTablaEscenario(Escenario esc){
        double[][] tab = esc.darTablaEscenario();
        int periodo = negocio.getPeriodo();
        Table tabla = new Table(new float[]{15,15,15,15,15});
        tabla.setWidthPercent(60);

        tabla.addHeaderCell(new Cell().add("Dia"));
        tabla.addHeaderCell(new Cell().add("Pseudoaleatorio"));
        tabla.addHeaderCell(new Cell().add("Ventas"));
        tabla.addHeaderCell(new Cell().add("Ganancia por producto"));
        tabla.addHeaderCell(new Cell().add("Ganancia neta"));

        for(int i=0;i<periodo;i++){
            for(int j=0;j<5;j++){
                tabla.addCell(""+tab[i][j]);
            }
        }


        return tabla;
    }

    private Table darTablaHistoricos(){
        double[][] tablaNegocio = negocio.calcularProbabilides();
        int periodo = negocio.getPeriodo();

        Table datosHistoricos = new Table(new float[]{15,15,15,15,15,15});
        datosHistoricos.setWidthPercent(90);

        datosHistoricos.addHeaderCell(new Cell().add("Dia"));
        datosHistoricos.addHeaderCell(new Cell().add("Numero ventas reales del dia"));
        datosHistoricos.addHeaderCell(new Cell().add("Probabilidad"));
        datosHistoricos.addHeaderCell(new Cell().add("Probabilidad acumulada"));
        datosHistoricos.addHeaderCell(new Cell().add("Limite inferior"));
        datosHistoricos.addHeaderCell(new Cell().add("Limite superior"));

        for (int filas = 0; filas < periodo; filas++) {
            for (int cols = 0; cols < 6; cols++) {
                datosHistoricos.addCell(""+tablaNegocio[filas][cols]);
            }
        }

        return datosHistoricos;
    }

    private Table darTablaNegocio(){
        Table datosNegocio = new Table(new float[]{15,15});
        datosNegocio.setWidthPercent(60);

        datosNegocio.addHeaderCell(new Cell().add("Concepto"));
        datosNegocio.addHeaderCell(new Cell().add("Monto ($)"));

        datosNegocio.addCell("Renta");
        datosNegocio.addCell(""+negocio.getRenta());
        datosNegocio.addCell("Servicio");
        datosNegocio.addCell(""+negocio.getServicios());
        datosNegocio.addCell("Salario administrativos");
        datosNegocio.addCell(""+negocio.getSalarioAdministrativos());
        datosNegocio.addCell("Salario ventas");
        datosNegocio.addCell(""+negocio.getSalarioVentas());
        datosNegocio.addCell("Costo produccion unidad");
        datosNegocio.addCell(""+negocio.getCostoProduccionUnidad());
        datosNegocio.addCell("Precio venta unidad");
        datosNegocio.addCell(""+negocio.getPrecioVentaUnidad());
        datosNegocio.addCell("Gasto produccion periodo");
        datosNegocio.addCell(""+negocio.getGastoProPeriodo());
        datosNegocio.addCell("Gasto produccion diario");
        datosNegocio.addCell(""+negocio.getGastoProDiario());

        return datosNegocio;
    }
}
