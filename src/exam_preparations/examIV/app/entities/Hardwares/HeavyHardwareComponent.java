package exam_preparations.examIV.app.entities.Hardwares;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public class HeavyHardwareComponent extends HardwareComponent {
    public HeavyHardwareComponent(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        int capacity = maximumCapacity * 2;
        super.setMaximumCapacity(capacity);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        int memory = maximumMemory - (maximumMemory / 4);
        super.setMaximumMemory(memory);
    }
}