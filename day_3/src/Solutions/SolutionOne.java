package Solutions;

import java.util.ArrayList;

public class SolutionOne {

    public int getPrioritySum(ArrayList<String> list){
        int prioritySum = 0;
        for (String rucksack: list
             ) {
            String firstCompartment = (String) rucksack.subSequence(0, rucksack.length()/2);
            String secondCompartment = (String) rucksack.subSequence(rucksack.length()/2, rucksack.length());
            prioritySum += getPriority(firstCompartment, secondCompartment);
        }
        return prioritySum;
    }

    private int getPriority(String firstCompartment, String secondCompartment){
        CharSequence letter = null;
        for (int i = 0; i < firstCompartment.length(); i++){
            if (firstCompartment.contains(secondCompartment.subSequence(i, i+1))){
                letter = secondCompartment.subSequence(i, i+1);
            }
        }
        return getNumberFromChar(String.valueOf(letter).charAt(0));
    }

    private int getNumberFromChar(char letter){
        if (Character.isLowerCase(letter)){
            return Integer.parseInt(String.valueOf(letter - 'a' + 1));
        }
        else{
            return Integer.parseInt(String.valueOf(letter - 'A' + 27));
        }
    }
}
