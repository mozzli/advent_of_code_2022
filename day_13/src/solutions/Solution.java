package solutions;

import data_reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public int getIndentsSum() throws IOException {
        ArrayList<Integer> rightLines = new ArrayList<>();
        ArrayList<Pocket> pocketList = Reader.getPockets();
        for (int i = 0; i < pocketList.size(); i += 2) {
            boolean leftIsSmaller;
            leftIsSmaller = pocketList.get(i + 1).startRound(pocketList.get(i).getList());
            if (leftIsSmaller) {
                rightLines.add((i + 2) / 2);
            }
        }
        int indentsSum = 0;
        for (int number : rightLines) indentsSum += number;
        return indentsSum;
    }

    public int getDecoderKey() throws IOException {
        ArrayList<Pocket> pocketList = Reader.getPockets();
        pocketList.add(new Pocket("[[2]]"));
        pocketList.add(new Pocket("[[6]]"));
        int twoPlacement = 0, sixPlacement = 0;
        boolean sorted = false;
        main:
        while (!sorted) {
            for (int i = 0; i < pocketList.size() - 1; i++) {
                if (pocketList.get(i).startRound(pocketList.get(i + 1).getList())) {
                    Collections.swap(pocketList, i, i + 1);
                    continue main;
                }
            }
            sorted = true;
        }
        for (int i = 1; i < pocketList.size() - 1; i++) {
            if (pocketList.get(i - 1).numberList.size() == 1) {
                if (pocketList.get(i - 1).numberList.get(0) == 2) twoPlacement = i;
                if (pocketList.get(i - 1).numberList.get(0) == 6) sixPlacement = i;
            }
        }
        return twoPlacement * sixPlacement;
    }
}
