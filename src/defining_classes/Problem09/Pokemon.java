package defining_classes.Problem09;

/**
 * Created by Chilly on 26.10.2017 г..
 */
public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.type);
    }
}
