package lab2.app;

import lab2.logic.methods.Method;
import lab2.logic.methods.*;
import lombok.Getter;

public enum Methods {
    HALF_DIV(new HalfDivMethod(), "метод половинного деления"),
    SIMPLE_ITER(new SimpleIterMethod(), "метод простых итераций"),
    SECANT(new SecMethod(), "метод секущих");
    @Getter
    private final Method method;
    @Getter 
    private final String description;

    Methods(Method m, String d){
        method = m;
        description = d;
    }

    public static Methods choose(int i){
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
