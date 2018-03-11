package exam_preparations.examIII.app.entities.Centers;

import app.entities.Animals.Animal;

import java.util.*;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public abstract class Center {
    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public void clearAnimals() {
        this.animals.stream().filter(animal -> !animal.isClean()).forEach(Animal::cleanIt);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    public void clearCenter() {
        animals.clear();
    }
}