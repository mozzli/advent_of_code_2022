package data_reader;

import solutions.Sector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Reader {

    static int rows, columns;
    static ArrayList<Integer> startingPoint, endPoint;

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        ArrayList<String> listOfStrings = new ArrayList<>();
        String line;
        while ((line = text.readLine()) != null) {
            listOfStrings.add(line);
        }
        return listOfStrings;
    }

    public static Map<ArrayList<Integer>, Sector> getSectors() throws IOException {
        Map<ArrayList<Integer>, Sector> sectorList = new HashMap<>();
        columns = get_input().get(0).length();
        rows = get_input().size();
        int row = 1;
        for (String line : get_input()) {
            for (int column = 1; column <= line.length(); column++) {
                ArrayList<Integer> coordinates = new ArrayList<>(Arrays.asList(row, column));
                if (line.charAt(column - 1) == 'S') {
                    sectorList.put(coordinates, new Sector(1, coordinates, 0));
                    startingPoint = coordinates;
                } else if (line.charAt(column - 1) == 'E') {
                    sectorList.put(coordinates, new Sector('z' - 'a' + 1, coordinates));
                    endPoint = coordinates;
                } else sectorList.put(coordinates, new Sector(line.charAt(column - 1) - 'a' + 1, coordinates));
            }
            row++;
        }
        return sectorList;
    }

    public static ArrayList<Integer> getStartingPoint() {
        return startingPoint;
    }

    public static ArrayList<Integer> getEndPoint() {
        return endPoint;
    }

    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

}
