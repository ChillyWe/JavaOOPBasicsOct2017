package defining_classes.Problem07;

/**
 * Created by Chilly on 24.10.2017 г..
 */
public class Engine {
    private final static int DEFAULT_DISPLACEMENT = -1;
    private final static String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacement = "n/a";
        if (this.displacement == -1) {
            return String.format("%s:\n" +
                                "    Power: %d\n" +
                                "    Displacement: %s\n" +
                                "    Efficiency: %s", this.model, this.power, displacement, this.efficiency);
        } else {
            return String.format("%s:\n" +
                                "    Power: %d\n" +
                                "    Displacement: %d\n" +
                                "    Efficiency: %s", this.model, this.power, this.displacement, this.efficiency);
        }
    }
}