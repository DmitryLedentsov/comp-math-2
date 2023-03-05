package lab2.exceptions;

public class IterationLimitExceedException extends RuntimeException{
    public IterationLimitExceedException(){
        super("превышено максимально допустимое количество итераций");
    }
}
