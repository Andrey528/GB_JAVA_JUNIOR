package serialization.lk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example1 {
    public static void main(String[] args) throws IOException {
        String str = "Hello, everyone!";
        FileOutputStream fileOutputStream = new FileOutputStream("serialized_object");
        ObjectOutputStream objectOutputStream = new
                ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();
    }
}
