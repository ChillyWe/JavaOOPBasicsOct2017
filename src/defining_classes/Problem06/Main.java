package defining_classes.Problem06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chilly on 28.04.2017 г..
 */
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new LinkedList<>();

        while (n-- > 0)
        {
            String [] carData = scanner.nextLine().split("\\s+");
            Car car = null;
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < carData.length - 1; i += 2)
            {
                double pressure = Double.parseDouble(carData[i]);
                int age = Integer.parseInt(carData[i + 1]);
                Tire tire = new Tire(pressure, age);
                tires.add(tire);
            }
            car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }
        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                isFragile(cars);
                break;
            case "flamable":
                isFlammable(cars);
                break;
        }
    }

    private static void isFlammable(List<Car> cars) {
        for (Car currentCar:cars)
        {
            if("flamable".equals(currentCar.getCargo().getCargoType()))
            {
                if(currentCar.getEngine().getEnginePower() > 250)
                {
                    System.out.println(currentCar.getCarModel());
                }
            }
        }
    }

    private static void isFragile(List<Car> cars) {
       for (Car currentCar:cars)
       {
           boolean resultPress = false;
           if("fragile".equals(currentCar.getCargo().getCargoType()))
           {
               for(Tire press:currentCar.getTires())
               {
                   if(press.getTirePressure() < 1)
                   {
                       resultPress = true;
                   }
               }
           }
           if (resultPress) {
               System.out.println(currentCar.getCarModel());
           }
       }
    }
}
