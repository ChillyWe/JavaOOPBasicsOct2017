package defining_classes.Problem06;

/**
 * Created by Chilly on 28.04.2017 г..
 */
public class Tire {
    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return this.tirePressure;
    }
}
