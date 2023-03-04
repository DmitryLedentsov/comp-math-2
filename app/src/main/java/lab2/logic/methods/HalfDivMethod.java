package lab2.logic.methods;

import lab2.logic.Function;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor

public class HalfDivMethod {
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
    @Getter
    private int n;
    @Getter
    private List<double[]> table = new ArrayList<>();

    void step(){
        x = (a+b)/2;
        fA = function.call(a);
        fB = function.call(b);
        fX = function.call(x);
        mod = abs(a-b);
    }
    void save(){
        table.add(new double[]{a,b,x,fA,fB,fX,mod});
    }
    //a b x f(a) f(b) f(x) |a-b|
    public void solve(){
        step();

        n = 1;
        while(mod>accuracy /*&& abs(fX)>=accuracy*/){
            save();
            if(fA*fX>0){
                a = x;
            }else{
                b = x;
            }
            n++;
            step();
        }
        save();
    }

    public String getPrintableSolution(){
        String s = "";
        int count = 0;
        for(double[] d: table){
            s += String.format("%d %.5f %.5f %.5f %.5f %.5f %.5f %.5f %n", count, d[0], d[1], d[2], d[3], d[4], d[5], d[6]);
            count++;
            
        }
        return s;
    }


}
