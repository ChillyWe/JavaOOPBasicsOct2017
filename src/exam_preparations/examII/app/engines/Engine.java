package exam_preparations.examII.app.engines;

import static app.utilities.Constants.*;

import app.core.CarManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager carManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.carManager = carManager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case REGISTER_DEFAULT:
                this.carManager.register(Integer.parseInt(commandParams.get(0)), commandParams.get(1), commandParams.get(2), commandParams.get(3), Integer.parseInt(commandParams.get(4)), Integer.parseInt(commandParams.get(5)), Integer.parseInt(commandParams.get(6)), Integer.parseInt(commandParams.get(7)), Integer.parseInt(commandParams.get(8)));
                break;
            case CHECK_DEFAULT:
                this.outputWriter.writeLine(this.carManager.check(Integer.parseInt(commandParams.get(0))));
                break;
            case OPEN:
                this.carManager.open(Integer.parseInt(commandParams.get(0)), commandParams.get(1), Integer.parseInt(commandParams.get(2)), commandParams.get(3), Integer.parseInt(commandParams.get(4)));
                break;
            case PARTICIPATE_DEFAULT:
                this.carManager.participate(Integer.parseInt(commandParams.get(0)), Integer.parseInt(commandParams.get(1)));
                break;
            case START_DEFAULT:
                try {
                    this.carManager.start(Integer.parseInt(commandParams.get(0)));
                } catch (IllegalStateException ise) {
                    this.outputWriter.writeLine(ise.getMessage());
                }
                //TODO String
                break;
            case PARK_DEFAULT:
                this.carManager.park(Integer.parseInt(commandParams.get(0)));
                break;
            case UNPARK_DEFAULT:
                this.carManager.unpark(Integer.parseInt(commandParams.get(0)));
                break;
            case TUNE_DEFAULT:
                this.carManager.tune(Integer.parseInt(commandParams.get(0)), commandParams.get(1));
                break;

        }
    }
}