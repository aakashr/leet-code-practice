package src;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, l=0;
        Set<Character> set = new HashSet<>();

        for (int r=0; r<s.length();r++) {
            char cur = s.charAt(r);
            while (set.contains(cur)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(cur);
            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static void main(String[] args) {
        Problem3 obj = new Problem3();
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
