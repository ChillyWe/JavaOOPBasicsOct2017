package polymorphism.Problem02;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class Truck extends Vehicles {
    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + 1.6);
    }

    @Override
    protected void drive(double distance) {
        double needFuel = super.getFuelConsumptionPerKm() * distance;
        if (needFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Truck needs refueling");
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
        double truckFuel = litres * 0.95;
        super.setFuelQuantity((super.getFuelQuantity() + truckFuel));
    }
}