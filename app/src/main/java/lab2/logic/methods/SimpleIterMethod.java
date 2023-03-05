package lab2.logic.methods;

import lab2.exceptions.DivergeException;
import lab2.exceptions.IterationLimitExceedException;
import lab2.logic.Function;

import lombok.Getter;
import lombok.Setter;
import static lab2.logic.Function.Utils.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static lab2.utils.MathUtils.*;
public class SimpleIterMethod implements Method{
    @Setter
    Function function;
    @Setter
    double a;
    @Setter
    double b;
    @Setter
    double accuracy;

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
        //rnd();
    }
    void rnd(){
        xk1 = round(xk1, 3);
        fXk = round(fXk, 3);
        fXk1 = round(fXk1, 3);
        mod = round(mod,3);
    }
    public void solve(){
        n=0;
        
        double derA=derivativeAtPoint(function, a),
        derB=derivativeAtPoint(function, b);

       
        x0 = derA>derB?a:b;
        double lambda = -1/max(derA, derB);
        phi = x->x+lambda*function.call(x);

        if(abs(derivativeAtPoint(phi, x0))>=1) throw new DivergeException();
        xk = x0;
        step(); 
        save();
        while(abs(xk1-xk)>=accuracy){
            //if (Math.abs(derivativeAtPoint(phi, xk)) >= 1) throw new IllegalArgumentException("f'(xn) > 1 => cannot converge");
            xk = xk1;
            step();
            save();
            n++;

            if(n>MAX_ITERATIONS) throw new IterationLimitExceedException();
        }
        xk=xk1;
        //step();
        //save(); TODO: check if this is needed
        
         
    }
    public double getX(){
        return xk;
    }
    public String getSolutionWay(){
        String s = "";
        int count = 0;
        for(double[] row: table){
            s += String.format("%d %.3f %.3f %.3f %.3f\n", count, row[0], row[1], row[2], row[3]);
            count++;
        }
        return s;
    }

    public double getFX(){
        return function.call(getX());
    }


}
