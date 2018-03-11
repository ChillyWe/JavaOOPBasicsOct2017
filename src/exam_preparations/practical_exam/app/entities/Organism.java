package exam_preparations.practical_exam.app.entities;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    private int getCellCount () {
        int count = 0;
        for (Cluster cluster : clusters.values()) {
            count += cluster.getCells().size();
        }
        return count;
    }

    public Cluster getNextCluster () {
        String clusterID = "";
        Cluster currCluster = null;
        for (Cluster cluster : clusters.values()) {
            currCluster = cluster;
            clusterID = cluster.getId();
            break;
        }
        clusters.remove(clusterID);
        clusters.put(clusterID, currCluster);
        return currCluster;
    }

    public void addCluster(Cluster cluster) {
        this.clusters.putIfAbsent(cluster.getId(), cluster);
    }

    public Map<String, Cluster> getClusters() {
        return Collections.unmodifiableMap(this.clusters);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("Organism - %s", this.name)).append(System.lineSeparator())
               .append(String.format("--Clusters: %d", this.clusters.size())).append(System.lineSeparator())
               .append(String.format("--Cells: %d", getCellCount())).append(System.lineSeparator());
        for (Cluster cluster : clusters.values()) {
            sb.append(cluster.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}