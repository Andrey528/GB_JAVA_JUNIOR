package reflectionApi.hw;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Maw");
    }

    @Override
    public String toString() {
        return "Cat{Name='" +
            this.getName() + "', age=" +
            this.getAge() + "}";
    }
}
