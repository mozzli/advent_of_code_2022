package solutions;

import java.util.ArrayList;

public class SolutionTwo {
    public int getOverlappingSum(ArrayList<ArrayList<Integer>> list) {
        int overlaps = 0;
        for (ArrayList<Integer> crd : list) {
            if ((crd.get(1) < crd.get(2)) || (crd.get(3) < crd.get(0))) {
                continue;
            }
            overlaps++;
        }
        return overlaps;
    }
}

