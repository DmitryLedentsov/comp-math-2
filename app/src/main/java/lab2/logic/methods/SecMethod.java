package lab2.logic.methods;

import lab2.logic.Function;
import lombok.Getter;
import lombok.Setter;
import static java.lang.Math.*;
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
    private double x,x_prev, x_next;
    void solve(){
        x=0; x_prev=a; x_next=b;
        int count = 0;
        while(abs(x-x_prev)>accuracy && abs(Fx)>accuracy){
            
        }
    }


}
