package lab2.io;

import lab2.app.Equations;
import lab2.app.Methods;
import lab2.logic.methods.Method;

public interface InputManager extends AutoCloseable{

    public String readLine();
    public int readOptions(Integer... opts);
    public double[] readInterval();
    public double readAccuracy();
   // public LinearSystem readLinearSystem();
    
    public String readPath();
    public int readCommand();
    public Equations readEquation();
    public Methods readMethod();
    public int readFileOrConsole();

}
