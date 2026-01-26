import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l=i+1, r= nums.length-1;
            while (l<r) {
                List<Integer> res = new ArrayList<>();
                int one = nums[i], two=nums[l], three=nums[r];
                int threeSum = one + two + three;
                if (threeSum == 0) {
                    res.add(one);
                    res.add(two);
                    res.add(three);
                    result.add(res);
                    l++;
                    while (nums[l] == nums[l-1] && l<r) {
                        l++;
                    }
                } else if (threeSum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Problem15 obj = new Problem15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum(nums));

    }
}
