package exam_preparations.examI.app.entities.Monuments;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public class FireMonument extends  Monument {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getMonumentPower() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Fire Monument: %s, Fire Affinity: %d", super.getName(), this.fireAffinity);
    }
}