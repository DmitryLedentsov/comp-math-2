package lab2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import lab2.exceptions.FileException;
import lombok.Getter;

public class FileOutputManager  extends OutputManagerImpl{
    @Getter
    String path;
    public FileOutputManager(String path) throws FileException{
        this.path = path;
        try{
            init(new PrintStream(new File(path)));
            print("Вывод:\n");
        } catch(FileNotFoundException e) {
            
            throw new FileException("Файл "+ path + " не найден");
        } catch (IOException e) {
            throw new FileException("Ошибка при записи в файл " + path);
        } catch (IllegalArgumentException e) {
            throw new FileException("Данные в файле некорректны: " + e.getMessage());
        } catch (Exception e) {
            throw new FileException("Неизвестная ошибка");
        }
    }
    public void close(){
        out.close();
    }

}
