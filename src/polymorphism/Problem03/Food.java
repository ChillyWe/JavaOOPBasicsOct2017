package polymorphism.Problem03;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public abstract class Food {
    public static final String MEAT_DEFAULT = "Meat";
    public static final String VEGETABLE_DEFAULT = "Vegetable";

    private int foodQuantity;

    public Food(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public final int getFoodQuantity() {
        return this.foodQuantity;
    }
}