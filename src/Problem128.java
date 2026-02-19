package src;

import java.util.HashSet;
import java.util.Set;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n: nums) {
            s.add(n);
        }
        if (nums.length < 1) {
            return 0;
        }

        int max = nums[0];
        for(int i=1;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
        }

        int min = nums[0];
        for(int i=1;i<nums.length;i++) {
            min = Math.min(min, nums[i]);
        }

        int res = 0;
        int curMax = 0;
        for (int i=min; i<=max;i++) {
            if (s.contains(i)) {
                curMax++;
            } else {
                res = Math.max(res, curMax);
                curMax = 0;
            }
        }
        return Math.max(res, curMax);
    }

    public static void main(String[] args) {
        Problem128 obj = new Problem128();
        int[] nums = new int[]{0,3,2,5,4,6,1,1};
        System.out.println(obj.longestConsecutive(nums));
    }
}
