package reflectionApi.hw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    /**
     * Создайте абстрактный класс "Animal" с полями "name" и "age".
     * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
     * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
     * Выведите на экран информацию о каждом объекте.
     * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Animal[] animals = {
                new Cat("Murzik", 5),
                new Dog("Richi", 1),
                new Cat("Barsik", 3),
                new Dog("Sharik", 7),
                new Dog("Reks", 4)
        };


        Arrays.stream(animals).forEach(obj -> {
            try {
                Class<?> animalClass = Class.forName(obj.getClass().getName());
                Constructor[] constructors
                        = animalClass.getConstructors();
                Field[] animalClassFields = animalClass.getDeclaredFields();
                Field[] animalSuperClassFields = animalClass.getSuperclass().getDeclaredFields();
                Field[] fields = new Field[animalClassFields.length + animalSuperClassFields.length];
                System.arraycopy(animalClassFields, 0, fields, 0, animalClassFields.length);
                System.arraycopy(animalSuperClassFields, 0, fields, animalClassFields.length, animalSuperClassFields.length);
                Method[] declaredMethods = animalClass.getMethods();

                System.out.println(obj);
                System.out.println();
                System.out.println("Fields:");
                Arrays.stream(fields).forEach(System.out::println);
                System.out.println();
                System.out.println("Constructors:");
                Arrays.stream(constructors).forEach(System.out::println);
                System.out.println();
                System.out.println("Methods:");
                Arrays.stream(declaredMethods).forEach(System.out::println);
                System.out.println();
                Method makeSoundMethod = animalClass.getDeclaredMethod("makeSound");
                makeSoundMethod.invoke(obj);
                System.out.println("----------------------------------------");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
