package inheritance.Problem04;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Main {
    public static void main(String[] args) {

        Predator predator = new Predator();
        predator.feed(new Food());

        System.out.println("predator health = " + predator.getHealth());
    }
}