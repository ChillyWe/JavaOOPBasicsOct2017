package exam_preparations.practical_exam.app.core;

import app.entities.Cell;
import app.entities.Cluster;
import app.entities.Organism;
import app.factories.CellFactory;
import app.factories.ClusterFactory;
import app.factories.OrganismFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class HealthManager {
    Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public String checkCondition(String organismName) {
        if (organisms.containsKey(organismName)) {
            return organisms.get(organismName).toString();
        }
        else {
            return null;
        }
    }

    public String createOrganism(String name) {
        if (organisms.containsKey(name)) {
            return String.format("Organism %s already exists", name);
        } else {
            Organism currOrganism = OrganismFactory.createOrganism(name);
            organisms.putIfAbsent(name, currOrganism);
            return String.format("Created organism %s", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster currCluster = ClusterFactory.createCluster(id, rows, cols);
        if (organisms.containsKey(organismName) && !organisms.get(organismName).getClusters().containsKey(id)) {
            organisms.get(organismName).addCluster(currCluster);
            return String.format("Organism %s: Created cluster %s", organismName, id);
        } else {
            return null;
        }
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        Cell currCell = CellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);
        if(organisms.containsKey(organismName) && organisms.get(organismName).getClusters().containsKey(clusterId)) {
            organisms.get(organismName).getClusters().get(clusterId).addCells(currCell);
            return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
        }
        else {
            return null;
        }
    }

    public String activateCluster(String organismName) {
        if (organisms.containsKey(organismName)) {
            Organism currOrganism = organisms.get(organismName);
            if (currOrganism.getClusters().size() != 0) {
                Cluster nextCluster = currOrganism.getNextCluster();
                nextCluster.activateCluster();
                return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, nextCluster.getId(), nextCluster.getCells().size());
            }
        }
        return null;
    }
}