import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.totalNQueens(4));
    }

    int ans = 0;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        boolean[] cols = new boolean[n];
        boolean[] diags = new boolean[2 * n - 1];
        boolean[] antiDiags = new boolean[2 * n - 1];
        Arrays.fill(cols, false);
        Arrays.fill(diags, false);
        Arrays.fill(antiDiags, false);
        solveNQueensUtil(0, 0, cols, diags, antiDiags);
        return this.ans;
    }

    private void solveNQueensUtil(int i, int row, boolean[] cols,
            boolean[] diags, boolean[] antiDiags) {
        if (i >= this.n) {
            ans++;
            return;
        }
        for (int col = 0; col < this.n; col++) {
            if (cols[col] == false && diags[row + col] == false && antiDiags[col + (this.n - 1 - row)] == false) {
                cols[col] = true;
                diags[row + col] = true;
                antiDiags[col + (this.n - 1 - row)] = true;
                solveNQueensUtil(i + 1, row + 1, cols, diags, antiDiags);
                cols[col] = false;
                diags[row + col] = false;
                antiDiags[col + (this.n - 1 - row)] = false;
            }
        }
    }
}