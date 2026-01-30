package src;

import java.util.*;

public class Problem150 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int n = 0; n<nums.length;n++) {
            if (map.containsKey(nums[n])) {
                map.get(nums[n]).add(n);
            } else {
                List<Integer> index = new ArrayList();
                index.add(n);
                map.put(nums[n], index);
            }
        }

        int l=0, r = nums.length-1;

        while (l<=r) {
            List<Integer> temp = new ArrayList<>();

            int first = nums[l], sec = nums[r];
            int twoSum = first+sec;

            int thirdIndex = doesValExists(map, -1*twoSum, l, r);

            if (thirdIndex != -1) {
                temp.add(first);
                temp.add(sec);
                temp.add(nums[thirdIndex]);
                res.add(temp);
                l++;
            } else if (first + sec < 0) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public int doesValExists(Map<Integer, List<Integer>> map, int key, int firstIdx, int secIdx) {
        if (map.containsKey(key) && map.get(key).size() > 0) {
            for(int i: map.get(key)) {
                if (i != firstIdx && i != secIdx) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem150 obj = new Problem150();

        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum(nums));
    }
}
