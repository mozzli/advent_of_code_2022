package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<String>> input = Reader.getParsedInput();
        Solutions solutions = new Solutions();
        System.out.println("Signal strength is: " + solutions.getSignalStrength(input) + "\n");
        System.out.println("Image: ");
        solutions.getSpriteOutput(input);
    }
}
