package lab2.io;

public interface OutputManager extends AutoCloseable{
    public default void print(String message){
        add(message);
        add("\n");
    };
    public void add(String message);
    public default void error(String message){
        add("ОШИБКА: \n");
        add(message);
        add("\n");
    }
    public default void close(){};
}
