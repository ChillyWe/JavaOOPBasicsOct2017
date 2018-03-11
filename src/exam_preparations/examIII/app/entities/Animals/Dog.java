package exam_preparations.examIII.app.entities.Animals;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public class Dog extends Animal {
    private int amountOfCommands;
    private String adoptionCenter;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
    }

    public Dog(String name, int age, int amountOfCommands, String adoptionCenter) {
        this(name, age, amountOfCommands);
        this.adoptionCenter = adoptionCenter;
    }

    @Override
    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }
}