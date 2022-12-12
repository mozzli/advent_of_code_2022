package data_reader;

import solutions.Monkey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        StringBuilder oneLine = new StringBuilder();
        ArrayList<String> listOfIntegers = new ArrayList<>();
        String line;

        while ((line = text.readLine()) != null) {
            oneLine.append(line).append("\n");
            if (line.equals("")) {
                listOfIntegers.add(oneLine.toString());
                oneLine.delete(0, oneLine.length());
            }
        }
        return listOfIntegers;
    }

    public static ArrayList<Monkey> getParsedInput() throws IOException {
        ArrayList<Monkey> output = new ArrayList<>();
        ArrayList<String> input = get_input();
        Pattern p = Pattern.compile("Monkey (\\d):\n" +
                "  Starting items: (.*)\n" +
                "  Operation: new = old (\\W) (.*)\n" +
                "  Test: divisible by (\\d+)\n" +
                "    If true: throw to monkey (\\d)\n" +
                "    If false: throw to monkey (\\d)");
        for (String command : input) {
            Matcher m = p.matcher(command);
            if (m.find()) {
                output.add(new Monkey(m.group(2)
                        , m.group(3)
                        , m.group(4)
                        , Integer.parseInt(m.group(5))
                        , Integer.parseInt(m.group(6))
                        , Integer.parseInt(m.group(7))));
            }
        }
        return output;
    }
}
