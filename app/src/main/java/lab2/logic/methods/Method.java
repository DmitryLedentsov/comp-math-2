package lab2.logic.methods;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lab2.logic.Function;

public interface Method {
    final static int MAX_ITERATIONS = 1000;
    void setA(double a);
    void setB(double b);
    void setAccuracy(double accuracy);
    void setFunction(Function function);
    void solve();
    double getX();
    int getN();
    double getFX();

    @Retention(RetentionPolicy.CLASS)
    @interface Info  {
        String name() default "";
        String description() default "";
    }

    public default String formatSolution(){
        String s = "число итераций: " + getN() + "\n";
        s+= "корень: " + getX() + '\n';
        s+= "значение функции в корне: " + getFX() + '\n';
        return s;
    }
    public default String getSolutionWay(){
        return "";
    }
}
