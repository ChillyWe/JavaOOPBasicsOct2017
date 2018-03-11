package polymorphism.Problem03;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public class Tiger extends Felime{
    public Tiger(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals(Food.VEGETABLE_DEFAULT)) {
            throw new IllegalStateException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(food.getFoodQuantity());
    }
}