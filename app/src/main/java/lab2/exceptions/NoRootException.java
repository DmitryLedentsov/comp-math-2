package lab2.exceptions;

public class NoRootException  extends IllegalArgumentException{
    public NoRootException(){
        super("не удалось найти единственный корень");
    }
}
