package src;

public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int prod = 1;
        prefix[0] = prod;
        for (int j=1;j<nums.length;j++) {
            prefix[j] = nums[j-1] * prod;
            prod = nums[j-1] * prod;
        }

        suffix[nums.length - 1] = 1;
        prod=1;
        for(int j=nums.length - 2; j>=0;j--) {
            suffix[j] = nums[j+1] * prod;
            prod = nums[j+1] * prod;
        }

        int[] res = new int[nums.length];
        for (int j=0;j<nums.length;j++) {
            res[j] = prefix[j] * suffix[j];
        }
        return res;
    }

    public static void main(String[] args) {
        Problem238 obj = new Problem238();
        int[] nums = new int[]{1,2,4,6};
        for (int n: obj.productExceptSelf(nums)) {
            System.out.println(n);
        }
    }
}
