package exam_preparations.practical_exam.app.entities.microbes;

import app.entities.Cell;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public abstract class Microbe extends Cell{
    private int virulence;

    protected Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Virulence: %d | Energy:", super.toString(), super.getHealth(), this.virulence);
    }
}