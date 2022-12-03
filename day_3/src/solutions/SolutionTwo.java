package solutions;

import java.util.ArrayList;

public class SolutionTwo {
    public int getGroupSumPriority(ArrayList<String> list){
        int prioritySum = 0;
        for (int i = 0; i<list.size(); i += 3){
            prioritySum += getGroupPriority(createLetterList(list.get(i)),
                    createLetterList(list.get(i+1)),
                    createLetterList(list.get(i+2)));
        }
        return prioritySum;
    }

    private int getGroupPriority(ArrayList<String> firstRucksack, ArrayList<String> secondRucksack, ArrayList<String> thirdRucksack){
        ArrayList<String> letterList = getSameLettersFromLists(firstRucksack, secondRucksack);
        ArrayList<String> finalLetter = getSameLettersFromLists(thirdRucksack,letterList);
        return getNumberFromChar(finalLetter.get(0).charAt(0));
    }

    private ArrayList<String> createLetterList(String line){
        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i<line.length(); i++){
            letters.add(line.substring(i,i+1));
        }
        return letters;
    }

    private int getNumberFromChar(char letter){
        if (Character.isLowerCase(letter)){
            return Integer.parseInt(String.valueOf(letter - 'a' + 1));
        }
        else{
            return Integer.parseInt(String.valueOf(letter - 'A' + 27));
        }
    }

    private ArrayList<String> getSameLettersFromLists(ArrayList<String> firstList, ArrayList<String> secondList){
        ArrayList<String> letters = new ArrayList<>();
        for (String letter: firstList){
            if (secondList.contains(letter)){
                letters.add(letter);
            }
        }
        return letters;
    }
}
