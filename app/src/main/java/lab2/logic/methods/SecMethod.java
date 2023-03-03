package lab2.logic.methods;

import lab2.logic.Function;
import lombok.Getter;
import lombok.Setter;
import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;
public class SecMethod {
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
    void solve(){
        x=0; x_prev=a; x_next=b;
        n = 1;
        while(abs(x-x_prev)>accuracy && abs(Fx)>accuracy){
            
        }
    }


}
