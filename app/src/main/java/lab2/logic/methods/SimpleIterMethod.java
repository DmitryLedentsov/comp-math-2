package lab2.logic.methods;

import lab2.logic.Function;
import lab2.logic.methods.Method.Status;
import lombok.Getter;
import lombok.Setter;
import static lab2.logic.Function.Utils.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
public class SimpleIterMethod {
    @Setter
    Function function;
    @Setter
    double a;
    @Setter
    double b;
    @Setter
    double accuracy;
    @Getter @Setter 
    private Status status;
    @Getter
    private List<double[]> table = new ArrayList<>();
    double x0;
    double xk;
    double xk1;
    double fXk;
    double fXk1;
    double mod;
    Function phi;

    @Getter
    private int n;
    public static final double MAX_ITERATIONS = 10000;

    void save(){
        table.add(new double[]{xk, xk1, fXk1, mod});
    }
    void  step(){
        
        xk1 = phi.call(xk);
        fXk = function.call(xk);
        fXk1 = function.call(xk1);
        mod = abs(xk1-xk);
    }
    public void solve(){
        n=0;
        
        double derA=derivativeAtPoint(function, a),
        derB=derivativeAtPoint(function, b);
        x0 = derA>derB?a:b;
        double lambda = -1/max(derA, derB);
        phi = x->x+lambda*function.call(x);
        xk = x0;
        step(); 
        save();
        while(abs(xk1-xk)>=accuracy){
            //if (Math.abs(derivativeAtPoint(phi, xk)) >= 1) throw new IllegalArgumentException("f'(xn) > 1 => cannot converge");
            xk = xk1;
            step();
            save();
            n++;
        }
        xk=xk1;
        step();
        save();
        
         
    }
    public String getPrintableSolution(){
        String s = "";
        for(double[] row: table){
            s += String.format("%-10.6f %-10.6f %-10.6f %-10.6f\n", row[0], row[1], row[2], row[3]);
        }
        return s;
    }


}
