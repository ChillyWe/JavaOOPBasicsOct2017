package encapsulation.Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 02.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();

        String line;
        while (true) {
            if ("end".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split(";");
            try {
                switch (tokens[0]) {
                    case "Team":
                        teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                        break;
                    case "Add":
                        if (!teams.containsKey(tokens[1])) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", tokens[1]));
                        }
                        teams.get(tokens[1]).addPlayer(new Player(tokens[2], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
                        break;
                    case "Remove":
                        teams.get(tokens[1]).removePlayer(tokens[2]);
                        break;
                    case "Rating":
                        if (!teams.containsKey(tokens[1])) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", tokens[1]));
                        }
                        System.out.println(String.format("%s - %.0f", tokens[1], teams.get(tokens[1]).getRating()));
                        break;
                }
            }
            catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}