package exam_preparations.examIII.app;

import app.core.AnimalCenterManager;
import app.engines.Engine;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

/**
 * Created by Chilly on 09.11.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, animalCenterManager);

        engine.run();
    }
}