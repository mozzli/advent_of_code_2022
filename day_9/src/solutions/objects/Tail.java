package solutions.objects;

import solutions.MoveType;

import java.util.ArrayList;
import java.util.Arrays;

public class Tail extends BridgeObjects {

    public Tail() {
        super(new ArrayList<>(Arrays.asList(0, 0)));
    }

    public int getPositionAmount() {
        return checkedCoordinates.size();
    }

    public void moveTail(ArrayList<Integer> coordinates) {
        int rowDistance = coordinates.get(0) - currentCoordinates.get(0);
        int columnDistance = coordinates.get(1) - currentCoordinates.get(1);
        int[] distance = new int[2];
        distance[0] = rowDistance;
        distance[1] = columnDistance;
        switch (Arrays.toString(distance)) {
            case "[2, 0]" -> moveObject(MoveType.UP);
            case "[-2, 0]" -> moveObject(MoveType.DOWN);
            case "[0, 2]" -> moveObject(MoveType.RIGHT);
            case "[0, -2]" -> moveObject(MoveType.LEFT);
            case "[-2, -2]", "[-2, -1]", "[-1, -2]" -> moveObject(MoveType.DOWN_LEFT);
            case "[-2, 2]", "[-2, 1]", "[-1, 2]" -> moveObject(MoveType.DOWN_RIGHT);
            case "[2, -2]", "[2, -1]", "[1, -2]" -> moveObject(MoveType.UP_LEFT);
            case "[2, 2]", "[2, 1]", "[1, 2]" -> moveObject(MoveType.UP_RIGHT);
            default -> {
            }
        }
    }

    public void createTail(ArrayList<Tail> tailList) {
        if (tailList.size() <= 9 || tailList.get(tailList.size() -1) == this) {
            tailList.add(new Tail());
        }
    }

    public void moveLongTail(ArrayList<Integer> coordinates, ArrayList<Tail> tailList) {
        int rowDistance = coordinates.get(0) - currentCoordinates.get(0);
        int columnDistance = coordinates.get(1) - currentCoordinates.get(1);
        int[] distance = new int[2];
        distance[0] = rowDistance;
        distance[1] = columnDistance;
        switch (Arrays.toString(distance)) {
            case "[2, 0]" -> {
                moveObject(MoveType.UP);
                createTail(tailList);
            }
            case "[-2, 0]" -> {
                moveObject(MoveType.DOWN);
                createTail(tailList);
            }
            case "[0, 2]" -> {
                moveObject(MoveType.RIGHT);
                createTail(tailList);
            }
            case "[0, -2]" -> {
                moveObject(MoveType.LEFT);
                createTail(tailList);
            }
            case "[-2, -2]", "[-2, -1]", "[-1, -2]" -> {
                moveObject(MoveType.DOWN_LEFT);
                createTail(tailList);
            }
            case "[-2, 2]", "[-2, 1]", "[-1, 2]" -> {
                moveObject(MoveType.DOWN_RIGHT);
                createTail(tailList);
            }
            case "[2, -2]", "[2, -1]", "[1, -2]" -> {
                moveObject(MoveType.UP_LEFT);
                createTail(tailList);
            }
            case "[2, 2]", "[2, 1]", "[1, 2]" -> {
                moveObject(MoveType.UP_RIGHT);
                createTail(tailList);
            }
            default -> {}
        }
    }
}
