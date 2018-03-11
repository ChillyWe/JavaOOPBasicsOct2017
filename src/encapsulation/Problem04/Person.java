package encapsulation.Problem04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void addToBagOfProducts(Product product) {
        if (canHeAffordProduct(product.getPrice())) {
            this.bagOfProducts.add(product);
            this.money -= product.getPrice();
            System.out.println(String.format("%s bought %s", this.name, product.getName()));
        }
        else {
            throw new IllegalStateException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    private boolean canHeAffordProduct(double price) {
        return this.money >= price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.bagOfProducts.size() == 0 ? "Nothing bought" :
                                this.bagOfProducts.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}