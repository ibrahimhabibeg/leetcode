class Main {
    public static void main(String[] args) {

    }

    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];
        int[][] mov = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };
        for (int i = 0; i < ans.length; i++)
            for (int j = 0; j < ans.length; j++)
                for (int k = 0; k < mov.length; k++)
                    ans[i][j] = Math.max(ans[i][j], grid[i + 1 + mov[k][0]][j + 1 + mov[k][1]]);
        return ans;
    }
}