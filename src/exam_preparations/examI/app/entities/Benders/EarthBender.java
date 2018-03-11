package exam_preparations.examI.app.entities.Benders;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %d, Ground Saturation: ", super.getName(), super.getPower()) + String.format("%.2f",this.groundSaturation).replace(",", ".");
    }
}