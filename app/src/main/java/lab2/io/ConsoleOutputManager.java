package lab2.io;

public class ConsoleOutputManager  extends OutputManagerImpl implements OutputManager{
    public ConsoleOutputManager(){
        super(System.out);
    }
}
