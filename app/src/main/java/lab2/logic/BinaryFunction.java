package lab2.logic;
@FunctionalInterface

public interface BinaryFunction {
    public static final double DELTA = 1e-6;
    double call(double x, double y);
    public static class Utils{
        public static BinaryFunction derivativeX(BinaryFunction f){
            return (x,y)->(f.call(x+DELTA,y)-f.call(x,y))/DELTA;
        }
        public static BinaryFunction derivativeY(BinaryFunction f){
            return (x,y)->(f.call(x,y+DELTA)-f.call(x,y))/DELTA;
        }
    }
}
