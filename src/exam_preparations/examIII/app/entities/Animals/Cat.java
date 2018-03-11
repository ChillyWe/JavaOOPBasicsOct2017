package exam_preparations.examIII.app.entities.Animals;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public class Cat extends Animal {
    private int intelligenceCoefficient;
    private String adoptionCenter;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public Cat(String name, int age, int intelligenceCoefficient, String adoptionCenter) {
        this(name, age, intelligenceCoefficient);
        this.adoptionCenter = adoptionCenter;
    }

    @Override
    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }
}