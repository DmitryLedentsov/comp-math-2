package lab2.io;

public class MultipleOutputManager implements OutputManager{
    private OutputManager[] managers;
    public MultipleOutputManager(OutputManager... m){
        managers = m;
    }
    public void add(String m){
        for(OutputManager o:managers){
            o.add(m);
        }
    }
    public void close(){
        for(OutputManager o:managers){
            o.close();
        }
    }
}
