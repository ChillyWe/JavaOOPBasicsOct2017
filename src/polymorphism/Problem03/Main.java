package polymorphism.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();

        String line;
        while (true) {
            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] animalTokens = line.split("\\s+");
            Animal currAnimal = null;
            try {
                currAnimal = createAnimal(animalTokens);
                String[] foodTokens = reader.readLine().split("\\s+");
                Food currFood = getFood(foodTokens);

                System.out.println(currAnimal.makeSound());
                currAnimal.eatFood(currFood);

            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
            animals.add(currAnimal);
        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodTokens) {
        switch (foodTokens[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodTokens[1]));
            case "Meat":
                return new Meat(Integer.parseInt(foodTokens[1]));
            default:
                return null;
        }
    }

    private static Animal createAnimal(String[] animalTokens) {
        switch (animalTokens[0]) {
            case "Cat":
                return new Cat(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
            case "Mouse":
                return new Mouse(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
            case "Tiger":
                return new Tiger(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
            case "Zebra":
                return new Zebra(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
            default:
                return null;
        }
    }
}