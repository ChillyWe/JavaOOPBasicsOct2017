package encapsulation.Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 27.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(String.format("Chicken %s (age %d) can produce %.0f eggs per day.", chicken.getName(), chicken.getAge(), chicken.getProductPerDay()));
        }
        catch (IllegalArgumentException invalidInput) {
            System.out.println(invalidInput.getMessage());
        }
    }
}