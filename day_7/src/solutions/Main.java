package solutions;

import data_reader.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        System.out.println("Sum of the total sizes of directories with size under 10000: " + solutions.getDataSize(Reader.getParsedInput()));
        System.out.println("Total size of biggest needed to be deleted directory: " +  solutions.getFileToDeleteSize(Reader.getParsedInput()));
    }
}
