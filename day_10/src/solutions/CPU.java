package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class CPU {

    int xValue = 1;
    int cycle = 0;
    private ArrayList<Integer> spritePosition = new ArrayList<>(Arrays.asList(0, 1, 2));
    private StringBuilder output = new StringBuilder();

    private ArrayList<Integer> cycleValues = new ArrayList<>();

    private final ArrayList<Integer> CYCLE_VALUES_LIST = new ArrayList<>(Arrays.asList(20, 60, 100, 140, 180, 220));
    private final ArrayList<Integer> LINE_END_CYCLE = new ArrayList<>(Arrays.asList(40, 80, 120, 160, 200, 240));

    private void cycleProcess() {
        cycle++;
        if (CYCLE_VALUES_LIST.contains(cycle)) {
            cycleValues.add(xValue * cycle);
        }
    }

    public void activateNoop() {
        cycleProcess();
    }

    public void activateAddX(int xAmount) {
        cycleProcess();
        cycleProcess();
        xValue += xAmount;
    }

    public int getCycleValuesSum() {
        int amount = 0;
        for (int cycleValue : cycleValues) {
            amount += cycleValue;
        }
        return amount;
    }

    private void checkIfEndOfTheLine() {
        if (LINE_END_CYCLE.contains(cycle)) {
            System.out.println(output);
            output = new StringBuilder();
        }
    }

    public void outputCycle() {
        cycle++;
        if (spritePosition.contains(output.length())) {
            output.append("#");
        } else {
            output.append(".");
        }
        checkIfEndOfTheLine();
    }

    public void addXSpriteCommand(int xAmount) {
        outputCycle();
        outputCycle();
        xValue += xAmount;
        spritePosition.clear();
        spritePosition = new ArrayList<>(Arrays.asList(xValue - 1, xValue, xValue + 1));
    }

    public void noopSpriteCommand() {
        outputCycle();
    }

}
