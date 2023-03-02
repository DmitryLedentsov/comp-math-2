package lab2.io;

import java.util.Scanner;


public class ConsoleInputManager extends InputManagerImpl{
    public ConsoleInputManager() {
        super(new Scanner(System.in));
    }

    



    public int readCommand() {
        return new Question<>("ОПЦИИ:\n\n -   чтобы ввести с клавиатуры введите 1, \n -   чтобы ввести из файла введите 2, \n -   чтобы выйти введите 3\n", super::readCommand).getAnswer();
    }
    public String readPath() {
        return new Question<>("Введите имя файла: ", super::readPath).getAnswer();
    }
    
}
