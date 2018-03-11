package defining_classes.Problem07;

/**
 * Created by Chilly on 24.10.2017 г..
 */
public class Car {
    private final static int DEFAULT_WEIGHT = -1;
    private final static String DEFAULT_COLOR = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT_WEIGHT;
        this.color = DEFAULT_COLOR;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String weight = "n/a";
        if (this.weight == -1) {
            return String.format("%s:\n" +
                    "  %s\n" +
                    "  Weight: %s\n" +
                    "  Color: %s", this.model, this.engine.toString(), weight, this.color);
        } else {
            return String.format("%s:\n" +
                    "  %s\n" +
                    "  Weight: %s\n" +
                    "  Color: %s", this.model, this.engine.toString(), this.weight, this.color);
        }
    }
}