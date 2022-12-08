package data_reader;

import solutions.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Reader {

    static int maxRow = 0;

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        ArrayList<String> listOfIntegers = new ArrayList<>();
        String line;

        while ((line = text.readLine()) != null) {
            listOfIntegers.add(line);
        }
        return listOfIntegers;
    }

    public static Map<ArrayList<Integer>, Tree> getTreeDictionary() throws IOException {
        ArrayList<String> input = get_input();
        Map<ArrayList<Integer>, Tree> treeDict = new HashMap<>();
        int row = 1;
        int column;
        for (String line : input) {
            column = 1;
            for (Character number : line.toCharArray()) {
                int height = Integer.parseInt(String.valueOf(number));
                ArrayList<Integer> coor = new ArrayList<>(Arrays.asList(row, column));
                treeDict.put(coor, new Tree(height, coor));
                column++;
            }
            row++;
        }
        maxRow = input.get(0).length();
        return treeDict;
    }

    public static int getMaxRow() {
        return maxRow;
    }
}
