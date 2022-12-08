package solutions;

import data_reader.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Tree {

    private final int HEIGHT;
    private boolean is_seen = false;
    private final ArrayList<Integer> coordinates;

    public Tree(int height, ArrayList<Integer> coordinates) {
        this.HEIGHT = height;
        this.coordinates = coordinates;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void treeIsVisible() {
        is_seen = true;
    }

    public boolean getVisibility() {
        return is_seen;
    }

    public void checkTreeBellow(Map<ArrayList<Integer>, Tree> treeDictionary, int highestTree) {
        int currentHighestTree;
        currentHighestTree = highestTree;
        if (getHeight() > highestTree) {
            currentHighestTree = getHeight();
            treeIsVisible();
        }
        if (coordinates.get(0) != Reader.getMaxRow()) {
            Tree treeBellow = treeDictionary.get(Arrays.asList(coordinates.get(0) + 1, coordinates.get(1)));
            treeBellow.checkTreeBellow(treeDictionary, currentHighestTree);
        }
    }

    public void checkTreeAbove(Map<ArrayList<Integer>, Tree> treeDictionary, int highestTree) {
        int currentHighestTree;
        currentHighestTree = highestTree;
        if (getHeight() > highestTree) {
            currentHighestTree = getHeight();
            treeIsVisible();
        }
        if (coordinates.get(0) != 1) {
            Tree treeAbove = treeDictionary.get(Arrays.asList(coordinates.get(0) - 1, coordinates.get(1)));
            treeAbove.checkTreeAbove(treeDictionary, currentHighestTree);
        }
    }

    public void checkTreeOnRight(Map<ArrayList<Integer>, Tree> treeDictionary, int highestTree) {
        int currentHighestTree;
        currentHighestTree = highestTree;
        if (getHeight() > highestTree) {
            currentHighestTree = getHeight();
            treeIsVisible();
        }
        if (coordinates.get(1) != Reader.getMaxRow()) {
            Tree treeRight = treeDictionary.get(Arrays.asList(coordinates.get(0), coordinates.get(1) + 1));
            treeRight.checkTreeOnRight(treeDictionary, currentHighestTree);
        }
    }

    public void checkTreeOnLeft(Map<ArrayList<Integer>, Tree> treeDictionary, int highestTree) {
        int currentHighestTree;
        currentHighestTree = highestTree;
        if (getHeight() > highestTree) {
            currentHighestTree = getHeight();
            treeIsVisible();
        }
        if (coordinates.get(1) != 1) {
            Tree treeLeft = treeDictionary.get(Arrays.asList(coordinates.get(0), coordinates.get(1) - 1));
            treeLeft.checkTreeOnLeft(treeDictionary, currentHighestTree);
        }
    }

    public int getScenicScore(Map<ArrayList<Integer>, Tree> treeDictionary) {
        Tree nextTree;
        int leftView = 0;
        int rightView = 0;
        int upView = 0;
        int downView = 0;
        if (coordinates.get(1) != Reader.getMaxRow()) {
            nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0), coordinates.get(1) + 1));
            rightView = nextTree.getRightView(treeDictionary, getHeight());
        }
        if (coordinates.get(1) != 1) {
            nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0), coordinates.get(1) - 1));
            leftView = nextTree.getLeftView(treeDictionary, this.getHeight());
        }
        if (coordinates.get(0) != 1) {
            nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0) - 1, coordinates.get(1)));
            upView = nextTree.getUpView(treeDictionary, getHeight());
        }
        if (coordinates.get(0) != Reader.getMaxRow()) {
            nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0) + 1, coordinates.get(1)));
            downView = nextTree.getDownView(treeDictionary, getHeight());
        }
        return leftView * rightView * upView * downView;
    }

    private int getLeftView(Map<ArrayList<Integer>, Tree> treeDictionary, int maxHeight) {
        int score;

        if (getHeight() < maxHeight && coordinates.get(1) != 1) {
            Tree nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0), coordinates.get(1) - 1));
            score = nextTree.getLeftView(treeDictionary, maxHeight) + 1;
            return score;
        } else {
            return 1;
        }
    }

    private int getRightView(Map<ArrayList<Integer>, Tree> treeDictionary, int maxHeight) {
        int score;
        if (coordinates.get(1) != Reader.getMaxRow() && getHeight() < maxHeight) {
            Tree nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0), coordinates.get(1) + 1));
            score = nextTree.getRightView(treeDictionary, maxHeight) + 1;
            return score;
        } else {
            return 1;
        }
    }

    private int getDownView(Map<ArrayList<Integer>, Tree> treeDictionary, int maxHeight) {
        int score;
        if (coordinates.get(0) != Reader.getMaxRow() && getHeight() < maxHeight) {
            Tree nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0) + 1, coordinates.get(1)));
            score = nextTree.getDownView(treeDictionary, maxHeight) + 1;
            return score;
        } else {
            return 1;
        }
    }

    private int getUpView(Map<ArrayList<Integer>, Tree> treeDictionary, int maxHeight) {
        int score;
        if (coordinates.get(0) != 1 && getHeight() < maxHeight) {
            Tree nextTree = treeDictionary.get(Arrays.asList(coordinates.get(0) - 1, coordinates.get(1)));
            score = nextTree.getUpView(treeDictionary, maxHeight) + 1;
            return score;
        } else {
            return 1;

        }

    }
}
