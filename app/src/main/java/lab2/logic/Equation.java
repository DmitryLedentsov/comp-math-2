package lab2.logic;

import lombok.Getter;

public class Equation implements Cloneable{
    @Getter 
    private double[] data;
    public Equation(double[] d){
        data = d;
    }
    public Equation(int n){
        data = new double[n];
    }
    public int getLength(){
        return data.length;
    }
    public double get(int i){
        return data[i];
    }
    public void set(int i, double d){
        data[i] = d;
    }
    public Equation clone(){
        return new Equation(data.clone());
    }
    public String toString(){
        String s = "";
        for(int i = 0; i < data.length; i++){
            s += data[i] + " ";
        }
        return s;
    }
    

}
