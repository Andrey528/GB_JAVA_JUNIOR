package dataBaseInstruments.hw;

import dataBaseInstruments.sem.models.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Random;

@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private int duration;

    private static final String[] courseTitles = new String[] { "Программирование", "Дизайн", "Менеджмент", "Маркетинг", "Тестирование", "Аналитика"};
    private static final Random random = new Random();

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create(){
        return new Course(courseTitles[random.nextInt(courseTitles.length)], random.nextInt(76, 256));
    }

    public void updateDuration(){
        duration = random.nextInt(76, 256);
    }

    public void updateTitle(){
        title = courseTitles[random.nextInt(courseTitles.length)];
    }
}
