package dataBaseInstruments.lk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "0d5u8n8g";

    public static void con() {
//        Connector connector = new Connector();
//        Session session = connector.getSession();
//        Magic magic = new Magic("Волшебная стрела", 10, 0, 0);
//        session.beginTransaction();
//        session.save(magic);
//        magic = new Magic("Молния", 25, 0, 0);
//        session.save(magic);
//        magic = new Magic("Каменная кожа", 0, 0, 6);
//        session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0);
//        session.save(magic);
//        magic = new Magic("Жажда крови", 0, 6, 0);
//        session.save(magic);
//        magic = new Magic("Проклятие", 0, -3, 0);
//        session.save(magic);
//        magic = new Magic("Лечение", -30, 0, 0);
//        session.save(magic);
//        session.getTransaction().commit();
//        session.close();

//        Connector connector = new Connector();
//        try (Session session = connector.getSession()) {
//            List<Magic> books = session.createQuery("FROM Magic",
//                    Magic.class).getResultList();
//            books.forEach(b -> {
//                System.out.println("Book of Magic : " + b);
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Connector connector = new Connector();
//        try (Session session = connector.getSession()) {
//            String hql = "from Magic where id = :id";
//            Query<Magic> query = session.createQuery( hql, Magic.class);
//            query.setParameter("id", 4);
//            Magic magic = query.getSingleResult();
//            System.out.println(magic);
//            magic.setAttBonus(12);
//            magic.setName("Ярость");
//            session.beginTransaction();
//            session.update(magic);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> books = session.createQuery("FROM Magic",
                    Magic.class).getResultList();
            books.forEach(b -> {
                session.delete(b);
            });
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void con() {
//        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            Statement statement = con.createStatement();
//            statement.execute("DROP SCHEMA `test`;");
//            statement.execute("CREATE SCHEMA `test`;");
//            statement.execute("CREATE TABLE `test`.`table` (\n" +
//                    " `id` INT NOT NULL,\n" +
//                    " `firstname` VARCHAR(45) NULL,\n" +
//                    " `lastname` VARCHAR(45) NULL,\n" +
//                    " PRIMARY KEY (`id`));");
//            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n"
//                    +
//                    "VALUES (1,'Иванов','Иван');");
//            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n" +
//            "VALUES (2,'Петров','Пётр');");
//
//            ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`;");
//            while (set.next()){
//                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//    }

    public Connection getConnection(String url, String user, String password){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public ArrayList<String> getDaata(Statement statement) throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`;");
        while (set.next()){
            list.add(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
        }
        return list;
    }
}
