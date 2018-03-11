package defining_classes.Problem01;

import java.lang.reflect.Field;

/**
 * Created by Chilly on 23.10.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}