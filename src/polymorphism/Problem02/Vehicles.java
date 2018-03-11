package polymorphism.Problem02;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    protected Vehicles(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
        this.setTankCapacity(tankCapacity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    protected void driveEmpty(double distance) {}

    protected abstract void drive (double distance);

    protected abstract void refuel (double litres);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity).replace(",", ".");
    }
}