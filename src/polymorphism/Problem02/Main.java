package polymorphism.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Vehicles> vehicles = new LinkedHashMap<>();

        String[] carTokens = reader.readLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));
        String[] truckTokens = reader.readLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));
        String[] busTokens = reader.readLine().split("\\s+");
        Vehicles bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        vehicles.putIfAbsent("Car", car);
        vehicles.putIfAbsent("Truck", truck);
        vehicles.putIfAbsent("Bus", bus);

        int numberOfOperation = Integer.parseInt(reader.readLine());

        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        while (numberOfOperation-- > 0) {
            String[] commandToken = reader.readLine().split("\\s+");
            try {
                if (commandToken[0].equalsIgnoreCase("drive")) {
                    try {
                        double distance = Double.parseDouble(commandToken[2]);
                        vehicles.get(commandToken[1]).drive(distance);
                        System.out.println(String.format("%s travelled %s km", commandToken[1], decimalFormat.format(distance)));
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }

                } else if (commandToken[0].equalsIgnoreCase("refuel")) {
                    double fuel = Double.parseDouble(commandToken[2]);
                    vehicles.get(commandToken[1]).refuel(fuel);
                } else if (commandToken[0].equalsIgnoreCase("driveempty")) {
                    double distance = Double.parseDouble(commandToken[2]);
                    vehicles.get((commandToken[1])).driveEmpty(distance);
                    System.out.println(String.format("%s travelled %s km", commandToken[1], decimalFormat.format(distance)));
                }
            }
            catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}