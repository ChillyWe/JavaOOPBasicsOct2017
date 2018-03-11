package exam_preparations.examI.app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chilly on 07.11.2017 г..
 */
public class InputParser {
    public InputParser() {}

    public List<String> parseInput (String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split("\\s+")));
    }
}