package lab2.plot;


import java.awt.Color;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.util.PaintAlpha;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import lab2.logic.BinaryFunction;
import lab2.logic.Function;
import lab2.logic.NonlinearSystem;
import lombok.AllArgsConstructor;
import lombok.Data;




public class Graph extends JFrame {
    public static final double DEFAULT_STEP = 0.05;
    public static final double SYSTEM_STEP = 0.001;
    public static final double SEARCH_ACCURACY = 1e-4;
    public Graph(String title) {
        super(title);
    }
    JFreeChart chart;

    private void initChart(XYDataset dataset){
        chart = ChartFactory.createXYLineChart(
                getTitle(),
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        /*NumberAxis domain = new NumberAxis("X");
        NumberAxis range = new NumberAxis("Y");
        XYSplineRenderer r = new XYSplineRenderer(1);
        XYPlot xyplot = new XYPlot(dataset, domain, range, r);
         chart = new JFreeChart(xyplot);*/

        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(false);
        panel.setDomainZoomable(true);
        //panel.setRangeZoomable(true);
        //panel.setMouseWheelEnabled(true);
        panel.setDisplayToolTips(true);
        chart.setElementHinting(true);//
        
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
    }
    public void graph(double a, double b, Function... functions) {
        XYDataset dataset = generateDataset(a, b, DEFAULT_STEP, functions);
        initChart(dataset);
    }

    private XYDataset generateDataset(double from, double to, double step, Function... functions) {
        XYSeriesCollection dataset = new XYSeriesCollection();
    
        for (Function f: functions) {
            XYSeries series = new XYSeries(f.hashCode());
            for (double x = from; x < to + step; x += step) {
                series.add(x, f.call(x));
            }
            dataset.addSeries(series);
        }
        return dataset;
    }

    public void system(double from, double to, NonlinearSystem s){
        system(from, to, s.getFirst(), s.getSecond());
    }
    public void system(double from, double to, BinaryFunction f1, BinaryFunction f2) {
        XYSeriesCollection dataset = new XYSeriesCollection();
   
        
        BinaryFunction[] functions = new BinaryFunction[]{f1,f2};
        
        for(BinaryFunction f: functions){
            XYSeries series = new XYSeries(f.hashCode());
            List<Point> low = new LinkedList<>();
            Point start= null;
            for (double x=from; x<to; x+=SYSTEM_STEP)
                for (double y=from;y<to;y+=SYSTEM_STEP)
                    if (Math.abs(f.call(x, y))<=SEARCH_ACCURACY){
                        if(start == null){
                            start = new Point(x,y);
                        }
                        if(y>start.y)
                            series.add(x,y);
                        else
                            low.add(new Point(x, y));
                    }
            dataset.addSeries(series);

            series = new XYSeries(f.hashCode()+1);
            for(Point p: low){
                series.add(p.x,p.y);
            }

            dataset.addSeries(series);
            
        }
        initChart(dataset);
        XYPlot plot = chart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesPaint(3, Color.BLUE);
       
        
            
    }
    @Data
    @AllArgsConstructor
    static class Point{
        double x,y;
    }

    public void close(){
        setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object
    }
}