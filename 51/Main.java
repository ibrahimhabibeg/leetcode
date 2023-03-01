import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    ////////////////////////////////////////////////////////////////////
    /////////////////// Too Slow //////////////////
    ////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Main main = new Main();
        List<List<String>> allSols = main.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allSols = new ArrayList<List<String>>();
        char[][] sol = new char[n][n];
        boolean[] cols = new boolean[2 * n - 1];
        boolean[] rightDiags = new boolean[2 * n - 1];
        boolean[] leftDiags = new boolean[2 * n - 1];
        Arrays.fill(cols, false);
        Arrays.fill(rightDiags, false);
        Arrays.fill(leftDiags, false);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sol[i][j] = '.';
        solveNQueensUtil(n, 0, 0, sol, allSols, cols, rightDiags, leftDiags);
        return allSols;
    }

    private void solveNQueensUtil(int n, int i, int row, char[][] sol, List<List<String>> allSols, boolean[] cols,
            boolean[] rightDiags, boolean[] leftDiags) {
        if (i >= n) {
            addToSols(sol, allSols);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidPos(row, col, sol, n, cols, rightDiags, leftDiags)) {
                cols[col] = true;
                rightDiags[getRightDiag(row, col)] = true;
                leftDiags[getLeftDiag(row, col, n)] = true;
                sol[row][col] = 'Q';
                solveNQueensUtil(n, i + 1, row + 1, sol, allSols, cols, rightDiags, leftDiags);
                sol[row][col] = '.';
                cols[col] = false;
                rightDiags[getRightDiag(row, col)] = false;
                leftDiags[getLeftDiag(row, col, n)] = false;
            }
        }

    }

    private void addToSols(char[][] solArr, List<List<String>> allSols) {
        List<String> sol = new ArrayList<String>();
        for (int i = 0; i < solArr.length; i++) {
            String row = "";
            for (int j = 0; j < solArr.length; j++)
                row += solArr[i][j];
            sol.add(row);
        }
        allSols.add(sol);
    }

    private boolean isValidPos(int row, int col, char[][] sol, int n, boolean[] cols, boolean[] rightDiags,
            boolean[] leftDiags) {
        if (cols[col] == true || rightDiags[getRightDiag(row, col)] == true
                || leftDiags[getLeftDiag(row, col, n)] == true)
            return false;
        return true;
    }

    private int getRightDiag(int row, int col) {
        return row + col;
    }

    private int getLeftDiag(int row, int col, int n) {
        return col + (n - 1 - row);
    }
}