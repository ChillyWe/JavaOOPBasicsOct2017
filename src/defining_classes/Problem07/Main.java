package defining_classes.Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Chilly on 24.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Engine> engineData = new HashMap<>();
        List<Car> carData = new LinkedList<>();

        int numbersOfEngines = Integer.parseInt(reader.readLine());
        while (numbersOfEngines-- > 0) {
            engineDataFill(reader, engineData);
        }
        int numbersOfCars = Integer.parseInt(reader.readLine());
        while (numbersOfCars-- > 0) {
            carDataFill(reader, engineData, carData);
        }

        for (Car car : carData) {
            System.out.println(car);
        }
    }

    private static void carDataFill(BufferedReader reader, Map<String, Engine> engineData, List<Car> carData) throws IOException {
        String[] carTokens = reader.readLine().split("\\s+");
        Car currCar = null;

        switch (carTokens.length) {
            case 2:
                currCar = new Car(carTokens[0], engineData.get(carTokens[1]));
                break;
            case 3:
                try {
                    currCar = new Car(carTokens[0], engineData.get(carTokens[1]), Integer.parseInt(carTokens[2]));
                } catch (Exception caseColor) {
                    currCar = new Car(carTokens[0], engineData.get(carTokens[1]), carTokens[2]);
                }
                break;
            case 4:
                currCar = new Car(carTokens[0], engineData.get(carTokens[1]), Integer.parseInt(carTokens[2]), carTokens[3]);
                break;
        }
        carData.add(currCar);
    }

    private static void engineDataFill(BufferedReader reader, Map<String, Engine> engineData) throws IOException {
        String[] engineTokens = reader.readLine().split("\\s+");
        Engine currEngine = null;
        switch (engineTokens.length) {
            case 2:
                currEngine = new Engine(engineTokens[0], Integer.parseInt(engineTokens[1]));
                break;
            case 3:
                try {
                    currEngine = new Engine(engineTokens[0], Integer.parseInt(engineTokens[1]), Integer.parseInt(engineTokens[2]));
                } catch (Exception caseEfficiency) {
                    currEngine = new Engine(engineTokens[0], Integer.parseInt(engineTokens[1]), engineTokens[2]);
                }
                break;
            case 4:
                currEngine = new Engine(engineTokens[0], Integer.parseInt(engineTokens[1]), Integer.parseInt(engineTokens[2]), engineTokens[3]);
                break;
        }
        engineData.putIfAbsent(engineTokens[0], currEngine);
    }
}