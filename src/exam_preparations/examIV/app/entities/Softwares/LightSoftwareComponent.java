package exam_preparations.examIV.app.entities.Softwares;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public class LightSoftwareComponent extends SoftwareComponent {
    public LightSoftwareComponent(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        int consumption = capacityConsumption + ((capacityConsumption * 50) / 100);
        super.setCapacityConsumption(consumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        int memory = memoryConsumption - ((memoryConsumption * 50) / 100);
        super.setMemoryConsumption(memory);
    }
}