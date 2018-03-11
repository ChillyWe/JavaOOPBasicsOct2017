package encapsulation.Problem05;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Dough {
    private String flourType;
    private String addition ;
    private double weightInGrams;

    public Dough(String flourType, String addition, double weightInGrams) {
        this.setFlourType(flourType);
        this.setAddition(addition);
        this.setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        if ("white".equalsIgnoreCase(flourType) || "wholegrain".equalsIgnoreCase(flourType)) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setAddition(String addition) {
        if ("crispy".equalsIgnoreCase(addition) || "chewy".equalsIgnoreCase(addition) || "homemade".equalsIgnoreCase(addition)) {
            this.addition = addition;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeightInGrams(double weightInGrams) {
        if (0 > weightInGrams || weightInGrams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    public double calculateDoughCalories() {
        double typeCalories = 0.0;
        double additionCalories = 0.0;

        switch (this.flourType) {
            case "Wholegrain":
                typeCalories = 1.0;
                break;
            case "White":
                typeCalories = 1.5;
                break;
        }

        switch (this.addition) {
            case "Crispy":
                additionCalories = 0.9;
                break;
            case "Chewy":
                additionCalories = 1.1;
                break;
            case "Homemade":
                additionCalories = 1.0;
                break;
        }

        return (this.weightInGrams * 2) * typeCalories * additionCalories;
    }
}