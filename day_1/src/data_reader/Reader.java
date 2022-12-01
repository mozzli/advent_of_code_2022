package data_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        ArrayList<String> listOfIntegers = new ArrayList<String>();
        String line;

        while ((line = text.readLine()) != null) {
            listOfIntegers.add(line);
        }
        return listOfIntegers;
    }
}
