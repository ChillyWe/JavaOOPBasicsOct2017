package defining_classes.Problem09;

/**
 * Created by Chilly on 26.10.2017 г..
 */
public class Work {
    private String companyName;
    private String department;
    private double salary;

    public Work(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.companyName, this.department, this.salary).replace(",", ".");
    }
}
