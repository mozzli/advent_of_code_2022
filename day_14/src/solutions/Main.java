package solutions;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Solutions solutions = new Solutions();
        System.out.println(solutions.getSandAmount(false) + " grains of sand");
        System.out.println(solutions.getSandAmount(true) + " grains of sand");
    }
}
