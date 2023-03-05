package lab2.io;

import java.util.Scanner;

import lab2.app.BinaryEquations;
import lab2.app.Equations;
import lab2.app.Methods;
import lab2.logic.BinaryFunction;
import lab2.logic.NonlinearSystem;

public abstract class InputManagerImpl implements InputManager{
    protected Scanner scanner;
    protected int line;
    public InputManagerImpl(Scanner s) {
        init(s);
    }
    public InputManagerImpl(){};
    void init(Scanner s){
        scanner = s;
    }
    public void print(String message) {
        System.out.println(message);
    }
    public void error(String message) {
        System.err.println(message);
    }

    public String readLine() {
        return scanner.nextLine().stripLeading();
    }
    public void close() {
        scanner.close();
    }
    
    public int readOptions(Integer... opts){
        try{
            int r = Integer.parseInt(readLine());
            if(!lab2.utils.ArrayUtils.<Integer>contains(opts, r))
                throw new IllegalArgumentException("Неверный формат");
            return r;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат");
        }
    }
    public int readNumberFromInterval(int a, int b){
        try{
            int r = Integer.parseInt(readLine());
            if(r>b || r<a)
                throw new IllegalArgumentException("Неверный формат");
            return r;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат");
        }
    }


    public int readCommand(){
        return readOptions(1,2,3);
    }
    
    private int readEquationN(){

        return readNumberFromInterval(0, Equations.values().length-1);
    }
    public Equations readEquation(){
        return Equations.choose(readEquationN());
    }

    private int readBinaryEquationsN(){

        return readNumberFromInterval(0, Equations.values().length-1);
    }
    public BinaryEquations readBinaryEquation(){
        return BinaryEquations.choose(readBinaryEquationsN());
    }
    private int readMethodN(){

        return readNumberFromInterval(0, Methods.values().length-1);
    }
    public Methods readMethod(){
        return Methods.choose(readMethodN());
    }

    

    public int readFileOrConsole(){
        return readOptions(1,2);
    }


    public double readAccuracy() {
        try{
            double a = Double.parseDouble(readLine());
            if(a >= 1)
                throw new IllegalArgumentException("Неправильно задана точность");
            return a;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа");
        }
    }
    public double[] readInterval(){
        try{
            String[] s = readLine().split(" ");
            if(s.length != 2)
                throw new IllegalArgumentException("Неверный формат");
            double[] r = new double[2];
            r[0] = Double.parseDouble(s[0]);
            r[1] = Double.parseDouble(s[1]);
            if(r[0] >= r[1])
                throw new IllegalArgumentException("Неверный формат");
            return r;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа");
        }
    }

    public double[] readPoint(){
        try{
            String[] s = readLine().split(" ");
            if(s.length != 2)
                throw new IllegalArgumentException("Неверный формат");
            double[] r = new double[2];
            r[0] = Double.parseDouble(s[0]);
            r[1] = Double.parseDouble(s[1]);
            return r;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа");
        }
    }

    public NonlinearSystem readNonlinearSystem(){
        BinaryFunction f1 = readBinaryEquation().getFunction();
        BinaryFunction f2 = readBinaryEquation().getFunction();
        if(f1==f2) throw new IllegalArgumentException("выберите разные уравнения");
        return NonlinearSystem.of(f1, f2);
    }
    public String readPath() {
        String fileName = readLine();
        if(fileName.isEmpty())
            throw new IllegalArgumentException("Имя файла не может быть пустым");
        return fileName;
    }
}
