package solutions.objects;

import solutions.MoveType;

import java.util.ArrayList;

public class BridgeObjects {

    ArrayList<Integer> currentCoordinates;
    ArrayList<ArrayList<Integer>> checkedCoordinates = new ArrayList<>();

    public BridgeObjects(ArrayList<Integer> currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
        checkedCoordinates.add(new ArrayList<>(currentCoordinates));
    }

    public ArrayList<Integer> getCurrentCoordinates() {
        return currentCoordinates;
    }

    public void moveUp() {
        currentCoordinates.set(0, currentCoordinates.get(0) + 1);
    }

    public void moveDown() {
        currentCoordinates.set(0, currentCoordinates.get(0) - 1);
    }

    public void moveRight() {
        currentCoordinates.set(1, currentCoordinates.get(1) + 1);
    }

    public void moveLeft() {
        currentCoordinates.set(1, currentCoordinates.get(1) - 1);
    }


    public void moveObject(MoveType move) {
        switch (move) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case RIGHT -> moveRight();
            case LEFT -> moveLeft();
            case UP_LEFT -> {
                moveUp();
                moveLeft();
            }

            case UP_RIGHT -> {
                moveUp();
                moveRight();
            }
            case DOWN_LEFT -> {
                moveLeft();
                moveDown();
            }
            case DOWN_RIGHT -> {
                moveDown();
                moveRight();
            }
        }
        if (!checkedCoordinates.contains(currentCoordinates)){
            checkedCoordinates.add(new ArrayList<>(currentCoordinates));
        }
    }


}
