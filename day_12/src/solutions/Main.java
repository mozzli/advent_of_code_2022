package solutions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        System.out.println("Lowest step count from the start needed: " + solutions.getSteps(1, new ArrayList<>(Arrays.asList(1, 1))));
        System.out.println("Lowest step count from any 'a' needed : " + solutions.getLowestSteps());
    }
}
