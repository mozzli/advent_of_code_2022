package solutions;

import solutions.enums.HandTypes;
import solutions.enums.Results;

import java.util.ArrayList;

public class SolutionTwo {

    public int getTotalScore(ArrayList<ArrayList<String>> rounds){
        int totalScore = 0;
        for (ArrayList<String> round: rounds){
            HandTypes enemyGesture = getGesture(round.get(0));
            Results result = getResult(round.get(1));
            totalScore += getRoundScore(enemyGesture, result);
        }
        return totalScore;
    }

    private int getRoundScore(HandTypes enemyGesture, Results result){
        switch (enemyGesture){
            case SCISSORS -> {return enemyUsedScissors(result);}
            case ROCK -> {return enemyUsedRock(result);}
            case PAPER -> {return enemyUsedPaper(result);}
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

    private Results getResult(String letter){
        switch (letter){
            case "X" ->{return Results.LOSS;}
            case "Y" ->{return Results.DRAW;}
            case "Z" ->{return Results.WIN;}
            default -> throw new RuntimeException("get result ERROR");
        }
    }

    private int enemyUsedScissors(Results result){
        switch (result){
            case LOSS -> {return 2;}
            case DRAW -> {return 6;}
            case WIN -> {return 7;}
            default -> throw new RuntimeException("enemy used scissors ERROR");
        }
    }

    private int enemyUsedRock(Results result){
        switch (result){
            case LOSS -> {return 3;}
            case DRAW -> {return 4;}
            case WIN -> {return 8;}
            default -> throw new RuntimeException("enemy used rock ERROR");
        }
    }

    private int enemyUsedPaper(Results result){
        switch (result){
            case LOSS -> {return 1;}
            case DRAW -> {return 5;}
            case WIN -> {return 9;}
            default -> throw new RuntimeException("enemy used scissors ERROR");
        }
    }
}
