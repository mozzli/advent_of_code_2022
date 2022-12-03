package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        SolutionOne solutionOne = new SolutionOne();
        SolutionTwo solutionTwo = new SolutionTwo();
        ArrayList<String> listOfRucksacks = Reader.get_input();

        System.out.println("The sum of priorities is equal: " + solutionOne.getPrioritySum(listOfRucksacks));
        System.out.println("the sum of group priorities is equal: " + solutionTwo.getGroupSumPriority(listOfRucksacks));
    }
}
