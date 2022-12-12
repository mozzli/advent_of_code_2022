package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solutions {

    ArrayList<Integer> lowestSteps = new ArrayList<>();

    public int getSteps(int solution, ArrayList<Integer> start) throws IOException {
        Map<ArrayList<Integer>, Sector> sectorMap = Reader.getSectors();
        ArrayList<Integer> startingPoint = solution == 1 ? Reader.getStartingPoint() : start;
        ArrayList<Sector> toBeChecked = new ArrayList<>(List.of(sectorMap.get(startingPoint)));
        boolean foundIt = false;
        while (!foundIt)
            if (toBeChecked.isEmpty()) break;
            else foundIt = getSectorWithLowestF(toBeChecked).checkSector(sectorMap, toBeChecked);
        return sectorMap.get(Reader.getEndPoint()).shortestPath.size();
    }

    private Sector getSectorWithLowestF(ArrayList<Sector> sectorList) {
        Sector newSector = null;
        for (Sector sector : sectorList) {
            if (newSector == null || newSector.getFValue() > sector.getFValue()) newSector = sector;
        }
        return newSector;
    }

    public int getLowestSteps() throws IOException {
        Map<ArrayList<Integer>, Sector> sectorMap = Reader.getSectors();
        for (Sector sector : sectorMap.values()) {
            if (sector.getValue() == 1) {
                lowestSteps.add(getSteps(2, sector.getCOORDINATES()));
            }
        }
        int lowestCount = 999;
        for (int count : lowestSteps) {
            if (count != 0 && lowestCount > count) lowestCount = count;
        }
        return lowestCount;
    }
}
