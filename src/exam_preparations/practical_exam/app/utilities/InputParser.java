package exam_preparations.practical_exam.app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    public InputParser() {}

    public List<String> parseInput(String inputLine) {
        return new ArrayList<>(Arrays.asList(inputLine.split("\\s+")));
    }
}