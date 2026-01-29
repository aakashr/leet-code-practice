package src;

import java.util.*;

public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n:nums) {
            list.add(n);
        }

        return permuteList(list);

    }

    public List<List<Integer>> permuteList(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            return Arrays.asList(nums);
        }

        for (int i=0; i<nums.size(); i++) {
            List<List<Integer>> perms;
            int pop = nums.removeFirst();
            perms = permuteList(new ArrayList<>(nums));

            for (List<Integer> perm:perms) {
                perm.addLast(pop);
                result.add(perm);
            }
            nums.add(pop);
        }
        return result;
    }


    public static void main(String[] args) {
        Problem46 obj = new Problem46();

        int[] nums = new int[]{1, 2, 3};
        System.out.println(obj.permute(nums));
    }
}
