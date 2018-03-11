package encapsulation.Problem01;

/**
 * Created by Chilly on 27.10.2017 г..
 */
public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double surFaceArea() {
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double lateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);
    }

    public double volume() {
        return length * width * height;
    }
}