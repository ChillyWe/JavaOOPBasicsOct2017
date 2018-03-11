package encapsulation.Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Chilly on 28.10.2017 г..
 */
public class Main {
    private static Map<String, Person> persons = new LinkedHashMap<>();
    private static Map<String, Product> products = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] personTokens = reader.readLine().split(";");
        try {
            for (int i = 0; i < personTokens.length; i++) {
                String[] tokens = personTokens[i].split("=");

                Person currPerson = new Person(tokens[0], Double.parseDouble(tokens[1]));
                persons.putIfAbsent(tokens[0], currPerson);
            }

            String[] productTokens = reader.readLine().split(";");
            for (int i = 0; i < productTokens.length; i++) {
                String[] token = productTokens[i].split("=");

                Product currProduct = new Product(token[0], Double.parseDouble(token[1]));
                products.putIfAbsent(token[0], currProduct);
            }
            while (true) {
                String line = reader.readLine();
                if ("end".equalsIgnoreCase(line)) {
                    break;
                }
                String[] tokens = line.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];
                if (persons.containsKey(personName) && products.containsKey(productName)) {
                    try {
                        persons.get(personName).addToBagOfProducts(products.get(productName));
                    } catch (IllegalStateException ise) {
                        System.out.println(ise.getMessage());
                    }
                }
            }
        } catch (IllegalArgumentException invalidInput) {
            System.out.println(invalidInput.getMessage());
        }
        persons.values().forEach(p -> System.out.println(p.toString()));
    }
}