package lab2.exceptions;

public class DivergeException extends IllegalArgumentException{
    public DivergeException(){
        super("расходится");
    }
}
