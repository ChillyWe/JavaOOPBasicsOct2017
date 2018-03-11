package exam_preparations.examIII.app.factories;

import app.entities.Centers.*;
import static app.utilities.Constants.*;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public final class CenterFactory {

    private CenterFactory() {}

    public static Center createCenter(String type, String name) {
        switch (type) {
            case ADOPTION_DEFAULT:
                return new AdoptionCenter(name);
            case CLEANSING_DEFAULT:
                return new CleansingCenter(name);
                default:
                    return null;
        }
    }
}