package solutions;

import java.util.ArrayList;


public class Monkey {

    final String NUMBER_STRING;
    private final ArrayList<Long> ITEMS;
    private final String COMMAND;
    private final String COMMAND_NUMBER;
    private final Long TEST;
    private final int IF_TRUE;
    private final int IF_FALSE;
    private int itemUsage = 0;

    public Monkey(String numbersString, String command, String commandNumber, int test, int ifTrue, int ifFalse) {
        this.NUMBER_STRING = numbersString;
        this.COMMAND = command;
        this.COMMAND_NUMBER = commandNumber;
        this.TEST = (long) test;
        this.IF_TRUE = ifTrue;
        this.IF_FALSE = ifFalse;
        ITEMS = createItems(numbersString);
    }

    public void startRound(ArrayList<Monkey> monkeyList, int modulo, int solution) {
        for (Long item : ITEMS) {
            Long newItem = doCommand(item);
            newItem = solution == 1 ? newItem / 3 : newItem % modulo;
            itemUsage++;
            if (newItem % TEST == 0) monkeyList.get(IF_TRUE).addItem(newItem);
            else monkeyList.get(IF_FALSE).addItem(newItem);
        }
        ITEMS.clear();
    }

    private ArrayList<Long> createItems(String text) {
        ArrayList<Long> newItems = new ArrayList<>();
        String[] results = text.split(", ");
        for (String result : results) {
            newItems.add(Long.parseLong(result));
        }
        return newItems;
    }

    private Long doCommand(long item) {
        if ("*".equals(COMMAND)) {
            return (COMMAND_NUMBER.equals("old")) ? item * item : item * Long.parseLong(COMMAND_NUMBER);
        }
        return COMMAND_NUMBER.equals("old") ? item * 2 : item + (Long.parseLong(COMMAND_NUMBER));
    }

    private void addItem(Long item) {
        ITEMS.add(item);
    }

    public Long getTEST() {
        return TEST;
    }

    public int getItemUsage() {
        return itemUsage;
    }
}
