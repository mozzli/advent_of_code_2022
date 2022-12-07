package solutions;

import data_reader.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(Reader.getParsedInput());
        Solutions solutions = new Solutions();
        System.out.println(solutions.getDataSize(Reader.getParsedInput()));
        System.out.println(solutions.getFileToDeleteSize(Reader.getParsedInput()));
    }
}
