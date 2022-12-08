package utilities;

import java.util.ArrayList;
import java.util.Map;

public class ImageCreator {

    public static void createStacksImage(Map<Integer, ArrayList<String>> stacksList){
        System.out.println("_____________________________________________");
        int largestArray = 0;
        for (ArrayList<String> arrays: stacksList.values()) {
            if (arrays.size()>largestArray){
                largestArray = arrays.size();
            }
        }
        for (int i = largestArray - 1; i>=0; i--){
            StringBuilder output = new StringBuilder("[    ");
            for (ArrayList<String> array: stacksList.values()){
                if (array.size() >= i + 1){
                    output.append("[").append(array.get(i)).append("] ");
                }
                else{
                    output.append("    ");
                }
            }
            System.out.println(output + "   ]");
        }
        System.out.println("---------------------------------------------");
    }
}
