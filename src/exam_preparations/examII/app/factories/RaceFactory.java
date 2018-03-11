package exam_preparations.examII.app.factories;

import app.entities.Races.*;

import static app.utilities.Constants.*;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public final class RaceFactory {

    private RaceFactory() {}

    public static Race makeRace(String type, int length, String route, int prizePool) {
        switch (type) {
            case CASUAL_RACE_DEFAULT:
                return new CasualRace(length, route, prizePool);
            case DRAG_RACE_DEFAULT:
                return new DragRace(length, route, prizePool);
            case DRIFT_RACE_DEFAULT:
                return new DriftRace(length, route, prizePool);
            default:
                return null;
        }
    }
}