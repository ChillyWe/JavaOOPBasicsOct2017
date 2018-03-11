package exam_preparations.examII.app.entities.Cars;

import static app.utilities.Constants.STARS_DEFAULT;

/**
 * Created by Chilly on 10.11.2017 г..
 */
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = STARS_DEFAULT;
    }

    public final int getStars() {
        return this.stars;
    }

    @Override
    public void tuneCar(int index, String addOns) {
        int horsePowerAfterTune = super.getHorsepower() + index;
        super.setHorsepower(horsePowerAfterTune);
        int suspensionAfterTune = super.getSuspension() + ((index * 50) / 100);
        super.setSuspension(suspensionAfterTune);
        this.stars+=index;
    }

    @Override
    public String toString() {
        return String.format("%s%d *", super.toString(), this.getStars());
    }
}