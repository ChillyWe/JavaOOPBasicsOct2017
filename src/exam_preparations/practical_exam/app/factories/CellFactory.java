package exam_preparations.practical_exam.app.factories;

import app.entities.Cell;
import app.entities.bloodCells.RedBloodCell;
import app.entities.bloodCells.WhiteBloodCell;
import app.entities.microbes.Bacteria;
import app.entities.microbes.Fungi;
import app.entities.microbes.Virus;

import static app.utilities.Constants.*;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public final class CellFactory {

    private CellFactory() {}

    public static Cell createCell(String cellTYpe, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        switch (cellTYpe){
            case RED_BLOOD_CELL_DEFAULT:
                return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case WHITE_BLOOD_CELL_DEFAULT:
                return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case BACTERIA_DEFAULT:
                return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
            case VIRUS_DEFAULT:
                return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            case FUNGI_DEFAULT:
                return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
            default:
                return null;
        }
    }
}