class Main {
    public static void main(String[] args) {

    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                res = Math.max(res, dp(i, j, matrix, memo));
        return res;
    }

    int[][] adjs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private int dp(int row, int col, int[][] matrix, int[][] memo) {
        if (memo[row][col] != 0)
            return memo[row][col];
        memo[row][col] = 1;
        for (int[] adj : adjs)
            if (isValid(row + adj[0], col + adj[1], row, col, matrix))
                memo[row][col] = Math.max(memo[row][col], 1 + dp(row + adj[0], col + adj[1], matrix, memo));
        return memo[row][col];
    }

    private boolean isValid(int nRow, int nCol, int row, int col, int[][] matrix) {
        return nRow >= 0 && nRow < matrix.length && nCol >= 0 && nCol < matrix[0].length
                && matrix[nRow][nCol] > matrix[row][col];
    }
}