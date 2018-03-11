package exam_preparations.practical_exam.app.entities.bloodCells;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public int getPower() {
        return (super.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Size: %d | Energy: %d", super.toString(), super.getHealth(), this.size, this.getPower());
    }
}