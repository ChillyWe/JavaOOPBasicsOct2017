package exam_preparations.examII.app.entities.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 10.11.2017 г..
 */
public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    public final List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }

    @Override
    public void tuneCar(int index, String addOn) {
        int horsePowerAfterTune = super.getHorsepower() + index;
        super.setHorsepower(horsePowerAfterTune);
        int suspensionAfterTune = super.getSuspension() + ((index * 50) / 100);
        super.setSuspension(suspensionAfterTune);
        this.addOns.add(addOn);
    }

    @Override
    protected void setSuspension(int suspension) {
        int newSuspension = suspension - (suspension * 25) / 100;
        super.setSuspension(newSuspension);
    }

    @Override
    protected void setHorsepower(int horsepower) {
        int newHorsepower = horsepower + (horsepower * 50) / 100;
        super.setHorsepower(newHorsepower);
    }

    @Override
    public String toString() {
        return String.format("%sAdd-ons: %s", super.toString(), this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns));
    }
}