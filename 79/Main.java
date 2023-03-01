class Main {
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        Main main = new Main();
        System.out.print(main.exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (word.charAt(0) == board[i][j]) {
                    board[i][j] = '#';
                    if (existUtil(board, word, i, j, 1))
                        return true;
                    board[i][j] = word.charAt(0);
                }

        return false;
    }

    int[][] mov = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private boolean existUtil(char[][] board, String s, int row, int col, int i) {
        if (i >= s.length())
            return true;
        for (int j = 0; j < mov.length; j++) {
            int nRow = row + mov[j][0], nCol = col + mov[j][1];
            if (isValid(board, s, nRow, nCol, i)) {
                board[nRow][nCol] = '#';
                if (existUtil(board, s, nRow, nCol, i + 1))
                    return true;
                board[nRow][nCol] = s.charAt(i);
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, String s, int row, int col, int i) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && s.charAt(i) == board[row][col];
    }
}