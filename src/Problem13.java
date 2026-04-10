package src;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;;
        for(int i=0;i<s.length();i++) {
            char cur = s.charAt(i);
            if (i+1 < s.length() && map.get(cur) < map.get(s.charAt(i+1))) {
                sum -= map.get(cur);
            } else {
                sum += map.get(cur);
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        Problem13 obj = new Problem13();
        String[] inputs = {"III", "LVIII", "MCMXCIV", "DCXXI"};
        int[] outputs = {3, 58, 1994, 621};

        for (int i=0;i< inputs.length;i++) {
            String format = "Input: %s output: %s result: %s";
            System.out.println(String.format(format, inputs[i], obj.romanToInt(inputs[i]), obj.romanToInt(inputs[i]) == outputs[i]));
        }
    }
}
