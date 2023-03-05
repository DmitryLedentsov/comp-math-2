package lab2.io;

import java.util.Scanner;

import lab2.app.BinaryEquations;
import lab2.app.Equations;
import lab2.app.Methods;
import lab2.logic.BinaryFunction;
import lab2.logic.NonlinearSystem;


public class ConsoleInputManager extends InputManagerImpl{
    public ConsoleInputManager() {
        super(new Scanner(System.in));
    }

    



    public int readCommand() {
        return new Question<>("ОПЦИИ:\n\n -   чтобы ввести уравнение введите 1, \n -   чтобы ввести систему введите 2, \n -   чтобы выйти введите 3\n", ()->super.readOptions(1,2,3)).getAnswer();
    }
    public String readPath() {
        return new Question<>("Введите имя файла: ", super::readPath).getAnswer();
    }
    public Equations readEquation(){
        return new Question<>("Выберите уравнение\n" + Equations.getAll() + "\n", super::readEquation).getAnswer();
    }
    /*public BinaryEquations readBinaryEquation(){
        return new Question<>("Выберите уравнение: \n" + BinaryEquations.getAll() + "\n", super::readBinaryEquation).getAnswer();
    }*/
    public NonlinearSystem readNonlinearSystem(){
        System.out.println("Выберите 2 уравнения из списка\n" + BinaryEquations.getAll());
        System.out.println("Выберите первое уравнение:");
        BinaryFunction f1 = readBinaryEquation().getFunction();
        System.out.println("Выберите второе уравнение:");
        BinaryFunction f2 = readBinaryEquation().getFunction();
        if(f1==f2) throw new IllegalArgumentException("выбраны одинаковые уравнения");
        return NonlinearSystem.of(f1, f2);

    }
    public Methods readMethod(){
        return new Question<>("Выберите метод\n" + Methods.getAll() + "\n", super::readMethod).getAnswer();
    }
    public double[] readInterval(){
        return new Question<>("Введите интервал: ", super::readInterval).getAnswer();
    }

    public double[] readPoint(){
        return new Question<>("Введите начальное приближение: ", super::readPoint).getAnswer();
    }
    public int readFileOrConsole(){
        return new Question<>("Введите 1 чтобы использовать консоль, 2 - файл :",super::readFileOrConsole).getAnswer();
    }
    public double readAccuracy(){
        return new Question<>("Введите точность: ", super::readAccuracy).getAnswer();
    }
    
}
