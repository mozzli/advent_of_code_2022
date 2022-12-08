package solutions;

import data_reader.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Solutions {

    public int getVisibleTreeAmount(Map<ArrayList<Integer>, Tree> treeDictionary) {
        int visibleTrees = 0;
        for (int i = 1; i <= Reader.getMaxRow(); i++) {
            treeDictionary.get(Arrays.asList(1, i)).checkTreeBellow(treeDictionary, -1);
            treeDictionary.get(Arrays.asList(Reader.getMaxRow(), i)).checkTreeAbove(treeDictionary, -1);
            treeDictionary.get(Arrays.asList(i, 1)).checkTreeOnRight(treeDictionary, -1);
            treeDictionary.get(Arrays.asList(i, Reader.getMaxRow())).checkTreeOnLeft(treeDictionary, -1);
        }
        for (Tree tree : treeDictionary.values())
            if (tree.getVisibility()) {
                visibleTrees++;
            }
        return visibleTrees;
    }

    public int getHighestViewScore(Map<ArrayList<Integer>, Tree> treeDictionary) {
        int highestScenicScore = 0;
        for (Tree tree : treeDictionary.values()) {
            int scenicScore = tree.getScenicScore(treeDictionary);
            if (highestScenicScore < scenicScore) {
                highestScenicScore = scenicScore;
            }
        }
        return highestScenicScore;


    }
}
