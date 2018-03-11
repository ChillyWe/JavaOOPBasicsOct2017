package polymorphism.Problem03;

import java.text.DecimalFormat;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public class Cat extends Felime {
    private String catBreed;
    public Cat(String name, String type, double weight, String livingRegion, String catBreed) {
        super(name, type, weight, livingRegion);
        this.catBreed = catBreed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public String toString() {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        StringBuilder builder = new StringBuilder();
        builder.append("Cat").append("[")
                .append(super.getName()).append(", ").append(catBreed).append(", ").append(decimalFormat.format(super.getWeight()).replace(",", ".")).append(", ")
                .append(super.getLivingRegion()).append(", ").append(super.getFoodEaten()).append("]");
        return builder.toString();
    }
}
