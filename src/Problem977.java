package src;

public class Problem977 {
        private static int[] sortedSquares(int[] nums) {
            int[] results = new int[nums.length];
            for (int i=0;i<nums.length;i++) {
                results[i] = nums[i]*nums[i];
            }
            int i=0,j = nums.length-1, finIndx = nums.length-1;
            int[] fin = new int[nums.length];
            while (i <= j) {
                if (results[i] > results[j]) {
                    fin[finIndx--] = results[i++];
                } else {
                    fin[finIndx--] = results[j--];
                }
            }
            return fin;
        }

        public static void main(String[] args) {

            int[] nums = {-4,-1,0,3,10};
            for (int i:  sortedSquares(nums)) {
                System.out.println(i);
            }

    }
}