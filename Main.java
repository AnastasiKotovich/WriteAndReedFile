package Module_three;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String data = "текстовые данные";
        String path = "test.txt"; //файл в корне проекта
        MyFile myFile = new MyFile(path);
        try{
            myFile.write(data);
            List<String> lines = myFile.read();
            System.out.print("Содержимое файла: ");
            lines.forEach(System.out::println);
        }
        catch (MyException e){
            System.out.println("Ошибка при работе с файлом: "+e.getMessage());
        }
    }
}

class MyException extends Exception {
    public MyException(String description){
        super(description);
    }
}
class MyFile{
    private final Path path;
    public MyFile(String path){
        this.path = Path.of(path);
    }
    public void write(String data) throws MyException{
        try{
            Files.writeString(path, data, StandardOpenOption.CREATE);
            System.out.println("Данные успешно записаны");
        } catch (IOException e) {
            throw new MyException("Ошибка при записи данных в файл");
        }
    }
    public List<String> read() throws MyException{
        try{
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        }
        catch (NoSuchFileException e){
            throw new MyException("Файл не найден");
        }
        catch (IOException e){
            throw new MyException("Ошибка при чтении файла");
        }
    }
}