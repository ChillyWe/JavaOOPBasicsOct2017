package exam_preparations.examII.app.entities;

import app.entities.Cars.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 10.11.2017 г..
 */
public class Garage {
    private Map<Integer, Car> garage;

    public Garage() {
        this.garage = new HashMap<>();
    }

    public void tuneCar (int index, String addOn) {
        for (Car car : garage.values()) {
            car.tuneCar(index, addOn);
        }
    }

    public boolean carIsHere(int id) {
        return garage.containsKey(id);
    }

    public void parkCar(int id, Car car) {
        this.garage.putIfAbsent(id, car);
    }

    public Car unParkCar(int id) {
        Car carForUnpark = garage.get(id);
        garage.remove(id);
        return carForUnpark;
    }
}