package exam_preparations.examIV.app.entities.Hardwares;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public class PowerHardwareComponent extends HardwareComponent {
    public PowerHardwareComponent(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        int capacity = maximumCapacity - ((maximumCapacity * 3) / 4);
        super.setMaximumCapacity(capacity);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        int memory = maximumMemory + ((maximumMemory * 3) / 4);
        super.setMaximumMemory(memory);
    }
}