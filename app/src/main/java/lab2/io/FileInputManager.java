package lab2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import lab2.exceptions.FileException;

public class FileInputManager  extends InputManagerImpl{
    String path;
    
    public FileInputManager(String path) throws FileException {
        super();
        this.path = path; 
        try{
            init(new Scanner(new File(path)));
        } catch(FileNotFoundException e) {
            throw new FileException("Файл "+ path + " не найден");
        } catch (IOException e) {
            throw new FileException("Ошибка при чтении файла " + path);
        } catch (IllegalArgumentException e) {
            throw new FileException("Данные в файле некорректны: " + e.getMessage());
        } catch (Exception e) {
            throw new FileException("Неизвестная ошибка");
        }
       

    }
    @Override 
    public void close() {
        super.close();
    }

    
}
