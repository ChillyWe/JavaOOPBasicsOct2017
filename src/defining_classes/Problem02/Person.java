package defining_classes.Problem02;

/**
 * Created by Chilly on 23.10.2017 г..
 */
public class Person {
    public String name;
    public int age;

    public Person() {
        this.name = "No name";
        this.age = 1;
    }

    public Person (int age) {
        this.name = "No name";
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}