package defining_classes.Problem11;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", super.name, this.furLength);
    }
}