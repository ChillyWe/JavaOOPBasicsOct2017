package defining_classes.Problem11;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class StreetExtraordinaire extends Cat{
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.name, this.decibelsOfMeows);
    }
}