package exam_preparations.examI.app.entities.Benders;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * heatAggression;
    }

    @Override
    public String toString() {
        return String.format("###Fire Bender: %s, Power: %d, Heat Aggression: ", super.getName(), super.getPower()) + String.format("%.2f",this.heatAggression).replace(",", ".");
    }
}