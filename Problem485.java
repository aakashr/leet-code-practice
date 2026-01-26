public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0, start = 0, end = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                while (end < nums.length && nums[end] == 0) {
                    end++;
                }
                start = end;
            }
            if (nums[end] == 1) {
                max = Math.max(max, end - start + 1);
            }
            end ++;
        }
        return max;
    }
    public static void main(String[] args) {
    Problem485 problem485 = new Problem485();
    int[] nums = new int[] {0};
    System.out.println(problem485.findMaxConsecutiveOnes(nums));

    }
}
