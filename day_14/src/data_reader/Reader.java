package data_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Point;

public class Reader {

    public static int lowestRock = 0;

    public static ArrayList<String> get_input() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/data/data.txt"));
        ArrayList<String> listOfCommands = new ArrayList<>();
        String line;

        while ((line = text.readLine()) != null) {
            listOfCommands.add(line);
        }
        return listOfCommands;
    }

    public static Map<Integer,ArrayList<Point>> getCommandMap() throws IOException {
        Map<Integer,ArrayList<Point>> commandMap = new HashMap<>();
        ArrayList<String> input = get_input();
        Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
        int i = 0;
            for (String coordinate: input){
                ArrayList<Point> commandList = new ArrayList<>();
                Point command = new Point();
                Matcher m = pattern.matcher(coordinate);
                while (m.find()){
                    command.x = (Integer.parseInt(m.group(1)));
                    command.y = (Integer.parseInt(m.group(2)));
                    commandList.add(command);
                    command = new Point();
                }
                commandMap.put(i,commandList);
                i++;
            }
        return commandMap;
    }

    public static ArrayList<Point> getRockList(Map<Integer,ArrayList<Point>> rockMap) {
        ArrayList<Point> rockList = new ArrayList<>();
        for (ArrayList<Point> rocks : rockMap.values()) {
            for (int i = 0; i<rocks.size() - 1 ; i++){
                if (!rockList.contains(rocks.get(i))) rockList.add(new Point(rocks.get(i)));
                int distanceX = rocks.get(i).x - rocks.get(i+1).x;
                int distanceY = rocks.get(i).y - rocks.get(i+1).y;
                while (rocks.get(i).distance(rocks.get(i+1)) != 0){
                    moveRock(rocks.get(i),distanceX,distanceY);
                    if (rocks.get(i).y > lowestRock) lowestRock = rocks.get(i).y;
                    if (!rockList.contains(rocks.get(i))) rockList.add(new Point(rocks.get(i)));
                }
            }
        }
        return rockList;
    }

    public static void moveRock(Point rock, int x, int y){
        if (x !=0){
            if (x<0) rock.move(rock.x +1, rock.y);
            if (x>0) rock.move(rock.x - 1, rock.y);
        }
        else if (y != 0){
            if (y<0) rock.move(rock.x, rock.y + 1);
            if (y>0) rock.move(rock.x, rock.y - 1);
        }
    }

    public static int getLowestRock(){
        return lowestRock;
    }
}
