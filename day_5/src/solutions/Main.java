package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        ArrayList<String> solutionOne = solutions.getHighestCargos(Reader.getCargoList(), Reader.getInputList(),CraneType.CRATEMOVER_9000);
        System.out.println("The top crates of each stack are: " + solutionOne + "\n");
        ArrayList<String> solutionTwo = solutions.getHighestCargos(Reader.getCargoList(), Reader.getInputList(),CraneType.CRATEMOVER_9001);
        System.out.println("The top crates of each stack are: " + solutionTwo);

    }
}
