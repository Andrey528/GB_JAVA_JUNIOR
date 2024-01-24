package serialization.hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import serialization.sem.task2.ToDoV2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentList {
    public static final String FILE_JSON = "students.json";
    public static final String FILE_BIN = "students.bin";
    public static final String FILE_XML = "students.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewStudent(Scanner scanner, List<Student> students) {
        System.out.println("Введите имя студента:");
        String newStudentName = scanner.nextLine();
        System.out.println("Введите возраст студента:");
        Integer newStudentAge = scanner.nextInt();
        System.out.println("Введите средний балл студента:");
        Double newStudentGPA = scanner.nextDouble();
        students.add(new Student(newStudentName, newStudentAge, newStudentGPA));
        saveStudentsToFile(FILE_JSON, students);
        saveStudentsToFile(FILE_BIN, students);
        saveStudentsToFile(FILE_XML, students);
        System.out.println("Новый студент добавлен.");
    }

    public static List<Student> loadStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    students = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
                else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        students = (List<Student>) ois.readObject();
                    }

                }
                else if (fileName.endsWith(".xml")) {
                    students = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static void saveStudentsToFile(String fileName, List<Student> students) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), students);
            }
            else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(students);
                }
            }
            else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), students);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void displayStudents(List<Student> students) {
        System.out.println("Список студентов:");
        students.forEach(System.out::println);
    }
}
