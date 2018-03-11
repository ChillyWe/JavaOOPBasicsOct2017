package exam_preparations.examI.app;

import app.core.Controller;
import app.engines.Engine;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

/**
 * Created by Chilly on 07.11.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        Controller Controller = new Controller();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, Controller);

        engine.run();
    }
}