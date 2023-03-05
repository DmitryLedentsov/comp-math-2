package lab2.utils;

public class MathUtils {
    public static double round(double d, int p){
        double n = Math.pow(10,p);
        return Math.round(d*n)/n;
    }
}
