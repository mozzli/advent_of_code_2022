package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        Map<ArrayList<Integer>, Tree> bookOfTrees = Reader.getTreeDictionary();
        System.out.println("There are " + solutions.getVisibleTreeAmount(bookOfTrees) + " visible trees");
        System.out.println("The highest view score is: " + solutions.getHighestViewScore(bookOfTrees));
    }
}
