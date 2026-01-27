package src;

public class Problem55 {
        public boolean canJump(int[] nums) {
            int goal = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] + i >= goal) {
                    goal = i;
                }
            }
            return goal == 0;
        }
        public static void main(String[] args) {
            int[] nums = new int[]{4,0,4,2,2,0,1,3,3,0,3};
            System.out.println(new Problem55().canJump(nums));
            StringBuilder sb = new StringBuilder();
        }
}


