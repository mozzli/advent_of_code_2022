package solutions;

import data_reader.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        int shortMarkerLine = solutions.getMarker(Reader.getStringInput(), Markers.SHORT);
        int longMarkerLine = solutions.getMarker(Reader.getStringInput(), Markers.LONG);
        System.out.println(shortMarkerLine + " characters need to be processed before the first start-of-packet marker is detected");
        System.out.println(longMarkerLine + " characters need to be processed before the first start-of-packet marker is detected");
        }
}
