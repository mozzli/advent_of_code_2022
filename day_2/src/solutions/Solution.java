package solutions;

import solutions.enums.HandTypes;

import java.util.ArrayList;

public class Solution {

    public int getTotalScore(ArrayList<ArrayList<String>> rounds){
        int totalScore = 0;
        for (ArrayList<String> round: rounds){
            HandTypes enemy = getGesture(round.get(0));
            HandTypes player = getGesture(round.get(1));
            totalScore += getRoundScore(player, enemy);
        }
        return totalScore;
    }

    private int getRoundScore(HandTypes playerGesture, HandTypes enemyGesture){
        switch (playerGesture){
            case SCISSORS -> {return playerUsedScissors(enemyGesture);}
            case ROCK -> {return playerUsedRock(enemyGesture);}
            case PAPER -> {return playerUsedPaper(enemyGesture);}
            default -> throw new RuntimeException("Round Score Error");
        }
    }

    private HandTypes getGesture(String letter){
        return switch (letter) {
            case "A", "X" -> HandTypes.ROCK;
            case "B", "Y" -> HandTypes.PAPER;
            case "C", "Z" -> HandTypes.SCISSORS;
            default -> throw new RuntimeException("get gesture ERROR");
        };
    }

    private int playerUsedPaper(HandTypes enemyType){
        int result = 2;
        switch (enemyType){
            case PAPER -> result += 3;
            case ROCK -> result += 6;
            default -> {}
        }
        return result;
    }

    private int playerUsedRock(HandTypes enemyType){
        int result = 1;
        switch (enemyType){
            case ROCK -> result += 3;
            case SCISSORS -> result += 6;
            default -> {}
        }
        return result;
    }

    private int playerUsedScissors(HandTypes enemyType){
        int result = 3;
        switch (enemyType){
            case SCISSORS -> result += 3;
            case PAPER -> result += 6;
            default -> {}
        }
        return result;
    }
}
