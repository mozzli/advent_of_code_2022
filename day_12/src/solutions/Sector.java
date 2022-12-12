package solutions;

import data_reader.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sector {

    private final int VALUE;
    private final ArrayList<Integer> COORDINATES;
    private final Map<Movement, ArrayList<Integer>> neighbours = new HashMap<>();
    private int hValue = 0;
    private int gValue = 99999999;
    ArrayList<Sector> shortestPath = new ArrayList<>();
    private boolean checked = false;

    public Sector(int value, ArrayList<Integer> coordinates) {
        VALUE = value;
        COORDINATES = coordinates;
        getNeighbours();
    }

    public Sector(int value, ArrayList<Integer> coordinates, int gValue) {
        VALUE = value;
        COORDINATES = coordinates;
        getNeighbours();
        this.gValue = gValue;
        checked = true;
    }

    public int getValue() {
        return VALUE;
    }

    public boolean checkSector(Map<ArrayList<Integer>, Sector> sectorMap, ArrayList<Sector> toBeChecked) {
        boolean foundIt = checkNeighbours(sectorMap, toBeChecked);
        toBeChecked.remove(this);
        return foundIt;

    }

    private void getNeighbours() {
        if (!(COORDINATES.get(0) <= 1))
            neighbours.put(Movement.UP, new ArrayList<>(Arrays.asList(COORDINATES.get(0) - 1, COORDINATES.get(1))));
        if (!(COORDINATES.get(0) >= Reader.getRows()))
            neighbours.put(Movement.DOWN, new ArrayList<>(Arrays.asList(COORDINATES.get(0) + 1, COORDINATES.get(1))));
        if ((COORDINATES.get(1) > 1)) {
            neighbours.put(Movement.LEFT, new ArrayList<>(Arrays.asList(COORDINATES.get(0), COORDINATES.get(1) - 1)));
        }
        if ((COORDINATES.get(1) < Reader.getColumns()))
            neighbours.put(Movement.RIGHT, new ArrayList<>(Arrays.asList(COORDINATES.get(0), COORDINATES.get(1) + 1)));
    }

    public boolean checkNeighbours(Map<ArrayList<Integer>, Sector> sectorList, ArrayList<Sector> toBeChecked) {
        for (Movement key : neighbours.keySet()) {
            Sector newSector = sectorList.get(neighbours.get(key));
            if (newSector.getValue() <= VALUE + 1 && !newSector.checked) {
                if (newSector.getGValue() == 99999999) {
                    newSector.setGValue(gValue + 1);
                    newSector.setHValue();
                    newSector.addPath(shortestPath);
                    toBeChecked.add(newSector);
                    if (newSector.COORDINATES == Reader.getEndPoint()) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public void setHValue() {
        hValue = Math.abs(Reader.getEndPoint().get(0) - COORDINATES.get(0)) + Math.abs(Reader.getEndPoint().get(1) - COORDINATES.get(1));
    }

    public int getFValue() {
        return hValue + gValue;
    }

    public int getGValue() {
        return gValue;
    }

    public void setGValue(int newValue) {
        gValue = newValue;
    }

    public void addPath(ArrayList<Sector> previousPath) {
        shortestPath.addAll(previousPath);
        shortestPath.add(this);
    }

    public ArrayList<Integer> getCOORDINATES() {
        return COORDINATES;
    }

}
