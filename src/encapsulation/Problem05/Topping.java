package encapsulation.Problem05;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Topping {
    private String toppingType;
    private double weightInGrams;

    public Topping(String toppingType, double weightInGrams) {
        this.setToppingType(toppingType);
        this.setWeightInGrams(weightInGrams);
    }

    private void setToppingType(String toppingType) {
        if ("meat".equalsIgnoreCase(toppingType) || "veggies".equalsIgnoreCase(toppingType) ||
                "cheese".equalsIgnoreCase(toppingType) || "sauce".equalsIgnoreCase(toppingType)) {
            this.toppingType = toppingType;
        }
        else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weightInGrams = weightInGrams;
    }

    public double calculateToppingCalories() {
        double typeCalories = 0.0;
        switch (this.toppingType) {
            case "Meat":
                typeCalories = 1.2;
                break;
            case "Veggies":
                typeCalories = 0.8;
                break;
            case "Cheese":
                typeCalories = 1.1;
                break;
            case "Sauce":
                typeCalories = 0.9;
                break;
        }
        return (weightInGrams * 2) * typeCalories;
    }
}