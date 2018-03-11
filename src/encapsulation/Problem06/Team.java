package encapsulation.Problem06;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 02.11.2017 г..
 */
public class Team {
    private String name;
    private Map<String, Player> players;
    private double rating;

    public Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
        this.rating = 0.0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player players) {
        this.players.put(players.getName(), players);
    }

    public void removePlayer(String playerName) {
        if (players.containsKey(playerName)) {
            players.remove(playerName);
        }
        else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, getName()));
        }
    }

    private void setRating() {
        this.rating = players.values().stream().mapToDouble(Player::getAverage).average().getAsDouble();
    }

    public double getRating() {
        if (players.size() != 0) {
            setRating();
        }
        return this.rating;
    }
}