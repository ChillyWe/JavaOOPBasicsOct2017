package inheritance.Problem04;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Predator extends Animal{
    private int health;

    public Predator() {
        this.health = 0;
    }

    public int getHealth() {
        return this.health;
    }

    public void feed(Food food) {
        super.eat(food);
        health++;
    }
}