package data_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        ArrayList<String> listOfIntegers = new ArrayList<>();
        String line;

        while ((line = text.readLine()) != null) {
            listOfIntegers.add(line);
        }
        return listOfIntegers;
    }

    public static ArrayList<ArrayList<String>> getRoundsList(ArrayList<String> input){
        ArrayList<ArrayList<String>> roundLists = new ArrayList<>();
        for (String round: input
             ) {
            ArrayList<String> roundList = new ArrayList<>();
            roundList.add(round.substring(0,1));
            roundList.add(round.substring(2,3));
            roundLists.add(roundList);
        }
        return roundLists;
    }

    public static ArrayList<ArrayList<Integer>> getMatchedInput() throws IOException {
        ArrayList<ArrayList<Integer>> coordinatesList = new ArrayList<>();
        ArrayList<String> input = get_input();
        Pattern pattern = Pattern.compile("([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)");
            for (String coordinate: input){
                ArrayList<Integer> coordinates = new ArrayList<>();
                Matcher m = pattern.matcher(coordinate);
                if (m.find()){
                    coordinates.add(Integer.parseInt(m.group(1)));
                    coordinates.add(Integer.parseInt(m.group(2)));
                    coordinates.add(Integer.parseInt(m.group(3)));
                    coordinates.add(Integer.parseInt(m.group(4)));
                coordinatesList.add(coordinates);
                }
            }
        return coordinatesList;
    }
}
