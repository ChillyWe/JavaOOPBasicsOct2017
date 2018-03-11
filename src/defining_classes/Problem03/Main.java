package defining_classes.Problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 24.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] personData = reader.readLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            Person currPerson = new Person(name, age);
            persons.add(currPerson);
        }
        persons.sort((a,b) -> a.name.compareTo(b.name));
        for (Person person : persons) {
            if (person.age > 30) {
                System.out.printf("%s - %d\n", person.name, person.age);
            }
        }
    }
}