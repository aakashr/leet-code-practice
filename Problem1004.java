public class Problem1004 {
    private int longestOnes(int[] nums,int k) {
        int maxCount = 0, start = 0, end = 0, zeroCount = 0;

        for (end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;
    }
    public static void main(String[] args) {
        Problem1004 problem1004 = new Problem1004();
        int[] nums = new int[] {1,1,0,0,0,1,1,1,1};

        problem1004.longestOnes(nums, 2);


    }
}
