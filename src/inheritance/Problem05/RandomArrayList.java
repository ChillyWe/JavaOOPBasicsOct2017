package inheritance.Problem05;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class RandomArrayList<Object> extends ArrayList {
    Random rnd = new Random();

    public Object getRandomElement() {
        int index = rnd.nextInt(super.size() - 1);
        return (Object) super.remove(index);
    }
}