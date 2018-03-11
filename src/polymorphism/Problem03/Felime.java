package polymorphism.Problem03;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public class Felime extends Mammal {
    public Felime(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "";
    }

    @Override
    public void eatFood(Food food) {
        super.setFoodEaten(food.getFoodQuantity());
    }
}
