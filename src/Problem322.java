package src;

public class Problem322 {
    private int minChange(int[] coins, int target) {
        int[] dp = new int[target+1];
        dp[0] = 0;
        for (int i=1 ; i<=target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int n: coins) {
                if (i-n >= 0 && dp[i-n] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-n]);
                }
            }
        }
        if (dp[target] < Integer.MAX_VALUE) {
            return dp[target];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Problem322 obj = new Problem322();
        int[] coins = {1, 2, 3};
        System.out.println(obj.minChange(coins, 5));
    }
}