package exam_preparations.examI.app.entities.Monuments;

/**
 * Created by Chilly on 08.11.2017 г..
 */
public abstract class Monument {
    private String name;

    public Monument(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    public abstract int getMonumentPower();
}