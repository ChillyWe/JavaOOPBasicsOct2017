package defining_classes.Problem09;

/**
 * Created by Chilly on 26.10.2017 г..
 */
public class Car {
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.carModel, this.carSpeed);
    }
}