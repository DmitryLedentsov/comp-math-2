package lab2.logic;

@FunctionalInterface
public interface Function {

    double call(double x);


    public static class Utils{
        public static final double DELTA = 1e-6;
        
        public static double derivativeAtPoint(Function f, int n, double x) {
            if (n <= 0) throw new IllegalArgumentException("n should be at least 1");
            if (n == 1) return (f.call(x + DELTA) - f.call(x)) / DELTA;
            return (derivativeAtPoint(f, n - 1, x + DELTA) - derivativeAtPoint(f, n - 1, x)) / DELTA;
        }
        public static double derivativeAtPoint(Function f, double x){
            return (f.call(x + DELTA) - f.call(x)) / DELTA;
        }
        
        public static Function phi(Function f, double x0) {
            return x -> (x + (-1 / derivativeAtPoint(f, x0)) * f.call(x));
           // return x -> (x + (-1 / derivativeAtPoint(f, x)) * f.call(x));
        }
        public static boolean checkFunctionHasRoot(Function f, double a, double b){
            return (f.call(a)*f.call(b)<0);
        }
       
    }
}
