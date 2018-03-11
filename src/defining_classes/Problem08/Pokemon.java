package defining_classes.Problem08;

/**
 * Created by Chilly on 25.10.2017 г..
 */
public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth() {
        return this.health -= 10;
    }
}