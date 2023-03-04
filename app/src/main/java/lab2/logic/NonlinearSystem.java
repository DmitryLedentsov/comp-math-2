package lab2.logic;

import java.util.List;

import lombok.Getter;

public class NonlinearSystem {
    @Getter
    private BinaryFunction first;
    @Getter
    private BinaryFunction second;
    public int getDimension(){
        return 2;
    }

    public NonlinearSystem(BinaryFunction f1, BinaryFunction f2){
        first = f1;
        second = f2;
    }
    public static NonlinearSystem of(BinaryFunction f1, BinaryFunction f2){
        return new NonlinearSystem(f1, f2);
    }
}
