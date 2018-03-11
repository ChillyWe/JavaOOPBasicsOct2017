package inheritance.Problem04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Animal {
    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        foodEaten.add(food);
    }

    public final void eatAll(Food[] foods) {
        for (Food food : foods) {
            eat(food);
        }
    }
}