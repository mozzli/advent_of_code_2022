package solutions;

import data_reader.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        System.out.println(solutions.getSandAmount(false));
        System.out.println(solutions.getSandAmount(true));
    }
}
