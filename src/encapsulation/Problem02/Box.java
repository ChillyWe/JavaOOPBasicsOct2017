package encapsulation.Problem02;

/**
 * Created by Chilly on 27.10.2017 г..
 */
public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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