package lab2.io;

import java.util.Scanner;

import org.jfree.chart.util.ArrayUtils;

import lab2.logic.Vector;

public class InputManagerImpl implements InputManager{
    protected Scanner scanner;
    protected int line;
    public InputManagerImpl(Scanner s) {
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
    public String readPath() {
        String fileName = readLine();
        if(fileName.isEmpty())
            throw new IllegalArgumentException("Имя файла не может быть пустым");
        return fileName;
    }
}
