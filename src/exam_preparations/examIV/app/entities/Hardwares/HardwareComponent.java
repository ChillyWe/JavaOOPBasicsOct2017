package exam_preparations.examIV.app.entities.Hardwares;

import app.entities.Component;
import app.entities.Softwares.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 11.11.2017 г..
 */
public abstract class HardwareComponent extends Component{
    private int maximumCapacity;
    private int maximumMemory;
    private List<SoftwareComponent> softweres;

    protected HardwareComponent(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softweres = new ArrayList<>();
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {

    }
}