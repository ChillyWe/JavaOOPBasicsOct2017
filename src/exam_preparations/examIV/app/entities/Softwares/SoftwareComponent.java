package exam_preparations.examIV.app.entities.Softwares;

import app.entities.Component;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public abstract class SoftwareComponent extends Component {
    private int capacityConsumption;
    private int memoryConsumption;

    protected SoftwareComponent(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}