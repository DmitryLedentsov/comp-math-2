package lab2.exceptions;

public class ZeroDeterminantException extends IllegalArgumentException{
    public ZeroDeterminantException() {
        super("дискриминант равен нулю");
    }
}
