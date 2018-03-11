package exam_preparations.practical_exam.app;

import app.core.HealthManager;
import app.engines.Engine;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        HealthManager healthManager = new HealthManager();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();

        Engine engine = new Engine(inputReader, outputWriter, inputParser, healthManager);

        engine.run();
    }
}