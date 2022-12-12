package solutions;

import data_reader.Reader;

import java.util.ArrayList;

public class Solutions {

    public Long getMonkeyBusinessValue(int solution) throws Exception {
        ArrayList<Monkey> monkeyList = Reader.getParsedInput();
        int modulo = solution == 1 ? 3 : getModulo(monkeyList);
        for (int i = 0; i < (solution == 1 ? 20 : 10000); i++) {
            for (Monkey monkey : monkeyList) {
                monkey.startRound(monkeyList, modulo, solution);
            }
        }
        return getMonkeyBusiness(monkeyList);
    }

    public int getModulo(ArrayList<Monkey> monkeys) {
        int mod = 1;
        for (Monkey monkey : monkeys) {
            mod = (int) (mod * monkey.getTEST());
        }
        return mod;
    }

    public long getMonkeyBusiness(ArrayList<Monkey> monkeyList) {
        ArrayList<Long> monkeyBusiness = new ArrayList<>();
        long biggest = 0, secondBiggest = 0;
        for (Monkey monkey : monkeyList) {
            monkeyBusiness.add((long) monkey.getItemUsage());
        }
        for (long business : monkeyBusiness) {
            if (business > biggest) {
                secondBiggest = biggest;
                biggest = business;
            } else if (business > secondBiggest) {
                secondBiggest = business;
            }
        }
        return biggest * secondBiggest;
    }
}
