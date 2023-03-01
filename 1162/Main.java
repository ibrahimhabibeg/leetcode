import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {

    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] adj = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    queue.add(new int[] { i, j });
        if (queue.size() == n * n)
            return -1;
        int res = -1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] cell = queue.poll();
                for (int[] add : adj) {
                    if (isPossible(cell[0] + add[0], cell[1] + add[1], grid)) {
                        grid[cell[0] + add[0]][cell[1] + add[1]] = 1;
                        queue.add(new int[] { cell[0] + add[0], cell[1] + add[1] });
                    }
                }
            }
            res++;
        }
        return res;
    }

    private boolean isPossible(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 0;
    }
}