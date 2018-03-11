package exam_preparations.examIV.app.entities;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public abstract class Component {
    private String name;
    private String type;
    private int capacity;
    private int memory;

    protected Component(String name, String type) {
        this.name = name;
        this.type = type;
        this.capacity = 0;
        this.memory = 0;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final int getMemory() {
        return this.memory;
    }
}