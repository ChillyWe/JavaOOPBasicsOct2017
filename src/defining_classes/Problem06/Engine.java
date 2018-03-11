package defining_classes.Problem06;

/**
 * Created by Chilly on 28.04.2017 г..
 */
public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }
}
