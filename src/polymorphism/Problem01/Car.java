package polymorphism.Problem01;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class Car extends Vehicles{
    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + 0.9);
    }

    @Override
    protected void drive(double distance) {
        double needFuel = super.getFuelConsumptionPerKm() * distance;
        if (needFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Car needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - needFuel);
    }

    @Override
    protected void refuel(double litres) {
        super.setFuelQuantity((super.getFuelQuantity() + litres));
    }
}