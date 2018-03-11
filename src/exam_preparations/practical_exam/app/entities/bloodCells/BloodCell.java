package exam_preparations.practical_exam.app.entities.bloodCells;

import app.entities.Cell;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public abstract class BloodCell extends Cell{
    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}