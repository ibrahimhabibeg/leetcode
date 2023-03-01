import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int[] mul = { 3, 2, 1 };
        Main main = new Main();
        System.out.println(main.maximumScore(nums, mul));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[n][n];
        for (int L = n - m + 1; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                int takeLeft = nums[i] * multipliers[n - L] + (i + 1 == n ? 0 : dp[i + 1][j]);
                int takeRight = nums[j] * multipliers[n - L] + (j == 0 ? 0 : dp[i][j - 1]);
                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n - 1];
    }

    public int maximumScoreFaster(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[multipliers.length][multipliers.length];
        return dp(nums, multipliers, 0, 0, memo);
    }

    public int dp(int[] nums, int[] mult, int i, int j, Integer[][] memo) {
        if (j == mult.length)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        int takeLeft = nums[i] * mult[j] + dp(nums, mult, i + 1, j + 1, memo);
        int takeRight = nums[nums.length - 1 - j + i] * mult[j] + dp(nums, mult, i, j + 1, memo);
        memo[i][j] = Math.max(takeLeft, takeRight);
        return memo[i][j];
    }
}