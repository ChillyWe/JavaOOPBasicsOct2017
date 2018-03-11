package exam_preparations.examII.app.entities.Races;

import app.entities.Cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 10.11.2017 г..
 */
public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public boolean isThisCarInRace (Car car) {
        for (Car participant : participants) {
            if (participant.equals(car)) {
                return true;
            }
        }
        return false;
    }

    public void addParticipants(Car car) {
        this.participants.add(car);
    }

    protected List<Car> calculateWinners() {
        return this.participants.stream().sorted((a, b) -> Integer.compare(calculatePoints(b), calculatePoints(a))).limit(3)


    }

    protected abstract int calculatePoints(Car car);



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.participants.stream().sorted((a, b) -> Integer.compare(calculatePoints(b), calculatePoints(a))).limit(3)
                .forEach(c -> sb.append(String.format("%s %s %dPP - ${moneyWon}",
                        c.getBrand(), c.getModel(), calculatePoints(c)  ))).  // TODO look last two rows :D and a CalculateWinners metod

        /*
	 1. {brand} {model} {performancePoints}PP - ${moneyWon}
	 2. {brand} {model} {performancePoints}PP - ${moneyWon}
	 3. {brand} {model} {performancePoints}PP - ${moneyWon}”
         */

        sb.append(String.format("%s - %d", this.route, this.length)).append(System.lineSeparator());

        return sb.toString();
    }
}