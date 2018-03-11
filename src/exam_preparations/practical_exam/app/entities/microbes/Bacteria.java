package exam_preparations.practical_exam.app.entities.microbes;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class Bacteria extends Microbe {
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getPower() {
        return (super.getHealth() + super.getVirulence()) / 3;
    }

    @Override
    public String toString() {
        return String.format("%s %d", super.toString(), this.getPower());
    }
}