package defining_classes.Problem09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 26.10.2017 г..
 */
public class Person {
    private String name;
    private Work company;
    private Car personCar;
    private List<Pokemon> personPokemons;
    private List<FamilyMember> personParents;
    private List<FamilyMember> personChildren;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.personCar = null;
        this.personPokemons = new ArrayList<>();
        this.personParents = new ArrayList<>();
        this.personChildren = new ArrayList<>();
    }

    public void setCompany(Work company) {
        this.company = company;
    }

    public void setPersonCar(Car personCar) {
        this.personCar = personCar;
    }

    public void setPersonPokemons(Pokemon pokemon) {
        this.personPokemons.add(pokemon);
    }

    public void setPersonPerents(FamilyMember parent) {
        this.personParents.add(parent);
    }

    public void setPersonChildren(FamilyMember child) {
        this.personChildren.add(child);
    }

    @Override
    public String toString() {
        StringBuilder personBuilder = new StringBuilder();
        personBuilder.append(name).append(System.lineSeparator());
        personBuilder.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            personBuilder.append(this.company).append(System.lineSeparator());
        }
        personBuilder.append("Car:").append(System.lineSeparator());
        if (this.personCar != null) {
            personBuilder.append(this.personCar).append(System.lineSeparator());
        }
        personBuilder.append("Pokemon:").append(System.lineSeparator());
        if (!this.personPokemons.isEmpty()) {
            for (Pokemon pokemon : personPokemons) {
                personBuilder.append(pokemon).append(System.lineSeparator());
            }
        }
        personBuilder.append("Parents:").append(System.lineSeparator());
        if (!this.personParents.isEmpty()) {
            for (FamilyMember parent : personParents) {
                personBuilder.append(parent).append(System.lineSeparator());
            }
        }
        personBuilder.append("Children:").append(System.lineSeparator());
        if (!this.personChildren.isEmpty()) {
            for (FamilyMember child : personChildren) {
                personBuilder.append(child).append(System.lineSeparator());
            }
        }
        return personBuilder.toString();
    }
}