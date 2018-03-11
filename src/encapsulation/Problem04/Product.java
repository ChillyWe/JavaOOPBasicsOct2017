package encapsulation.Problem04;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setPrice(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price = money;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}