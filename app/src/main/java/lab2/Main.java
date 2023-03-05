package lab2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import lab2.app.App;
import lab2.logic.Function;
import lab2.logic.NonlinearSystem;
import lab2.logic.methods.HalfDivMethod;
import lab2.logic.methods.HordMethod;
import lab2.logic.methods.NewtonMethod;
import lab2.logic.methods.SecMethod;
import lab2.logic.methods.SimpleIterMethod;
import lab2.plot.Graph;
import lombok.var;

import static java.lang.Math.*;

import java.util.Arrays;
import java.util.Vector;




public class Main {
    
    public static void main(String[] args) {
        //Graph plt = new Graph("aaaa");
        //plt.graph(1, 10, Math::sin);
        
        //App.getInstanse().start();
        HalfDivMethod divm = new HalfDivMethod();
        divm.setAccuracy(0.01);
        //divm.setFunction(x-> pow(x,3)+2.28*pow(x,2)-1.934*x-3.907);

        //divm.setA(1.3);
        //divm.setB(1.4);
        Function f = x->4.45*pow(x,3)+7.81*pow(x,2)-9.62*x-8.17;
        //x->pow(x,3)-x+4
        divm.setFunction(f);
        divm.setA(1.2);
        divm.setB(1.3);
        divm.solve();
        System.out.println(divm.getSolutionWay());
        System.out.println(divm.getX());
        //System.out.println(divm.getN());
        //System.out.println(divm.getFX());


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
        iterm.setA(-0.7);
        iterm.setB(-0.6);
        iterm.setFunction(f);

        iterm.solve();
        System.out.println(iterm.getSolutionWay());
        System.out.println(iterm.getX());
        System.out.println("\n\n");

        HordMethod secm = new HordMethod();
        secm.setAccuracy(0.01);
        secm.setA(-2.4);
        secm.setB(-2.3);
        secm.setFunction(f);
        secm.solve();
        System.out.println(secm.getSolutionWay());
        System.out.println(secm.getX());

        NewtonMethod nm = new NewtonMethod();
        nm.setAccuracy(0.01);
        nm.setX0(1);
        nm.setY0(2);
        nm.setSystem(NonlinearSystem.of((x,y)->pow(x,2)+pow(y,2)-4, (x,y)->y-3*pow(x,2)));
        nm.solve();
        //System.out.println(nm.getSolution().toString());
        //System.out.println(nm.getErrors().toString());
        //new Graph("ХУЙ").system(-10, 10, (x,y)->pow(x,2)+pow(y,2)-4, (x,y)->y-3*pow(x,2));
        //new Graph("bbb").graph(-10, 10, x->x*x);


        App.getInstanse().start();
    }
}
