package src;

import java.util.HashSet;
import java.util.Set;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        int res = 0, curMax = 0;
        Set<Integer> s = new HashSet<>();
        for (int n: nums) {
            s.add(n);
        }
        if (nums.length < 1) {
            return 0;
        }

        for (int n: s) {
            if (!s.contains(n-1)) {
                curMax++;
                int next = n+1;
                while(s.contains(next)) {
                    curMax++;
                    next++;
                }
            }
            res = Math.max(res, curMax);
            curMax=0;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem128 obj = new Problem128();
        int[] nums = new int[]{0,3,2,5,4,6,1,1};
//        int[] nums = new int[]{2,20,4,10,3,4,5};
        System.out.println(obj.longestConsecutive(nums));
    }
}
