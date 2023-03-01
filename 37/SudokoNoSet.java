import java.util.Arrays;

public class SudokoNoSet {

    public void solveSudoku(char[][] board) {
        solveUtil(0, board);
    }

    private boolean solveUtil(int cell, char[][] gameBoard) {
        if (cell >= 81)
            return true;
        if (!isEmptyCell(cell, gameBoard))
            return solveUtil(cell + 1, gameBoard);
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(cell, (char) (i + '0'), gameBoard)) {
                gameBoard[cell / 9][cell % 9] = (char) (i + '0');
                if (solveUtil(cell + 1, gameBoard))
                    return true;
                else 
                    gameBoard[cell / 9][cell % 9] = '.';
            }
        }
        return false;
    }

    private boolean isEmptyCell(int cell, char[][] gameBoard) {
        return gameBoard[cell / 9][cell % 9] == '.';
    }

    private boolean isValidMove(int cell, char i, char[][] gameBoard) {
        for (int j = 0; j < 9; j++) {
            if (gameBoard[cell / 9][j] == i || gameBoard[j][cell % 9] == i
                    || gameBoard[((cell / 9) / 3)*3 + (j / 3)][((cell % 9) / 3)*3 + (j % 3)] == i)
                return false;
        }
        return true;
    }

}
