package exam_preparations.examIII.app.factories;

import app.entities.Animals.*;
import static app.utilities.Constants.*;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public final class AnimalFactory {

    private AnimalFactory() {}

    public static Animal createAnimal(String type, String name, int age, int uniqueParam, String adoptionCenterName) {
        switch (type) {
            case DOG_DEFAULT:
                return new Dog(name, age, uniqueParam, adoptionCenterName);
            case CAT_DEFAULT:
                return new Cat(name, age, uniqueParam, adoptionCenterName);
                default:
                    return null;
        }
    }
}