package encapsulation.Problem05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Pizza {
    private final static double DEFAULT_CALORIES = 0.0;

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private double calories;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.dough = null;
        this.setToppings(numberOfToppings);
        this.calories = DEFAULT_CALORIES;
    }

    private void setName(String name) {
        if (name.length() <= 0 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setToppings(int length) {
        if (length < 0 || length > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void setToppings(Topping topping) {
        this.toppings.add(topping);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public double calculateCalories () {
        this.calories = dough.calculateDoughCalories() + toppings.stream().mapToDouble(Topping::calculateToppingCalories).sum();
        return this.calories;
    }
}