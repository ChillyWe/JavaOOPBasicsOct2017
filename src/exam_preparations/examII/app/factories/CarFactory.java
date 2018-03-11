package exam_preparations.examII.app.factories;

import app.entities.Cars.*;

import static app.utilities.Constants.*;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public final class CarFactory {
    private CarFactory() {
    }

    public static Car makeCar(String type, String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        switch (type) {
            case PERFORMANCE_CAR_DEFAULT:
                return new PerformanceCar(brand, model, year, horsepower, acceleration, suspension, durability);
            case SHOW_CAR_DEFAULT:
                return new ShowCar(brand, model, year, horsepower, acceleration, suspension, durability);
            default:
                return null;
        }
    }
}