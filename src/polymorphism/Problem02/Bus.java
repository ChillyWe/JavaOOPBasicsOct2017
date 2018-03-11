package polymorphism.Problem02;

/**
 * Created by Chilly on 04.11.2017 г..
 */
public class Bus extends Vehicles{
    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + 1.4);
    }

    public void driveEmpty(double distance) {
        double needFuel = (super.getFuelConsumptionPerKm() - 1.4) * distance;
        if (needFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Bus needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - needFuel);
    }

    @Override
    protected void drive(double distance) {
        double needFuel = super.getFuelConsumptionPerKm() * distance;
        if (needFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Bus needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - needFuel);
    }

    @Override
    protected void refuel(double litres) {
        if (litres > super.getTankCapacity()) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        } else if(litres <= 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }
        super.setFuelQuantity((super.getFuelQuantity() + litres));
    }
}