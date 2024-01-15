package reflectionApi.hw;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Gav");
    }

    @Override
    public String toString() {
        return "Dog{Name='" +
                this.getName() + "', age=" +
                this.getAge() + "}";
    }
}
