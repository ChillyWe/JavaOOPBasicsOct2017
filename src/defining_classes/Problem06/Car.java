package defining_classes.Problem06;

import java.util.List;

/**
 * Created by Chilly on 28.04.2017 г..
 */
public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String carModel, Engine engine, Cargo cargo, List<Tire> tires) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return this.getCarModel();
    }
}