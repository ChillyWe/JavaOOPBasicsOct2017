package exam_preparations.examIII.app.entities.Animals;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public abstract class Animal {
    private String name;
    private int age;
    private boolean isClean;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.isClean = false;
    }

    public boolean isClean() {
        return this.isClean;
    }

    public void cleanIt() {
        this.isClean = true;
    }

    public String getName() {
        return this.name;
    }

    public abstract String getAdoptionCenter();
}