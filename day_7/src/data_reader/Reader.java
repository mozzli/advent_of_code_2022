package data_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    public static String getStringInput() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        return text.readLine();
    }

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        ArrayList<String> listOfIntegers = new ArrayList<>();
        String line;

        while ((line = text.readLine()) != null) {
            listOfIntegers.add(line);
        }
        return listOfIntegers;
    }

    public static ArrayList<ArrayList<String>> getParsedInput() throws IOException {
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> input = get_input();
        Pattern p = Pattern.compile("([\\S]+) ([\\S]+) ([\\S]+)|([\\S]+) ([\\S]+)");
        for (String command : input) {
            Matcher m = p.matcher(command);
            ArrayList<String> newCommand = new ArrayList<>();
            if (m.find()) {
                if (m.group(4) == null) {
                    newCommand.add(m.group(1));
                    newCommand.add(m.group(2));
                    newCommand.add(m.group(3));
                } else {
                    newCommand.add(m.group(4));
                    newCommand.add(m.group(5));
                }
            }
            output.add(newCommand);
        }
        return output;
    }
}
