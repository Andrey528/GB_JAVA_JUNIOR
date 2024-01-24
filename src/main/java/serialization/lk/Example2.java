package serialization.lk;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("serialized_object");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String loadedString = (String) objectInputStream.readObject();
        System.out.println(loadedString);
    }
}
