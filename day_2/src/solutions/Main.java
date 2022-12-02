package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        SolutionTwo solutionTwo = new SolutionTwo();

        ArrayList<String> tournamentList = Reader.get_input();
        ArrayList<ArrayList<String>> roundLists = Reader.getRoundsList(tournamentList);
        System.out.println("First solution: " + solution.getTotalScore(roundLists));
        System.out.println("Second solution: " + solutionTwo.getTotalScore(roundLists));
    }
}
