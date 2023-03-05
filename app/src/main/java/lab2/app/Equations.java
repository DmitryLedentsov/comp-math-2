package lab2.app;

import lab2.logic.Function;
import lombok.Getter;
import static java.lang.Math.*;
/*
0 - x^3 + 2.28x^2 - 1.934x - 3.907
1 - x^2 - 3x - 2
2 - sin(x) - cos(x) + 0.2x
3 - x^3 - x + 4
 */
public enum Equations {
    FIRST(x->pow(x,3)+2.28*pow(x,2)-1.934*x-3.907, "x^3 + 2.28x^2 - 1.934x - 3.907"),
    SECOND(x-> pow(x,2)-3*x-2, "x^2 - 3x - 2"),
    THIRD(x->sin(x)-cos(x)+0.2*x, "sin(x) - cos(x) + 0.2x"),
    FORTH(x->pow(x,3)-x+4, "x^3 - x + 4");
    
   

    @Getter
    private final Function function;
    @Getter
    private final String  description;

    Equations(Function f, String d){
        function = f;
        description = d;
    }

    public static Equations choose(int i){
        if(i>values().length) throw new IllegalArgumentException("неправильный номер");
        return values()[i];
    }
    public static String getAll(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values().length; i++){
            sb.append(i).append(") ").append(values()[i].getDescription()).append("\n");
        }
        return sb.toString();
    }
}
