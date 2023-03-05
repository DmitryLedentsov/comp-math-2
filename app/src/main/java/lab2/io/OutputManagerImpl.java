package lab2.io;

import java.io.PrintStream;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OutputManagerImpl implements OutputManager{
    protected PrintStream out;
    public OutputManagerImpl(PrintStream o){
        init(o);
    }

    void init(PrintStream o){
        out = o;
    }

    public void print(String message) {
        out.println(message);
    }
    public void add(String message) {
        out.print(message);
    }
    public void error(String message) {
        out.println("ОШИБКА: " + message);
    }
}
