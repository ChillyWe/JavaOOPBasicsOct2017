package exam_preparations.examIII.app.core;

import app.entities.Animals.Animal;
import app.entities.Centers.*;
import app.factories.AnimalFactory;
import app.factories.CenterFactory;

import static app.utilities.Constants.*;

import java.util.*;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public class AnimalCenterManager {
    private static Map<String, Center> adoptionCenters = new HashMap<>();
    private static Map<String, Center> cleansingCenters = new HashMap<>();
    private TreeSet<String> adoptedAnimals = new TreeSet<String>();
    private TreeSet<String> cleansedAnimals = new TreeSet<String>();

    public void registerCleansingCenter(String name) {
        cleansingCenters.putIfAbsent(name, CenterFactory.createCenter(CLEANSING_DEFAULT, name));
    }

    public void registerAdoptionCenter(String name) {
        adoptionCenters.putIfAbsent(name, CenterFactory.createCenter(ADOPTION_DEFAULT, name));
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            adoptionCenters.get(adoptionCenterName).addAnimal(AnimalFactory.createAnimal(DOG_DEFAULT, name, age, learnedCommands, adoptionCenterName));
        }
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            adoptionCenters.get(adoptionCenterName).addAnimal(AnimalFactory.createAnimal(CAT_DEFAULT, name, age, intelligenceCoefficient, adoptionCenterName));
        }
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        if (adoptionCenters.containsKey(adoptionCenterName) && cleansingCenters.containsKey(cleansingCenterName)) {
            List<Animal> currAnimals = adoptionCenters.get(adoptionCenterName).getAnimals();
            for (Animal animal : currAnimals) {
                cleansingCenters.get(cleansingCenterName).addAnimal(animal);
            }
            adoptionCenters.get(adoptionCenterName).clearCenter();
        }
    }

    public void cleanse(String cleansingCenterName) {
        cleansingCenters.get(cleansingCenterName).clearAnimals();
        List<Animal> animals = cleansingCenters.get(cleansingCenterName).getAnimals();
        for (Animal animal : animals) {
            if (adoptionCenters.containsKey(animal.getAdoptionCenter())) {
                cleansedAnimals.add(animal.getName());
                adoptionCenters.get(animal.getAdoptionCenter()).addAnimal(animal);
            }
        }
        for (Animal animal : animals) {
            if (animal.isClean()) {
                adoptionCenters.get(animal.getAdoptionCenter()).addAnimal(animal);
            }
        }
        cleansingCenters.get(cleansingCenterName).clearCenter();
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> removeThisAnimals = new ArrayList<>();
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            for (Animal animal : adoptionCenters.get(adoptionCenterName).getAnimals()) {
                if (animal.isClean()) {
                    adoptedAnimals.add(animal.getName());
                    removeThisAnimals.add(animal);
                }
            }
            for (Animal removeThisAnimal : removeThisAnimals) {
                adoptionCenters.get(adoptionCenterName).removeAnimal(removeThisAnimal);
            }
        }
    }

    public String printStatistics() {
        StringBuilder builder = new StringBuilder("Paw Incorporative Regular Statistics").append(System.lineSeparator())
                .append("Adoption Centers: ").append(adoptionCenters.size()).append(System.lineSeparator())
                .append("Cleansing Centers: ").append(cleansingCenters.size()).append(System.lineSeparator())
                .append("Adopted Animals: ");
        if (adoptedAnimals.size() == 0) {
            builder.append("None").append(System.lineSeparator());
        } else {
            builder.append(String.join(", ", adoptedAnimals)).append(System.lineSeparator());

        }
        builder.append("Cleansed Animals: ");
        if (cleansedAnimals.size() == 0) {
            builder.append("None").append(System.lineSeparator());
        } else {
            builder.append(String.join(", ", cleansedAnimals)).append(System.lineSeparator());

        }
        builder.append("Animals Awaiting Adoption: ").append(getCountForPetWhoAreReadyForAdopt()).append(System.lineSeparator())
                .append("Animals Awaiting Cleansing: ").append(getCountForPetWhoAreAwaitingCleansing());
        return builder.toString();
    }

    private int getCountForPetWhoAreAwaitingCleansing() {
        int count = 0;
        for (Center center : cleansingCenters.values()) {
            List<Animal> animals = center.getAnimals();
            for (Animal animal : animals) {
                if (!animal.isClean()) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getCountForPetWhoAreReadyForAdopt() {
        int count = 0;
        for (Center center : adoptionCenters.values()) {
            for (Animal animal : center.getAnimals()) {
                if (animal.isClean()) {
                    count++;
                }
            }
        }
        return count;
    }
}