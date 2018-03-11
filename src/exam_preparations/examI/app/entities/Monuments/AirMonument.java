package exam_preparations.examI.app.entities.Monuments;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public int getMonumentPower() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Air Monument: %s, Air Affinity: %d", super.getName(), this.airAffinity);
    }
}