package defining_classes.Problem08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 25.10.2017 г..
 */
public class Trainer {
    private final static int NUMBER_OF_BADGES_DEFAULT = 0;

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = NUMBER_OF_BADGES_DEFAULT;
        this.pokemons = new ArrayList<>();
    }

    public void setPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void setNumberOfBadges() {
        this.numberOfBadges++;
    }

    public void healthMinusMinus() {
        pokemons.forEach(Pokemon::setHealth);
    }

    public void deletePokemon(Pokemon deadPokemon) {
        pokemons.remove(deadPokemon);
    }
}