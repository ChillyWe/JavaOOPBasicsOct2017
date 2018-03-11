package defining_classes.Problem09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chilly on 26.10.2017 г..
 */
public class Main {
    private static Map<String,Person> persons = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern switchPattern = Pattern.compile("(?<personName>[A-Za-z]+) (?<switchWith>[a-z]+)");
        Pattern companyPattern = Pattern.compile("(?<companyName>[a-zA-z]+) (?<department>[a-zA-Z]+) (?<salary>[0-9]+\\.?[0-9]+)");
        Pattern carPattern = Pattern.compile("(?<carModel>\\w+) (?<carSpeed>\\d+)");
        Pattern pokemonPattern = Pattern.compile("(?<pokemonName>[a-zA-Z]+) (?<pokemonElement>[a-zA-z]+)");
        Pattern parentPattern = Pattern.compile("(?<parentName>[a-zA-Z]+) (?<parentBird>\\d+\\/\\d+\\/\\d+)");
        Pattern childPattern = Pattern.compile("(?<childName>[a-zA-Z]+) (?<childBird>\\d+\\/\\d+\\/\\d+)");

        String line = reader.readLine();
        while (!"End".equals(line)) {
            Matcher matcher = switchPattern.matcher(line);
            if (matcher.find()) {
                String personName = matcher.group("personName");
                Person currPerson = new Person(personName);
                persons.putIfAbsent(personName, currPerson);
                String switchWith = matcher.group("switchWith");
                line = line.substring(matcher.end() + 1, line.length());
                switch (switchWith) {
                    case "company":
                        Matcher companyMatcher = companyPattern.matcher(line);
                        if (companyMatcher.find()) {
                            String companyName = companyMatcher.group("companyName");
                            String department = companyMatcher.group("department");
                            double salary = Double.parseDouble(companyMatcher.group("salary"));
                            Work currPersonWork = new Work(companyName, department, salary);
                            persons.get(personName).setCompany(currPersonWork);
                        }
                        break;
                    case "car":
                        Matcher carMatcher = carPattern.matcher(line);
                        if (carMatcher.find()) {
                            String carModel = carMatcher.group("carModel");
                            int carSpeed = Integer.parseInt(carMatcher.group("carSpeed"));
                            Car currPersonCar = new Car(carModel, carSpeed);
                            persons.get(personName).setPersonCar(currPersonCar);
                        }
                        break;
                    case "pokemon":
                        Matcher pokemonMatcher = pokemonPattern.matcher(line);
                        if (pokemonMatcher.find()) {
                            String pokemonName = pokemonMatcher.group("pokemonName");
                            String pokemonElement = pokemonMatcher.group("pokemonElement");
                            Pokemon currPokemon = new Pokemon(pokemonName, pokemonElement);
                            persons.get(personName).setPersonPokemons(currPokemon);
                        }
                        break;
                    case "parents":
                        Matcher parentsMatcher = parentPattern.matcher(line);
                        if (parentsMatcher.find()) {
                            String parentName = parentsMatcher.group("parentName");
                            String parentBird = parentsMatcher.group("parentBird");
                            FamilyMember currFamilyMember = new FamilyMember(parentName, parentBird);
                            persons.get(personName).setPersonPerents(currFamilyMember);
                        }
                        break;
                    case "children":
                        Matcher childrenMatcher = childPattern.matcher(line);
                        if (childrenMatcher.find()) {
                            String childName = childrenMatcher.group("childName");
                            String childBird = childrenMatcher.group("childBird");
                            FamilyMember currFamilyMember = new FamilyMember(childName, childBird);
                            persons.get(personName).setPersonChildren(currFamilyMember);
                        }
                        break;
                }
            }
            line = reader.readLine();
        }
        String printThisPerson = reader.readLine();
        System.out.println(persons.get(printThisPerson).toString());
    }
}