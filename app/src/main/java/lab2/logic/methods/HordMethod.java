package lab2.logic.methods;

import java.util.ArrayList;
import java.util.List;

import lab2.logic.Function;
import lombok.Getter;
import lombok.Setter;
import static lab2.utils.MathUtils.*;
import static java.lang.Math.*;
public class HordMethod implements Method{
    @Getter @Setter
    private Function function;
    @Getter @Setter
    private double accuracy;
    @Getter @Setter
    private double a;
    @Getter @Setter
    private double b;

    @Getter
    private double x;
    private double fA;
    @Getter
    private double fX;
    private double fB;
    private double mod;
    private double x_prev;
    @Getter
    private int n;
    @Getter
    private List<double[]> table = new ArrayList<>();


    void rnd(){
        x = round(x, 3);
        fA = round(fA, 3);
        fB = round(fB, 3);
        fX = round(fX, 3);
        mod = round(mod, 3);
    }
    void step(){
        x_prev =x;
        x = (a*f(b)-b*f(a))/(f(b)-f(a));
        fA = f(a);
        fB = f(b);
        fX = f(x);
        mod = abs(x-x_prev);
        //rnd();
        //rnd(); //TODO: remove
    }
    double f(double x){
        return function.call(x);
    }
    void save(){
        table.add(new double[]{a,b,x,fA,fB,fX,mod});
    }
    //a b x f(a) f(b) f(x) |a-b|
    public void solve(){
        step();

        n = 1;
        while(abs(x-x_prev)>accuracy /*&& abs(fX)>=accuracy*/){
            save();
            if(fA*fX<0){
                b=x;
            }else{
                a = x;
            }
            n++;
            step();
        }
        save();
    }

    public String getSolutionWay(){
        String s = "";
        int count = 0;
        for(double[] d: table){
            s += String.format("%d %.3f %.3f %.3f %.3f %.3f %.3f %.3f %n", count, d[0], d[1], d[2], d[3], d[4], d[5], d[6]);
            count++;
            
        }
        return s;
    }
}
