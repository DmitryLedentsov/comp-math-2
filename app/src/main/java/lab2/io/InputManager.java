package lab2.io;

public interface InputManager extends AutoCloseable{

    public String readLine();
    public int readOptions(Integer... opts);
    public double[] readInterval();
    public double readAccuracy();
   // public LinearSystem readLinearSystem();
    
    public String readPath();

}
