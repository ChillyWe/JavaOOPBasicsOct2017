package exam_preparations.practical_exam.app.factories;

import app.entities.Organism;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public final class OrganismFactory {
    private OrganismFactory() {}

    public static Organism createOrganism(String name) {
        return new Organism(name);
    }
}