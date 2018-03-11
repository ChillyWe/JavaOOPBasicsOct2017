package polymorphism.Problem01;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    protected Vehicles(double fuelQuantity, double fuelConsumptionPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    protected abstract void drive (double distance);

    protected abstract void refuel (double litres);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity).replace(",", ".");
    }
}