package solutions;

import java.util.ArrayList;

public class Solutions {

    CPU cpu = new CPU();
    CPU spriteCPU = new CPU();

    public int getSignalStrength(ArrayList<ArrayList<String>> commandList) {
        for (ArrayList<String> command : commandList) {
            switch (command.get(0)) {
                case "addx" -> cpu.activateAddX(Integer.parseInt(command.get(1)));
                case "noop" -> cpu.activateNoop();
            }
        }
        return cpu.getCycleValuesSum();
    }

    public void getSpriteOutput(ArrayList<ArrayList<String>> commandList) {
        for (ArrayList<String> command : commandList) {
            switch (command.get(0)) {
                case "addx" -> spriteCPU.addXSpriteCommand(Integer.parseInt(command.get(1)));
                case "noop" -> spriteCPU.noopSpriteCommand();
            }
        }
    }
}
