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
        App.getInstanse().start();
    }
}
