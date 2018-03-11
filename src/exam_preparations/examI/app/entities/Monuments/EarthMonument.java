package exam_preparations.examI.app.entities.Monuments;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class EarthMonument extends Monument {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public int getMonumentPower() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Earth Monument: %s, Earth Affinity: %d", super.getName(), this.earthAffinity);
    }
}