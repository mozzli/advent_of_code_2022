package data_reader;

import solutions.Pocket;

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
        ArrayList<String> listOfStrings = new ArrayList<>();
        String line;
        while ((line = text.readLine()) != null) {
            if (!line.equals("")) listOfStrings.add(line);
        }
        return listOfStrings;
    }

    public static ArrayList<Pocket> getPockets() throws IOException {
        ArrayList<String> lines = get_input();
        ArrayList<Pocket> pocketsList= new ArrayList<>();
        for (String line : lines){
            pocketsList.add(new Pocket(line));
            }
        return pocketsList;
        }
    }
