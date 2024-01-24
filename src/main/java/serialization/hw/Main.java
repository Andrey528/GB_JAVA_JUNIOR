package serialization.hw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static serialization.hw.StudentList.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            students = StudentList.loadStudentsFromFile(FILE_JSON);
        } else {
            students = prepareStudents();
            StudentList.saveStudentsToFile(FILE_JSON, students);
            StudentList.saveStudentsToFile(FILE_BIN, students);
            StudentList.saveStudentsToFile(FILE_XML, students);
        }

        StudentList.displayStudents(students);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить нового студента");
            System.out.println("2. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    StudentList.addNewStudent(scanner, students);
                    break;
                case "2":
                    StudentList.saveStudentsToFile(FILE_JSON, students);
                    StudentList.saveStudentsToFile(FILE_BIN, students);
                    StudentList.saveStudentsToFile(FILE_XML, students);
                    System.out.println("Список студентов сохранен.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }

            StudentList.displayStudents(students);
        }

    }

    static List<Student> prepareStudents()
    {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Николай", 24, 4.5));
        list.add(new Student("Матвей", 22, 3.7));
        list.add(new Student("Анастасия", 23, 5.0));
        return list;
    }
}
