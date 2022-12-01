package main;

import data_reader.Reader;
import utilities.Utilities;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> listOfCalories = Reader.get_input();
        CaloriesCalculator caloriesCalculator = new CaloriesCalculator();
        System.out.println("Largest value: " + caloriesCalculator.getLargestCaloriesValue(listOfCalories));
        System.out.println("Largest value of three: " + caloriesCalculator.getSumOfThreeLargestValues(listOfCalories));
    }
}
