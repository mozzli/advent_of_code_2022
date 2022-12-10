package solutions;

public class Move {

    MoveType moveType;
    int moveAmount;

    public Move(MoveType moveType, int amount){
        this.moveType = moveType;
        moveAmount = amount;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public int getMoveAmount() {
        return moveAmount;
    }
}
