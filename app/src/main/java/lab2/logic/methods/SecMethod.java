package lab2.logic.methods;

import lab2.exceptions.IterationLimitExceedException;
import lab2.logic.Function;
import lombok.Getter;
import lombok.Setter;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;
public class SecMethod implements Method{
    @Getter @Setter
    private Function function;
    @Getter @Setter
    private double accuracy;
    @Getter @Setter
    private double a;
    @Getter @Setter
    private double b;
    @Getter 
    double abs;
    double Fx;
    @Getter int n;
    private double x,x_prev, x_next;
    @Getter
    private List<double[]> table = new ArrayList<>();

    private double fXnext;
    void save(){
        table.add(new double[]{x_prev,x,x_next,fXnext,abs});
    }
    double f(double x){
        return function.call(x);
    }
    void step(){
        x_next = x - f(x) * (x-x_prev) / (f(x) - f(x_prev));
        abs = abs(x_next-x);
        fXnext=f(x);
    }
    public void solve(){
        x=0; x_prev=a; x=b;
        n = 1;
        double tmp=0;
        step();
        save();
  
        while(abs(x_next-x)>accuracy){
            tmp=x_next;
            
            x_prev=x;
            x=tmp;
            step();
            save();
            n+=1;
            if(n>MAX_ITERATIONS) throw new IterationLimitExceedException();
        }
        
        x=x_next;
    }

    public String getSolutionWay(){
        String s = "";
        for(double[] row: table){
            s += String.format("%-10.6f %-10.6f %-10.6f %-10.6f %-10.6f\n", row[0], row[1], row[2], row[3],row[4]);
        }
        return s;
    }
    public double getX(){
        return x_next;
    }
    public double getFX(){
        return function.call(getX());
    }


}
