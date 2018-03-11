package inheritance.Problem03;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}