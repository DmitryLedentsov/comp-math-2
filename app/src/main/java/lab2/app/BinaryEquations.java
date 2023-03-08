package lab2.app;

import lab2.logic.BinaryFunction;
import lombok.Getter;
import static java.lang.Math.*;
/*
1 - x^2 + y^2 - 4
2 - x^3 + y - 1
3 - x^2 - y - 3
 */
public enum BinaryEquations {
    FIRST((x,y)->pow(x, 2) + pow(y,2) - 4, "x^2 + y^2 - 4"),
    SECOND((x,y)->pow(x,3)+y-1, "x^3 + y - 1"),
    THIRD((x,y)->pow(x,2)-y-3, "x^2 - y - 3"),
    FIFTH((x,y)->pow(pow(x,2)+pow(y,2)-1,3) - pow(x,2)*pow(y,3), "сердечко");
    @Getter
    private final BinaryFunction function;
    @Getter
    private final String  description;

    BinaryEquations(BinaryFunction f, String d){
        function = f;
        description = d;
    }

    public static BinaryEquations choose(int i){
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
