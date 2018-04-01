import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class Grafica {

    private ChartPanel grafica;
    private XYSeries restriccion1;
    private XYSeries restriccion2;
    private XYSeries restriccion3;
    private XYSeries puntoMax;
    private XYSeriesCollection dataset;
    private double []coordenadaMax = new double[2];
    double max = 0;

    int x1_1;
    int x2_1;
    int x1_2;
    int x2_2;
    int x1_3;
    int x2_3;
    int x1_fun;
    int x2_fun;
    int b1;
    int b2;
    int b3;
    int b4;

    public Grafica(int x1_1,int x2_1, int x1_2,int x2_2, int x1_3,int x2_3, int x1_fun, int x2_fun, int b1, int b2, int b3, int b4){

        this.x1_1=x1_1;
        this.x2_1=x2_1;
        this.x1_2=x1_2;
        this.x2_2=x2_2;
        this.x1_3=x1_3;
        this.x2_3=x2_3;

        this.x1_fun=x1_fun;
        this.x2_fun=x2_fun;

        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;

        restriccion1 = new XYSeries("Restricción 1");
        dibujarRestriccion1(x1_1,x2_1,b1);

        restriccion2 = new XYSeries("Restriccion 2");
        dibujarRestriccion2(x1_2,x2_2,b2);

        restriccion3 = new XYSeries("Restriccion 3");
        dibujarRestriccion3(x1_3,x2_3,b3);

        puntoMax = new XYSeries("Punto Maximo");
        encontrarPuntoMax(encontrarPuntoConvergente(x1_1,x2_1,x1_2,x2_2,b1,b2));
        encontrarPuntoMax(encontrarPuntoConvergente(x1_1,x2_1,x1_3,x2_3,b1,b3));
        encontrarPuntoMax(encontrarPuntoConvergente(x1_2,x2_2,x1_3,x2_3,b2,b3));
        puntoMax.add(coordenadaMax[0],coordenadaMax[1]);

        dataset = new XYSeriesCollection();
        dataset.addSeries(restriccion1);
        dataset.addSeries(restriccion2);
        dataset.addSeries(restriccion3);
        dataset.addSeries(puntoMax);

        JFreeChart xyLineChart = ChartFactory.createXYLineChart(
                "",
                "x1",
                "x2",
                dataset,
                PlotOrientation.VERTICAL,true,true,false);

        XYPlot plot = xyLineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesPaint(3, Color.BLACK);

        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(4.0f));

        plot.setRenderer(renderer);

        grafica = new ChartPanel(xyLineChart);

        System.out.println(max);
    }

    private void encontrarPuntoMax(double[] prueba){

        double aux = (x1_fun*prueba[0])+(x2_fun*prueba[1]);

        if(aux > max){
            max = aux;
            coordenadaMax = prueba;
        }

        System.out.println(max);
        System.out.println(prueba[0]+"    "+prueba[1]);

    }

    private double[] encontrarPuntoConvergente(int x11,int x21,int x12,int x22,int b1,int b2){
        double dS = (x11*x22)-(x12*x21);
        double dX1 = (b1*x22)-(b2*x21);
        double dX2 = (x11*b2)-(x12*b1);

        double[] resultado = new double[2];
        resultado[0] = dX1/dS;
        resultado[1] = dX2/dS;

        return resultado;
    }

    public double despejar(int x,int b){
        if (x==0){
            return 0;
        }else {
            return b/x;
        }
    }

    public ChartPanel getGrafica(){
        return grafica;
    }

    private void dibujarRestriccion1(int x1,int x2,int b){
        double x = despejar(x2,b);
        double y = despejar(x1,b);

        if(x == 0 && y == 0){
            restriccion1.add(0,0);
        }else if (x == 0){
            restriccion1.add(y,10);
            restriccion1.add(y,0);
        }else if(y == 0){
            restriccion1.add(0,x);
            restriccion1.add(10,x);
        }else{
            restriccion1.add(0,x);
            restriccion1.add(y,0);
        }
    }

    private void dibujarRestriccion2(int x1,int x2,int b){
        double x = despejar(x2,b);
        double y = despejar(x1,b);

        if(x == 0.0 && y == 0.0){
            restriccion2.add(0,0);
        }else if (x == 0.0){
            restriccion2.add(y,10);
            restriccion2.add(y,0);
        }else if(y == 0.0){
            restriccion2.add(0,x);
            restriccion2.add(10,x);
        }else{
            restriccion2.add(0,x);
            restriccion2.add(y,0);
        }
    }

    private void dibujarRestriccion3(int x1,int x2,int b){
        double x = despejar(x2,b);
        double y = despejar(x1,b);

        if(x == 0 && y == 0){
            restriccion3.add(0,0);
        }else if (x == 0){
            restriccion3.add(y,10);
            restriccion3.add(y,0);
        }else if(y == 0){
            restriccion3.add(0,x);
            restriccion3.add(10,x);
        }else{
            restriccion3.add(0,x);
            restriccion3.add(y,0);
        }
    }

}
