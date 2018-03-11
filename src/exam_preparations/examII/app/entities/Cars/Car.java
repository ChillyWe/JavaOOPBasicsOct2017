package exam_preparations.examII.app.entities.Cars;

/**
 * Created by Chilly on 10.11.2017 г..
 */
public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getModel() {
        return this.model;
    }

    protected final int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public final int getHorsepower() {
        return this.horsepower;
    }

    public final int getAcceleration() {
        return this.acceleration;
    }

    public final int getSuspension() {
        return this.suspension;
    }

    public final int getDurability() {
        return this.durability;
    }

    public abstract void tuneCar(int index, String addOns);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d", this.getBrand(), this.getModel(), this.getYearOfProduction())).append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s", this.getHorsepower(), this.getAcceleration())).append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability())).append(System.lineSeparator());

        return sb.toString();
    }
}