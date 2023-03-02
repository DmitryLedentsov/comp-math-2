package lab2.app;

import lab2.logic.Function;
import lombok.Getter;
import lombok.Setter;

public enum Equations {
    FIRST(x->x,"x"), SECOND(x->2*x, "2x");
   

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
            sb.append(i+1).append(") ").append(values()[i].getDescription()).append("\n");
        }
        return sb.toString();
    }
}
