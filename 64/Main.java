class Main {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int startR = grid.length - 1;
        int startC = grid[0].length - 1;
        while (startC >= 0) {
            int r = startR;
            int c = startC;
            while (r < grid.length && c >= 0) {
                if (r < grid.length - 1 && c < grid[0].length - 1) {
                    grid[r][c] += Math.min(grid[r + 1][c], grid[r][c + 1]);
                } else if (r < grid.length - 1) {
                    grid[r][c] += grid[r + 1][c];
                } else if (c < grid[0].length - 1) {
                    grid[r][c] += grid[r][c + 1];
                }
                r++;
                c--;
            }
            if (startR != 0)
                startR--;
            else
                startC--;
        }
        return grid[0][0];
    }
}