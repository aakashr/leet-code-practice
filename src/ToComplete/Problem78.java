package src.ToComplete;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int i, int[] nums) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i+1, nums);

        subset.removeLast();
        dfs(i+1, nums);
    }
    public static void main(String[] args) {
        Problem78 obj = new Problem78();
        int[] nums = new int[]{1,2,3};
        System.out.println(obj.subsets(nums));
    }
}







