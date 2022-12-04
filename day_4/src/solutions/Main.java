package solutions;

import data_reader.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SolutionOne solutionOne = new SolutionOne();
        SolutionTwo solutionTwo = new SolutionTwo();
        System.out.println("There are " + solutionOne.getPairs( Reader.getMatchedInput()) + " fully overlapping pairs");
        System.out.println("There are " + solutionTwo.getOverlappingSum(Reader.getMatchedInput()) + " overlapping pairs");
    }
}
