package defining_classes.Problem05;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Car {
    private final static int DEFAULT_DISTANCE_TRAVELED = 0;

    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = DEFAULT_DISTANCE_TRAVELED;
    }

    public void driveCar (int distance) {
        double gazNeedForTravel = distance * this.fuelCostFor1km;
        if (gazNeedForTravel > fuelAmount) {
            throw new IllegalStateException("Insufficient fuel for the drive");
        }
        this.distanceTraveled += distance;
        this.fuelAmount -= gazNeedForTravel;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled).replace(",", ".");
    }
}