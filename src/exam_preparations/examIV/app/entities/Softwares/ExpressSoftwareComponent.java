package exam_preparations.examIV.app.entities.Softwares;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public class ExpressSoftwareComponent extends SoftwareComponent {
    public ExpressSoftwareComponent(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        int consumption = memoryConsumption * 2;
        super.setMemoryConsumption(consumption);
    }
}