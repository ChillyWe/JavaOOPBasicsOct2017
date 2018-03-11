package exam_preparations.examII.app.core;

import app.entities.Cars.*;
import app.entities.Garage;
import app.entities.Races.*;
import app.factories.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public class CarManager {
    private Map<Integer, Car> cars = new HashMap<>();
    private Map<Integer, Race> races = new HashMap<>();
    private Garage garage = new Garage();

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car currCar = CarFactory.makeCar(type, brand, model, yearOfProduction,  horsepower,  acceleration, suspension, durability);
        cars.putIfAbsent(id, currCar);
    }

	public String check(int id) {
        return cars.get(id).toString();
    }

	public void open(int id, String type, int length, String route, int prizePool) {
        Race currRace = RaceFactory.makeRace(type, length, route, prizePool);
        races.putIfAbsent(id, currRace);
    }

    public void participate(int carId, int raceId) {
        Race currRace = races.get(raceId);
        Car currCar = cars.get(carId);
        if (!garage.carIsHere(carId)) {
            currRace.addParticipants(currCar);
        }
    }

	public String start(int id) {
        if (races.get(id).getParticipants().size() < 1) {
            throw new IllegalStateException("Cannot start the race with zero participants.");
        }
        return "";
    }

	public void park(int id) {
        boolean canIParkYou = true;
        Car currCar = cars.get(id);
        for (Race race : races.values()) {
            if (race.isThisCarInRace(currCar)) {
                canIParkYou = false;
                break;
            }
            else {
                canIParkYou = true;
            }
        }
        if (canIParkYou) {
            garage.parkCar(id, cars.get(id));
        }
    }

	public void unpark(int id) {
        cars.putIfAbsent(id, garage.unParkCar(id));
    }

	public void tune(int tuneIndex, String addOn) {
        garage.tuneCar(tuneIndex, addOn);
    }
}