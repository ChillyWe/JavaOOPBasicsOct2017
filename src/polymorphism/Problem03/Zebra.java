package polymorphism.Problem03;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public class Zebra extends Mammal{

    public Zebra(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
       return "Zs";
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals(Food.MEAT_DEFAULT)) {
            throw new IllegalStateException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(food.getFoodQuantity());
    }
}