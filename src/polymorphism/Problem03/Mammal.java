package polymorphism.Problem03;

import java.text.DecimalFormat;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    protected final String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        StringBuilder builder = new StringBuilder();
        builder.append(super.getType()).append("[")
                .append(super.getName()).append(", ").append(decimalFormat.format(super.getWeight()).replace(",", ".")).append(", ")
                .append(this.getLivingRegion()).append(", ").append(super.getFoodEaten()).append("]");
        return builder.toString();
    }
}