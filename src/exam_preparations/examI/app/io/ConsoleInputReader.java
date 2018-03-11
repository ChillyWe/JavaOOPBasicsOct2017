package exam_preparations.examI.app.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 07.11.2017 г..
 */
public class ConsoleInputReader {
    private BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() {
        String result = null;
        try {
            result = this.reader.readLine();
        }
        catch (IOException e) { }

        return result;
    }
}