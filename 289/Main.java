class Main {
    public static void main(String[] args) {

    }

    int[][] adj = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                board[r][c] = board[r][c] * 16 + calcSurr(board, r, c, m, n);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] / 16 == 1 && board[r][c] % 16 != 2 && board[r][c] % 16 != 3)
                    board[r][c] = 0;
                else if (board[r][c] / 16 == 0 && board[r][c] % 16 == 3)
                    board[r][c] = 1;
                else
                    board[r][c] /= 16;
            }
        }
    }

    private int calcSurr(int[][] board, int row, int col, int m, int n) {
        int res = 0;
        for (int i = 0; i < adj.length; i++) {
            int nRow = row + adj[i][0], nCol = col + adj[i][1];
            if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n)
                continue;
            res += i < 4 ? board[nRow][nCol] / 16 : board[nRow][nCol];
        }
        return res;
    }
}