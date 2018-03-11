package defining_classes.Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chilly on 25.10.2017 г..
 */
public class Main {
    public static Map<String, Trainer> trainersData = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            if (line.equals("Tournament") || line.equals("")) {
                break;
            }
            fillTrainers(line);
        }
        if (trainersData.size() > 0) {
            while (true) {
                String currElement = reader.readLine();
                if (currElement.equals("End") || currElement.equals("")) {
                    break;
                }
                switch (currElement) {
                    case "Fire":
                        action(currElement);
                        break;
                    case "Water":
                        action(currElement);
                        break;
                    case "Electricity":
                        action(currElement);
                        break;
                }
            }
        }
        trainersData.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().getNumberOfBadges(), a.getValue().getNumberOfBadges()))
                .forEach(trainer -> System.out.printf("%s %d %d\n", trainer.getKey(), trainer.getValue().getNumberOfBadges(), trainer.getValue().getPokemons().size()));

    }

    private static void removeDead() {
        for (Map.Entry<String, Trainer> kvp : trainersData.entrySet()) {
            for (int i = 0; i < kvp.getValue().getPokemons().size(); i++) {
                if (kvp.getValue().getPokemons().get(i).getHealth() <= 0) {
                    kvp.getValue().deletePokemon(kvp.getValue().getPokemons().get(i));
                }
            }
        }
    }

    private static void action(String currElement) {
        for (Trainer trainer : trainersData.values()) {
            List<Pokemon> pokemons = trainersData.get(trainer.getName()).getPokemons();
            boolean isTherePokemonWithCurrElement = false;
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getElement().equals(currElement)) {
                    trainer.setNumberOfBadges();
                    isTherePokemonWithCurrElement = true;
                }
            }
            if (!isTherePokemonWithCurrElement) {
                trainersData.get(trainer.getName()).healthMinusMinus();
            }
        }
        removeDead();
    }

    private static void fillTrainers(String line) {
        String[] tokens = line.split("\\s+");
        String trainerName = tokens[0];
        trainersData.putIfAbsent(trainerName, new Trainer(trainerName));

        String pokemonName = tokens[1];
        String element = tokens[2];
        int health = Integer.parseInt(tokens[3]);
        trainersData.get(trainerName).setPokemons(new Pokemon(pokemonName, element, health));
    }
}