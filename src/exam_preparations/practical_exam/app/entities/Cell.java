package exam_preparations.practical_exam.app.entities;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public abstract class Cell {
	private String id;
	private int health;
	private int positionRow;
	private int positionCol;
	private int power;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
        this.power = 0;
    }

    public void replacePositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void replacePositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public void decreeseHealth(int increaseHealthIndex) {
        this.health -= increaseHealthIndex;
    }

    public void increaseHealth(int increaseHealthIndex) {
        this.health += increaseHealthIndex;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    protected int getHealth() {
        return this.health;
    }

    public abstract int getPower();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("------Cell %s [%d,%d]", this.id, this.positionRow, this.positionCol)).append(System.lineSeparator());

        return sb.toString();
    }
}