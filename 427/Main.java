class Main {
    public static void main(String[] args) {

    }

    public Node construct(int[][] grid) {
        return constructUtil(grid, 0, 0, grid.length);
    }

    private Node constructUtil(int[][] grid, int l, int t, int d) {
        if (isLeaf(grid, l, t, d))
            return new Node(grid[t][l] == 1 ? true : false, true);
        d /= 2;
        return new Node(true, false, constructUtil(grid, l, t, d), constructUtil(grid, l + d, t, d),
                constructUtil(grid, l, t + d, d), constructUtil(grid, l + d, t + d, d));
    }

    private boolean isLeaf(int[][] grid, int l, int t, int d) {
        int num = grid[t][l];
        for (int i = t; i < t + d; i++)
            for (int j = l; j < l + d; j++)
                if (grid[i][j] != num)
                    return false;
        return true;
    }
}