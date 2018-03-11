package exam_preparations.examII.app.entities.Races;

import app.entities.Cars.Car;

/**
 * Created by Chilly on 10.11.2017 г..
 */
public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car car) {
        return (car.getHorsepower() + car.getAcceleration());
    }
}