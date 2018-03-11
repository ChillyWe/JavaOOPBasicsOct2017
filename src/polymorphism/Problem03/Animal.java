package polymorphism.Problem03;

/**
 * Created by Chilly on 06.11.2017 г..
 */
public abstract class Animal {
    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    public Animal(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten += foodEaten;
    }

    protected String getName() {
        return this.name;
    }

    protected String getType() {
        return this.type;
    }

    protected double getWeight() {
        return this.weight;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    public abstract String makeSound();

    public abstract void eatFood(Food food);
}