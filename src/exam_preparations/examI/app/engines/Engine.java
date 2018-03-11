package exam_preparations.examI.app.engines;

import app.core.Controller;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.Constant;
import app.utilities.InputParser;

import java.util.List;

/**
 * Created by Chilly on 07.11.2017 г..
 */
public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private Controller controller;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, Controller controller) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.controller = controller;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);

            if (Constant.QUIT_COMMAND.equalsIgnoreCase(inputLine)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "Bender":
                this.controller.createBender(commandParams.get(0), commandParams.get(1), Integer.parseInt(commandParams.get(2)), Double.parseDouble(commandParams.get(3)));
                break;
            case "Monument":
                this.controller.createMonument(commandParams.get(0), commandParams.get(1), Integer.parseInt(commandParams.get(2)));
                break;
            case "Status":
                this.outputWriter.writeLine(this.controller.getStatus(commandParams.get(0)));
                break;
            case "War":
                this.controller.startWar(commandParams.get(0));
                break;
            case "Quit":
                this.controller.wars.forEach(w -> outputWriter.writeLine(w));
                break;
        }
    }
}