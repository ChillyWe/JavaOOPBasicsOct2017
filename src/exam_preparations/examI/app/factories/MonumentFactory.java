package exam_preparations.examI.app.factories;

import app.entities.Monuments.*;
import static app.utilities.Constant.*;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public final class MonumentFactory {
    private MonumentFactory() {}

    public static Monument createMonument(String type, String name, int affinity) {
        switch (type) {
            case AIR:
                return new AirMonument(name, affinity);
            case WATER:
                return new WaterMonument(name, affinity);
            case FIRE:
                return new FireMonument(name, affinity);
            case EARTH:
                return new EarthMonument(name, affinity);
                default:
                    return null;
        }
    }
}