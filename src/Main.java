package src;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args)  {
        Map<Character, Integer> myMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            Character symbol = text.charAt(i);
            if ( !Character.isLetter(symbol) ) {
                continue;
            }

            if (myMap.containsKey(symbol)) {
                int count = myMap.get(symbol);
                myMap.put(symbol, count+1);
            } else {
                myMap.put(symbol, 1);
            }
        }

        if (myMap.size() < 1) {
            System.out.println("Произошла ошибка. Словарь myMap пустой");
            return;
        }

        // Максимальное количество
        int maxCount = -1;
        Character letter = null;
        for (Map.Entry<Character, Integer> entry : myMap.entrySet() ) {
            int value = entry.getValue();
            if ( value > maxCount) {
                maxCount = value;
                letter = entry.getKey();
            }
        }

        printResult(myMap, true, maxCount);

        // Минимальное количество
        int minCount = Integer.MAX_VALUE;
        letter = null;
        for (Map.Entry<Character, Integer> entry : myMap.entrySet() ) {
            int value = entry.getValue();
            if ( value < minCount) {
                minCount = value;
                letter = entry.getKey();
            }
        }

        printResult(myMap, false, minCount);
    }

    private static void printResult(Map<Character, Integer> myMap, Boolean max, int count) {
        String message = "";
        if (max) {
            message += "Чаще ";
        } else {
            message += "Реже ";
        }
        message += "всего, " + count + " раз(а), встречается(ются) буква(ы): ";
        //System.out.print("Чаще всего, " + maxCount + " раз(а), встречается(ются) буква(ы): "); //'" + letter + "'");
        for (Map.Entry<Character, Integer> entry : myMap.entrySet() ) {
            if (count == entry.getValue()) {
                message += "'" + entry.getKey() + "',";
            }
        }
        message += ".";
        message = message.replace(",.", ".");

        System.out.println(message);

    }
}
