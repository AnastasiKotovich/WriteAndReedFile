package Module_three;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReedObject {
    public static void main(String[] args) throws ObjectException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.bin"))) {
            MyObject[] obj = (MyObject[]) ois.readObject();
            System.out.println(Arrays.toString(obj));
        }
        catch (IOException | ClassNotFoundException e) {
            throw new ObjectException("Ошибка чтения файла");
        }

    }
}
