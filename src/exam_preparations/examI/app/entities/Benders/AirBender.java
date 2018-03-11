package exam_preparations.examI.app.entities.Benders;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getBenderPower() {
        return super.getPower() * aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format("###Air Bender: %s, Power: %d, Aerial Integrity: ", super.getName(), super.getPower()) + String.format("%.2f",this.aerialIntegrity).replace(",", ".");
    }
}