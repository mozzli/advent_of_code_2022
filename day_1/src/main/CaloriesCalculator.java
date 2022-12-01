package main;

import utilities.Utilities;

import java.util.ArrayList;

public class CaloriesCalculator {

    public int getLargestCaloriesValue(ArrayList<String> listOfCalories){
        int currentValue = 0;
        int largestValue = 0;
        ArrayList<Integer> all_values = new ArrayList<Integer>();
        for (String calories : listOfCalories) {
            if (calories.equals("")) {
                all_values.add(currentValue);
                currentValue = 0;
            } else {
                currentValue += Integer.parseInt(calories);
            }
        }
        all_values.add(currentValue);
        largestValue = Utilities.getLargestValue(all_values);
        return largestValue;
    }

    public int getSumOfThreeLargestValues(ArrayList<String> listOfCalories){
        int currentValue = 0;
        int largestValue = 0;
        ArrayList<Integer> all_values = new ArrayList<Integer>();
        for (String calories : listOfCalories) {
            if (calories.equals("")) {
                all_values.add(currentValue);
                currentValue = 0;
            } else {
                currentValue += Integer.parseInt(calories);
            }
        }
        all_values.add(currentValue);
        largestValue = Utilities.getSumOfThreeLargest(all_values);
        return largestValue;
    }

}
