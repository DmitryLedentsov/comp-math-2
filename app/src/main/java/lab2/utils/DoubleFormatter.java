package lab2.utils;

public class DoubleFormatter {
    static final int DECIMAL_PLACES = 2;
    static final double k = Math.pow(10, DECIMAL_PLACES);
    public static boolean isInt(double d){
        return d == (int) d;
    }
    public static String format(double d) {
        if(isInt(d)){
            return String.format("%.0f",d);
        }
        d = Math.round(d*k)/k;
        return String.format("%."+DECIMAL_PLACES+"f",d);
    }
    public static String format(double[] a){
        int count = 0;
        StringBuilder s = new StringBuilder(String.format(" %1$03d|", count));
        for (int i = 0; i < a.length; i++) {
            s.append(String.format("%1$8.3f | ", a[i]));
        }
        s.append("\n");
        return s.toString();
    }
    /*
    public static String format(double d, int len) {
        if(isInt(d)){
            return String.format("%.0f",d);
        }
        return String.format("%."+len+"f",d);
    }*/
}
