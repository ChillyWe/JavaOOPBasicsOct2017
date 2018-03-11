package defining_classes.Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chilly on 30.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> catData = new LinkedHashMap<>();

        while (true) {
            String line = reader.readLine();
            if ("end".equalsIgnoreCase(line)) {
                break;
            }
            String[] catTokens = line.split("\\s+");
            Cat currCat = null;
            switch (catTokens[0]) {
                case "Siamese":
                    currCat = new Siamese(catTokens[1], Double.parseDouble(catTokens[2]));
                    break;
                case "Cymric":
                    currCat = new Cymric(catTokens[1], Double.parseDouble(catTokens[2]));
                    break;
                case "StreetExtraordinaire":
                    currCat = new StreetExtraordinaire(catTokens[1], Double.parseDouble(catTokens[2]));
                    break;
            }
            catData.putIfAbsent(catTokens[1], currCat);
        }
        String printThisCat = reader.readLine();
        if (catData.containsKey(printThisCat)) {
            System.out.println(catData.get(printThisCat));
        }
    }
}