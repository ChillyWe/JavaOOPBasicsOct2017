package defining_classes.Problem11;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Siamese extends Cat{
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", super.name, this.earSize);
    }
}