package solutions;

import java.util.ArrayList;

public class SolutionOne {

    public int getPairs(ArrayList<ArrayList<Integer>> list) {
        int pairs = 0;
        for (ArrayList<Integer> crd : list) {
            boolean firstContainsSecond = crd.get(2) >= crd.get(0) && crd.get(3) <= crd.get(1);
            boolean secondContainsFirst = crd.get(0) >= crd.get(2) && crd.get(1) <= crd.get(3);
            if (firstContainsSecond || secondContainsFirst) {
                pairs++;
            }
        }
        return pairs;
    }

}

