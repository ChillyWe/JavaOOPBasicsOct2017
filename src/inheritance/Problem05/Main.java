package inheritance.Problem05;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();
        ral.add("a");
        ral.add("b");
        ral.add("v");
        ral.add("3");
        ral.add("e");
        ral.add("g");
        ral.add("d");
        System.out.println(ral.getRandomElement().toString());
        System.out.println(ral.toString());
    }
}