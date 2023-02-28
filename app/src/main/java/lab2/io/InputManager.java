package lab2.io;

public interface InputManager extends AutoCloseable{

    public String readLine();
    public int readDimension();
   // public LinearSystem readLinearSystem();
    public int readCommand();
    public String readPath();

}
