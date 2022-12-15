package solutions;

import data_reader.Reader;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solutions {

    ArrayList<Point> rockList;

    public int getSandAmount(boolean secondSolution) throws IOException {
        rockList = Reader.getRockList(Reader.getCommandMap());
        if (secondSolution) {
            Map<Integer, ArrayList<Point>> bottomMap = new HashMap<>();
            bottomMap.put(1, new ArrayList<>(Arrays.asList(new Point(-10000, Reader.getLowestRock() + 2)
                    , new Point(10000, Reader.getLowestRock() + 2))));
            rockList.addAll(Reader.getRockList(bottomMap));
        }
        ArrayList<Point> sandList = new ArrayList<>();
        boolean sandOverflow = false;
        while (!sandOverflow) {
            Point newSand = new Point(500, 0);
            sandOverflow = sandFallsDown(newSand, sandList);
            if (!sandOverflow) sandList.add(newSand);
        }
        return sandList.size();
    }

    private boolean sandFallsDown(Point sand, ArrayList<Point> sandList) {
        boolean gotMove = true;
        int i = 0;
        while (gotMove) {
            i++;
            Point pointDown = new Point(sand.x, (sand.y) + 1);
            Point pointLeft = new Point((sand.x) - 1, (sand.y) + 1);
            Point pointRight = new Point((sand.x) + 1, (sand.y) + 1);
            if (i > 999 || sandList.contains(new Point(500, 0))) return true;
            if (!rockList.contains(pointDown) && !sandList.contains(pointDown)) {
                sand.move(sand.x, sand.y + 1);
                continue;
            }
            if (!rockList.contains(pointLeft) && !sandList.contains(pointLeft)) {

                sand.move(sand.x - 1, sand.y + 1);
                continue;
            }
            if (!rockList.contains(pointRight) && !sandList.contains(pointRight)) {
                sand.move(sand.x + 1, sand.y + 1);
                continue;
            }
            return false;
        }
        return false;
    }
}
