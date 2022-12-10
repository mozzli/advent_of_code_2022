package solutions;

import solutions.objects.Head;
import solutions.objects.Tail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {

    Tail tail = new Tail();
    Head head = new Head();
    Head longRopeHead = new Head();
    ArrayList<Tail> tails = new ArrayList<>(List.of(new Tail()));

    private void makeBridgeMoves(ArrayList<Move> moves) {
        for (Move move : moves) {
            for (int i = 0; i < move.getMoveAmount(); i++) {
                head.moveObject(move.getMoveType());
                tail.moveTail(head.getCurrentCoordinates());
            }
        }
    }

    public int getPositionAmount(ArrayList<Move> moves) {
        makeBridgeMoves(moves);
        return tail.getPositionAmount();

    }

    public void makeLongBridgeMoves(ArrayList<Move> moves) {
        for (Move move : moves) {
            for (int i = 0; i < move.getMoveAmount(); i++) {
                longRopeHead.moveObject(move.getMoveType());
                tails.get(0).moveLongTail(longRopeHead.getCurrentCoordinates(), tails);
                for (int j = 1; j < tails.size(); j++) {
                    tails.get(j).moveLongTail(tails.get(j - 1).getCurrentCoordinates(), tails);
                }
            }
        }
    }

    public int getLongRopesPositionAmount(ArrayList<Move> moves) {
        makeLongBridgeMoves(moves);
        return tails.get(8).getPositionAmount();
    }
}
