package solutions;

import data_reader.Reader;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Move> movementList = Reader.getMovement();
        Solutions solutions = new Solutions();
        System.out.println("Short rope's tail visited " + solutions.getPositionAmount(movementList) + " positions");
        System.out.println("Long rope's tail visited " + solutions.getLongRopesPositionAmount(movementList) + " positions");
    }
}
