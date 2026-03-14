package src.ToComplete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortAlphaNumeric {
    public String sort(String input) {

        StringBuilder sb = new StringBuilder(input);

        int size = input.length();
        int[] charArray = new int[26];
        int[] intArray = new int[10];

        for (char c: input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                charArray[c- 'A'] += 1;
            } else {
                intArray[c - '0'] += 1;
            }
        }

        int i = 0, j = 0;
        for (int idx = 0 ; idx < size; idx++) {
            char c = sb.charAt(idx);
            if (Character.isAlphabetic(c)) {
                while (charArray[i] == 0 && i < charArray.length) {
                    i++;
                }
                int charVal = i + 'A';
                charArray[i] -= 1;
                sb.setCharAt(idx, (char) charVal);
            } else {
                while (intArray[j] == 0 && j < intArray.length) {
                    j++;
                }
                int intVal = j + '0';
                intArray[j] -= 1;
                sb.setCharAt(idx, (char) intVal);
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        SortAlphaNumeric obj = new SortAlphaNumeric();

        String input = "B3A2D0";
//        String input = "9876543210AJIHGFEDCBA";
        System.out.println(obj.sort(input));
    }
}
