package src;

import java.util.*;

public class Problem150 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length;i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l=i+1, r= nums.length-1;

            while (l<r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    while (nums[l] == nums[l-1] && l<r) {
                        l++;
                    }
                } else if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem150 obj = new Problem150();

//        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{0, 0, 0};
        System.out.println(obj.threeSum(nums));
    }
}
