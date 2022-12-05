package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SolutionTwo {

    public ArrayList<String> getHighestCargos(Map<Integer,ArrayList<String>> cargoList, ArrayList<Map<Inputs,Integer>> inputs){
        ArrayList<String> highestCargos = new ArrayList<>();
        Map<Integer,ArrayList<String>> cargo = new HashMap<>(cargoList);
        for (Map<Inputs,Integer> command: inputs){
            moveCargo(cargo,command);
        }
        for (Integer key: cargo.keySet()){
            highestCargos.add(cargo.get(key).get(cargo.get(key).size()-1));
        }
        return highestCargos;
    }

    public void moveCargo(Map<Integer,ArrayList<String>> cargo, Map<Inputs,Integer> command){
        int fromColumn = command.get(Inputs.FROM_COLUMN);
        int toColumn = command.get(Inputs.TO_COLUMN);
        for (int i = command.get(Inputs.CARGO_AMOUNT); i> 0; i--){
            cargo.get(toColumn).add(cargo.get(fromColumn).get(cargo.get(fromColumn).size()-i));
            cargo.get(fromColumn).remove(cargo.get(fromColumn).size()-i);
        }
    }
}
