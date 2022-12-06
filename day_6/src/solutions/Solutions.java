package solutions;

import java.util.ArrayList;

public class Solutions {
    private int marker = 0;

    public int getMarker(String line, Markers type) {
        switch (type){
            case SHORT -> marker = 4;
            case LONG -> marker = 14;
        }
        checkLinesForMarker(line, marker);
        return marker;
}

    private void checkLinesForMarker(String line, int markerLength) {
        for (int i = 0; i < line.length() - (markerLength - 1); i++) {
            String currentLine = line.substring(i, i + markerLength);
            ArrayList<Character> set = new ArrayList<>();
            boolean noDuplicates = true;
            for (Character letter : currentLine.toCharArray()) {
                if (set.contains(letter)) {
                    noDuplicates = false;
                }
                set.add(letter);
            }
            if (noDuplicates) {
                break;
            }
            marker++;
        }
    }
}
