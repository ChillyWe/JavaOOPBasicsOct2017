package exam_preparations.practical_exam.app.factories;

import app.entities.Cluster;

/**
 * Created by Chilly on 12.11.2017 г..
 */
public final class ClusterFactory {
    private ClusterFactory() {}

    public static Cluster createCluster(String id, int rows, int cols) {
        return new Cluster(id, rows, cols);
    }
}