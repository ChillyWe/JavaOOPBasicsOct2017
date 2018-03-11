package polymorphism.Problem01;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class Truck extends Vehicles {
    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
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
        double truckFuel = litres * 0.95;
        super.setFuelQuantity((super.getFuelQuantity() + truckFuel));
    }
}