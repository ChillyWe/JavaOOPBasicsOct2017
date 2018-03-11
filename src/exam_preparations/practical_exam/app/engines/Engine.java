package exam_preparations.practical_exam.app.engines;

import app.core.HealthManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

import static app.utilities.Constants.*;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, HealthManager healthManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.healthManager = healthManager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            String result = this.dispatchCommand(commandParams);
            if (result != null) {
                this.outputWriter.writeLine(result);
            }
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                break;
            }
        }
    }

    private String dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case CHECK_CONDITION_DEFAULT:
                return this.healthManager.checkCondition(commandParams.get(0));
            case CREATE_ORGANISM_DEFAULT:
                return this.healthManager.createOrganism(commandParams.get(0));
            case ADD_CLUSTER_DEFAULT:
                return this.healthManager.addCluster(commandParams.get(0), commandParams.get(1), Integer.parseInt(commandParams.get(2)), Integer.parseInt(commandParams.get(3)));
            case ADD_CELL_DEFAULT:
                return this.healthManager.addCell(commandParams.get(0), commandParams.get(1), commandParams.get(2), commandParams.get(3), Integer.parseInt(commandParams.get(4)), Integer.parseInt(commandParams.get(5)), Integer.parseInt(commandParams.get(6)), Integer.parseInt(commandParams.get(7)));
            case ACTIVATE_CLUSTER_DEFAULT:
                return this.healthManager.activateCluster(commandParams.get(0));
            default:
                return null;
        }
    }
}