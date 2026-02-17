package src;

import java.util.*;

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            int[] key = new int[26];
            for (int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                key[c - 'a']++;
            }
            String mKey = Arrays.toString(key);
            map.putIfAbsent(mKey, new ArrayList<>());
            map.get(mKey).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Problem49 obj = new Problem49();
        String[] strs = new String[] {"act","pots","tops","cat","stop","hat"};
        System.out.println(obj.groupAnagrams(strs));
    }
}
