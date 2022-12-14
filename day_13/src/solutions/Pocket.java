package solutions;

import java.util.*;

public class Pocket {

    private final List<Object> pocketList;
    ArrayList<Integer> numberList = new ArrayList<>();

    public Pocket(String line) {
        pocketList = getPocket(line);
    }

    public List<Object> getPocket(String line) {
        String justNumbers = line.replace(',', ' ').replace('[', ' ').replace(']', ' ');
        String trimmedNumbers = justNumbers.replace(" ", "");
        for (int i = 0; i < trimmedNumbers.length(); i++) {
            numberList.add(Integer.parseInt(String.valueOf(trimmedNumbers.charAt(i))));
        }
        Deque<List<Object>> stack = new ArrayDeque<>();
        stack.push(new ArrayList<>());
        for (int i = 1, n = line.length() - 1; i < n; i++) {
            switch (line.charAt(i)) {
                case ',':
                    break;
                case ']':
                    stack.pop();
                    break;
                case '[':
                    List<Object> newList = new ArrayList<>();
                    assert stack.peek() != null;
                    stack.peek().add(newList);
                    stack.push(newList);
                    break;
                default:
                    int end = justNumbers.indexOf(' ', i + 1);
                    assert stack.peek() != null;
                    stack.peek().add(Integer.parseInt(justNumbers.substring(i, end)));
                    i = end - 1;
            }
        }
        return stack.pop();
    }

    public List<Object> getList() {
        return pocketList;
    }

    public boolean startRound(List<Object> leftPocket) {
        return compare(pocketList, leftPocket) == -1;
    }

    public int compare(Object rightObject, Object leftObject) {
        if (rightObject instanceof Integer && leftObject instanceof Integer) {
            return compareInteger((Integer) rightObject, (Integer) leftObject);
        } else if (rightObject instanceof List && leftObject instanceof Integer) {
            return compare(rightObject, toList((Integer) leftObject));
        } else if (rightObject instanceof List && leftObject instanceof List) {
            return listsCheck((List<Object>) rightObject, (List<Object>) leftObject);
        } else if (leftObject instanceof List && rightObject instanceof Integer) {
            return compare(new ArrayList<>(List.of(rightObject)), leftObject);
        }
        return 0;
    }

    private int listsCheck(List<Object> rightObject, List<Object> leftObject) {
        if (getListSize(leftObject) > getListSize(rightObject)) {
            if (getListSize(rightObject) == 0) {
                return 1;
            }
            for (int i = 0; i < rightObject.size(); i++) {
                int cmp = compare(((List<?>) rightObject).get(i), ((List<?>) leftObject).get(i));
                if (cmp == 0 && rightObject.size() == i + 1) {
                    return 1;
                } else if (cmp != 0) return cmp;
            }
        } else if (getListSize(leftObject) < getListSize(rightObject)) {
            if (getListSize(leftObject) == 0) {
                return -1;
            }
            for (int i = 0; i < leftObject.size(); i++) {
                int cmp = (compare(((List<?>) rightObject).get(i), ((List<?>) leftObject).get(i)));
                if (cmp == 0 && leftObject.size() == i + 1) {
                    return -1;
                } else if (cmp != 0) return cmp;
            }
        } else {
            for (int i = 0; i < leftObject.size(); i++) {
                int cmp = (compare(((List<?>) rightObject).get(i), ((List<?>) leftObject).get(i)));
                if (cmp != 0) return cmp;
            }
        }
        return 0;
    }

    private List<Object> toList(int leftObject) {
        return new ArrayList<>(List.of(leftObject));
    }

    private int compareInteger(int right, int left) {
        return Integer.compare(left, right);
    }

    private int getListSize(List<Object> obj) {
        return obj.size();
    }
}


