package exam_preparations.examI.app.entities.Benders;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * waterClarity;
    }

    @Override
    public String toString() {
        return String.format("###Water Bender: %s, Power: %d, Water Clarity: ", super.getName(), super.getPower()) + String.format("%.2f",this.waterClarity).replace(",", ".");
    }
}