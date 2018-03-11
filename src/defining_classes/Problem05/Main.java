package defining_classes.Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCars; i++) {
            fillCars(reader, cars);
        }

        while (true) {
            String line = reader.readLine();
            if ("end".equalsIgnoreCase(line)) {
                break;
            }
            String[] driveTokens = line.split("\\s+");
            String modelOfCarForDrive = driveTokens[1];
            int distance = Integer.parseInt(driveTokens[2]);
            if (cars.containsKey(modelOfCarForDrive)) {
                try {
                    cars.get(modelOfCarForDrive).driveCar(distance);
                }
                catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
            }
        }

        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }

    private static void fillCars(BufferedReader reader, Map<String, Car> cars) throws IOException {
        String[] carsToken = reader.readLine().split("\\s+");
        String model = carsToken[0];
        double fuelAmount = Double.parseDouble(carsToken[1]);
        double fuelCostFor1km = Double.parseDouble(carsToken[2]);
        Car currCar = new Car(model, fuelAmount, fuelCostFor1km);
        cars.putIfAbsent(model, currCar);
    }
}