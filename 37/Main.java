import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        char[][] gameBoard = {
            {'9','.','.','7','2','.','.','.','.'},
            {'.','.','7','.','.','.','.','.','.'},
            {'.','.','2','.','5','.','.','8','.'},
            {'.','.','.','9','.','.','.','4','.'},
            {'.','.','.','.','.','8','.','.','5'},
            {'4','3','.','.','.','6','.','.','.'},
            {'.','1','.','.','.','.','9','.','.'},
            {'.','9','6','.','.','.','8','.','.'},
            {'.','.','.','.','.','.','2','5','7'},
        };
        Main main = new Main();
        SudokoNoSet s = new SudokoNoSet();
        s.solveSudoku(gameBoard);
        System.out.println(Arrays.deepToString(gameBoard));
    }

    ArrayList<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
    ArrayList<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
    ArrayList<HashSet<Character>> squares = new ArrayList<HashSet<Character>>();

    public void solveSudoku(char[][] board) {
        initSets(board);
        solveUtil(0, board);
    }

    private boolean solveUtil(int cell, char[][] gameBoard) {
        if (cell >= 81)
            return true;
        if (!isEmptyCell(cell, gameBoard))
            return solveUtil(cell + 1, gameBoard);
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(cell, (char) (i + '0'))) {
                gameBoard[cell / 9][cell % 9] = (char) (i + '0');
                addToSets(cell / 9, cell % 9, gameBoard);
                if (solveUtil(cell + 1, gameBoard))
                    return true;
                else {
                    removeFromSets(cell / 9, cell % 9, gameBoard);
                    gameBoard[cell / 9][cell % 9] = '.';
                }
            }
        }
        return false;
    }

    private void addToSets(int i, int j, char[][] gameBoard) {
        rows.get(i).add(gameBoard[i][j]);
        cols.get(j).add(gameBoard[i][j]);
        squares.get((i / 3) * 3 + (j / 3)).add(gameBoard[i][j]);
    }

    private void removeFromSets(int i, int j, char[][] gameBoard) {
        rows.get(i).remove(gameBoard[i][j]);
        cols.get(j).remove(gameBoard[i][j]);
        squares.get((i / 3) * 3 + (j / 3)).remove(gameBoard[i][j]);
    }

    private boolean isEmptyCell(int cell, char[][] gameBoard) {
        return gameBoard[cell / 9][cell % 9] == '.';
    }

    private boolean isValidMove(int cell, char i) {
        int row = cell / 9;
        int col = cell % 9;
        return !rows.get(row).contains(i) && !cols.get(col).contains(i)
                && !squares.get((row / 3) * 3 + (col / 3)).contains(i);
    }

    private boolean initSets(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            squares.add(new HashSet<Character>());
        }
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == '.')
                    continue;
                if (!rows.get(i).add(gameBoard[i][j]) || !cols.get(j).add(gameBoard[i][j])
                        || !squares.get((i / 3) * 3 + (j / 3)).add(gameBoard[i][j]))
                    return false;
            }
        }
        return true;
    }
}