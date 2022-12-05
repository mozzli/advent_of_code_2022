package data_reader;

import solutions.Inputs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public static Map<Integer,ArrayList<String>> getCargoList() throws IOException {

        Map<Integer,ArrayList<String>> cargoMap = new HashMap<>(9);
        for (int i = 1; i<10; i++){
            cargoMap.put(i,new ArrayList<>());
        }
        ArrayList<String> input = get_input();
        Pattern pattern = Pattern.compile("(.{3,}) (.{3,}) (.{3,}) (.{3,}) (.{3,}) (.{3,}) (.{3,}) (.{3,}) (.{3,})");
            for (int row = 7; row >= 0; row--){
                Matcher m = pattern.matcher(input.get(row));
                if (m.find()){
                    for (int column = 1; column < 10; column++){
                        if (!m.group(column).equals("   ")){
                            cargoMap.get(column).add(m.group(column).substring(1,2));
                        }
                    }
                }
            }
        return cargoMap;
    }

    public static ArrayList<Map<Inputs,Integer>> getInputList() throws IOException {
        ArrayList<String> inputMain = get_input();
        Pattern pattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
        ArrayList<Map<Inputs,Integer>> output = new ArrayList<>();
        for (int i = 10; i < inputMain.size(); i++){
            Matcher m = pattern.matcher(inputMain.get(i));
            Map<Inputs,Integer> inputs = new HashMap<>();
            if (m.find()){
                inputs.put(Inputs.CARGO_AMOUNT,Integer.parseInt(m.group(1)));
                inputs.put(Inputs.FROM_COLUMN,Integer.parseInt(m.group(2)));
                inputs.put(Inputs.TO_COLUMN,Integer.parseInt(m.group(3)));
            }
            output.add(inputs);
        }
        return output;
    }
}
