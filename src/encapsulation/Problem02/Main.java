package encapsulation.Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 27.10.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f\n", box.surFaceArea());
            System.out.printf("Lateral Surface Area - %.2f\n", box.lateralSurfaceArea());
            System.out.printf("Volume - %.2f", box.volume());
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}