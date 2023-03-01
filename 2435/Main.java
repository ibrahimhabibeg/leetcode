class Main {
    public static void main(String[] args) {

    }

    public int numberOfPaths(int[][] grid, int d) {
        int mod = 1000000007;
        int[][][] ans = new int[grid.length][grid[0].length][d];
        ans[0][0][grid[0][0] % d] = 1;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                if (j > 0)
                    for (int k = 0; k < d; k++)
                        ans[i][j][(k + grid[i][j]) % d] = ans[i][j - 1][k];
                if (i > 0)
                    for (int k = 0; k < d; k++)
                        ans[i][j][(k + grid[i][j]) % d] = (ans[i][j][(k + grid[i][j]) % d] + ans[i - 1][j][k]) % mod;
            }
        }
        return ans[ans.length - 1][ans[0].length - 1][0];
    }
}