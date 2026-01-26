import java.util.HashMap;
import java.util.Map;

class Problem748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> licPlate = new HashMap<>();

        licPlate = createsMap(licensePlate);


        String result = "";
        for (String w: words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            tempMap = createsMap(w);
            if (compare(tempMap, licPlate)) {
                if (result.equals("")) {
                    result = w;
                } else if (result.length() > w.length()) {
                    result = w;
                }
            }
        }
        return result;
    }

    private boolean compare(Map<Character, Integer> actual, Map<Character, Integer> expected) {
        for (Character c: expected.keySet()) {
            if (!actual.containsKey(c) || actual.get(c) < expected.get(c)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> createsMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<word.length();i++) {
            char letter =  Character.toLowerCase(word.charAt(i));
            if (letter == ' ' || Character.isDigit(letter)){
                continue;
            }
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                int curVal = map.get(letter);
                map.put(letter, curVal+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Problem748 obj = new Problem748();
        String licensePlate = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};
        String result = obj.shortestCompletingWord(licensePlate, words);
        System.out.println(result);
    }
}