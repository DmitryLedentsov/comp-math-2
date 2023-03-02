package lab2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import lab2.app.App;
import lab2.logic.methods.HalfDivMethod;
import lab2.logic.methods.SimpleIterMethod;
import lab2.plot.Graph;
import lombok.var;

import static java.lang.Math.*;



public class Main {
    
    public static void main(String[] args) {
        //Graph plt = new Graph("aaaa");
        //plt.graph(1, 10, Math::sin);
        
        //App.getInstanse().start();
        HalfDivMethod divm = new HalfDivMethod();
        divm.setAccuracy(0.01);
        divm.setFunction(x-> pow(x,3)+2.28*pow(x,2)-1.934*x-3.907);
        divm.setA(1.3);
        divm.setB(1.4);
        divm.solve();
        System.out.println(divm.getPrintableSolution());
        System.out.println(divm.getX());
        System.out.println(divm.getN());
        System.out.println(divm.getFX());


        System.out.println();

        //SimpleIterMethod iterm = new SimpleIterMethod();
        //iterm.setAccuracy(0.01);
        //iterm.setFunction(x->1.8*pow(x, 3)-2.47*pow(x,2)-5.53*x+1.539);
        //iterm.setA(0);
        //iterm.setB(1);
        //iterm.solve();
        //System.out.println(iterm.getPrintableSolution());

        SimpleIterMethod iterm = new SimpleIterMethod();
        iterm.setAccuracy(0.01);
        iterm.setA(-2);
        iterm.setB(0);
        iterm.setFunction(x->pow(x,3)-x+4);

        iterm.solve();
        System.out.println(iterm.getPrintableSolution());
        
    }
}
