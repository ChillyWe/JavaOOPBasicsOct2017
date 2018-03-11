package exam_preparations.practical_exam.app.entities;

import app.entities.bloodCells.WhiteBloodCell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static app.utilities.Constants.*;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class Cluster {
	private String id;  // – a string that describes the name of the cluster, unique property;
	private int rows;  // – a positive integer that describes how many rows the cluster has;
	private int cols;  // – a positive integer that describes how many columns the cluster has;
	private List<Cell> cells;  // – a collection of objects of type Cell;
    private Comparator<Cell> byRow = Comparator.comparingInt(Cell::getPositionRow);
    private Comparator<Cell> byCol = Comparator.comparingInt(Cell::getPositionCol);

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public void addCells(Cell cell) {
        this.cells.add(cell);
    }

    public String getId() {
        return id;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    public void activateCluster(){
        List<Cell> workWithThisList = cells.stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList());
        if (workWithThisList.size() != 0) {
            Cell startCell = workWithThisList.get(0);

            for (int i = 1; i < workWithThisList.size(); i++) {
                Cell currCell = workWithThisList.get(i);
                if (currCell.getPositionRow() > this.rows || currCell.getPositionCol() > this.cols) {
                    break;
                }
                if (startCell.getClass().getSimpleName().equals(RED_BLOOD_CELL_DEFAULT) || startCell.getClass().getSimpleName().equals(WHITE_BLOOD_CELL_DEFAULT)) {
                    startCell.increaseHealth(currCell.getHealth());
                    startCell.replacePositionRow(currCell.getPositionRow());
                    startCell.replacePositionCol(currCell.getPositionCol());
                    this.cells.remove(currCell);
                } else {
                    while (true) {
                        currCell.decreeseHealth(startCell.getPower());
                        if (currCell.getHealth() <= 0) {
                            startCell.replacePositionRow(currCell.getPositionRow());
                            startCell.replacePositionCol(currCell.getPositionCol());
                            this.cells.remove(currCell);
                            break;
                        }
                        startCell.decreeseHealth(currCell.getPower());
                        if (startCell.getHealth() <= 0) {
                            this.cells.remove(startCell);
                            startCell = currCell;
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("----Cluster %s", this.id)).append(System.lineSeparator());

        for (Cell cell : cells.stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList())) {
            sb.append(cell.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}