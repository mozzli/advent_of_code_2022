package utilities;

import java.util.ArrayList;

public class Utilities {

    public static int getLargestValue(ArrayList<Integer> listOfValues){
        int result = 0;
        for (int value:
             listOfValues) {
            if (value>result){
                result = value;
            }
        }
        return result;
    }

    public static int getSumOfThreeLargest(ArrayList<Integer> listOfValues){
        int largestValue = 0;
        int secondLargestValue = 0;
        int thirdLargestValue = 0;
        for (int value:
                listOfValues) {
            if (value>largestValue){
                thirdLargestValue = secondLargestValue;
                secondLargestValue = largestValue;
                largestValue = value;
            }
            else if( value>secondLargestValue){
                thirdLargestValue = secondLargestValue;
                secondLargestValue = value;
            }
            else if( value> thirdLargestValue){
                thirdLargestValue = value;
            }
        }
        return largestValue + secondLargestValue + thirdLargestValue;
    }
}
