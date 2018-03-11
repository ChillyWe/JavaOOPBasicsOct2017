package exam_preparations.examI.app.factories;

import app.entities.Benders.*;
import static app.utilities.Constant.*;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public final class BenderFactory {


    private BenderFactory() {}

    public static Bender createBender(String type, String name, int power, double secondaryAbility){
        switch (type) {
            case AIR:
                return new AirBender(name, power, secondaryAbility);
            case WATER:
                return new WaterBender(name, power, secondaryAbility);
            case FIRE:
                return new FireBender(name, power, secondaryAbility);
            case EARTH:
                return new EarthBender(name, power, secondaryAbility);
                default:
                    return null;
        }
    }
}