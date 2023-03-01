class Main {
    public static void main(String[] args) {

    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i < group.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < minProfit + 1; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= group[i-1])
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])])
                                % 1000000007;
                }
            }
        }
        return dp[group.length][n][minProfit];
    }

}