package encapsulation.Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pizza pizza = null;
        Dough dough = null;
        boolean exit = false;

        while (true) {
            String line = reader.readLine();
            if ("end".equalsIgnoreCase(line)) {
                break;
            }
            try {
                String[] tokens = line.split("\\s+");
                if (tokens[0].equalsIgnoreCase("pizza")) {
                    String name = tokens[1];
                    int numberOfToppings = Integer.parseInt(tokens[2]);
                    pizza = new Pizza(name, numberOfToppings);
                } else if ("dough".equalsIgnoreCase(tokens[0])) {
                    String type = tokens[1];
                    String addition = tokens[2];
                    double weight = Double.parseDouble(tokens[3]);
                    dough = new Dough(type, addition, weight);
                } else if ("topping".equalsIgnoreCase(tokens[0])) {
                    String toppingType = tokens[1];
                    double toppingWeight = Double.parseDouble(tokens[2]);
                    Topping currTopping = new Topping(toppingType, toppingWeight);
                    pizza.setToppings(currTopping);
                }
            } catch (IllegalArgumentException invalidInput) {
                exit = true;
                System.out.println(invalidInput.getMessage());
                break;
            } catch (NullPointerException nlo) {
                System.out.println("there is NO PIZZA! buddy");
            }
        }
            if (pizza != null && dough != null && !exit) {
                pizza.setDough(dough);
                double calories = pizza.calculateCalories();
                System.out.println(String.format("%s - %.2f", pizza.getName(), calories).replace(",", "."));
            }

    }
}