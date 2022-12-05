package solutions;

import utilities.ImageCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public ArrayList<String> getHighestCargos(Map<Integer, ArrayList<String>> cargoList, ArrayList<Map<Inputs, Integer>> inputs, CraneType craneType) {
        ArrayList<String> highestCargos = new ArrayList<>();
        Map<Integer, ArrayList<String>> cargo = new HashMap<>(cargoList);
        for (Map<Inputs, Integer> command : inputs) {
            moveCargo(cargo, command, craneType);
        }
        for (Integer key : cargo.keySet()) {
            highestCargos.add(cargo.get(key).get(cargo.get(key).size() - 1));
        }
        ImageCreator.createStacksImage(cargo);
        return highestCargos;
    }

    public void moveCargo(Map<Integer, ArrayList<String>> cargo, Map<Inputs, Integer> command, CraneType craneType) {
        int fromColumn = command.get(Inputs.FROM_COLUMN);
        int toColumn = command.get(Inputs.TO_COLUMN);
        if (craneType == CraneType.CRATEMOVER_9001) {
            for (int i = command.get(Inputs.CARGO_AMOUNT); i > 0; i--) {
                cargo.get(toColumn).add(cargo.get(fromColumn).get(cargo.get(fromColumn).size() - i));
                cargo.get(fromColumn).remove(cargo.get(fromColumn).size() - i);
            }
        } else {
            for (int i = 0; i < command.get(Inputs.CARGO_AMOUNT); i++) {
                cargo.get(toColumn).add(cargo.get(fromColumn).get(cargo.get(fromColumn).size() - 1));
                cargo.get(fromColumn).remove(cargo.get(fromColumn).size() - 1);
            }
        }
    }
}
