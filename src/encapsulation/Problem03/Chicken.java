package encapsulation.Problem03;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Chicken {
    private String name;
    private int age;
    private double productPerDay;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.productPerDay = calculate();
    }

    private void setName(String name) {
        if (name.length() < 1 || name.isEmpty() || " ".equals(name)) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    private double calculate ()  {
        if (age < 6 ) {
            return 2;
        } else if (age < 12) {
            return 1;
        } else {
           return 0.75;
        }
    }

    public double getProductPerDay() {
        return this.productPerDay;
    }
}