package serialization.lk;

import java.io.*;
import java.util.ArrayList;

public class Example4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> list = null;
        list = (ArrayList<String>) deSerialObj("ser");
        System.out.println(list);
    }

    public static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new
                ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
    public static Object deSerialObj(String file) throws IOException,
            ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}
