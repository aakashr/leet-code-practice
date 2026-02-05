package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int n=0; n<nums.length; n++) {
            int diff = target - nums[n];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = n;
                break;
            } else {
                map.put(nums[n], n);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] nums = new int[]{3, 2, 3};
        int target = 6;
        for (int n: obj.twoSum(nums, target)) {
            System.out.print(n + " ");
        }

    }
}
