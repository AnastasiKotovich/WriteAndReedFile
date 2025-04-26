package Module_three;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) throws ObjectException {
        MyObject [] obj = {new MyObject(1, "first"), new MyObject(2, "second"), new MyObject(3, "third")};
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.bin"))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new ObjectException("Ошибка записи файла");
        }
    }
}
