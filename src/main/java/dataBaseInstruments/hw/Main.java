package dataBaseInstruments.hw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        // Создание фабрики сессий
        sessionFactory = new Configuration()
                .configure("hibernateSchool.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Создание объекта
        Course course = Course.create();

        // Сохранение объекта в базе данных
        insertCourse(course);
        System.out.println("Object course save successfully");

        // Чтение объекта из базы данных
        Course retrievedCourse = readCourse(course.getId());
        System.out.println("Object course retrieved successfully");
        System.out.println("Retrieved course object: " + retrievedCourse);

        // Обновление объекта
        retrievedCourse.updateTitle();
        retrievedCourse.updateDuration();
        updateCourse(retrievedCourse);
        System.out.println("Object course update successfully");

        // Удаление объекта
        deleteCourse(retrievedCourse);

        // Закрытие фабрики сессий
        sessionFactory.close();
    }

    private static void insertCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);

        transaction.commit();
        session.close();
    }

    private static Course readCourse(int courseId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, courseId);

        transaction.commit();
        session.close();

        return course;
    }

    private static void updateCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(course);

        transaction.commit();
        session.close();
    }

    private static void deleteCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(course);

        transaction.commit();
        session.close();
    }
}
