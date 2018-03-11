package exam_preparations.practical_exam.app.entities.bloodCells;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class RedBloodCell extends BloodCell{
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public int getPower() {
        return super.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Velocity: %d | Energy: %d", super.toString(), super.getHealth(), this.velocity, this.getPower());
    }
}