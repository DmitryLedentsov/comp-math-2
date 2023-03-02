package lab2.experimental;

public class MetodHord {
 
    public static void main(String[] args) {
        double x0 = -2;
        double x1 = -1.5;
        double e = 0.01;
        double x = method_chord(x0, x1, e);
        System.out.println(x);
    }
    
    public static double method_chord (double x_prev, double x_curr, double e) {
        double x_next = 0;
        double tmp;
        do{
            System.out.printf("%-10.6f %-10.6f %-10.6f %-10.6f %-10.6f\n", x_prev,x_curr,x_next,f(x_next), Math.abs(x_next-x_curr));
            tmp = x_next;
            x_next = x_curr - f(x_curr) * (x_curr-x_prev) / (f(x_curr) - f(x_prev));
            x_prev = x_curr;
            x_curr = tmp;
            
        } while (Math.abs(x_next - x_curr) > e && f(x_curr)>e);
        return x_next;
    }
    
    public static double f (double x){
        return Math.pow(x,3)-x+4;
    }
}