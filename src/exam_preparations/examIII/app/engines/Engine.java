package exam_preparations.examIII.app.engines;

import app.core.AnimalCenterManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;
import static app.utilities.Constants.*;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private AnimalCenterManager animalCenterManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, AnimalCenterManager animalCenterManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.animalCenterManager = animalCenterManager;
    }

    public void run() {
        String inputLine;

        while(true) {
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

        switch(command) {
            case REGISTER_ADOPTION_CENTER_DEFAULT:
                this.animalCenterManager.registerAdoptionCenter(commandParams.get(0));
                break;
            case REGISTER_CLEANSING_CENTER_DEFAULT:
                this.animalCenterManager.registerCleansingCenter(commandParams.get(0));
                break;
            case REGISTER_DOG_DEFAULT:
                this.animalCenterManager.registerDog(commandParams.get(0),Integer.parseInt(commandParams.get(1)), Integer.parseInt(commandParams.get(2)), commandParams.get(3));
                break;
            case REGISTER_CAT_DEFAULT:
                this.animalCenterManager.registerCat(commandParams.get(0),Integer.parseInt(commandParams.get(1)), Integer.parseInt(commandParams.get(2)), commandParams.get(3));
                break;
            case SEND_FOR_CLEANSING_DEFAULT:
                this.animalCenterManager.sendForCleansing(commandParams.get(0), commandParams.get(1));
                break;
            case CLEANSE_DEFAULT:
                this.animalCenterManager.cleanse(commandParams.get(0));
                break;
            case ADOPT_DEFAULT:
                this.animalCenterManager.adopt(commandParams.get(0));
                break;
            case INPUT_TERMINATING_COMMAND:
                this.outputWriter.writeLine(this.animalCenterManager.printStatistics());
                break;
        }
    }
}