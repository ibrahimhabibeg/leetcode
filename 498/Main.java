class Main {
    public static void main(String[] args) {

    }

    public int[] findDiagonalOrder(int[][] mat) {
        int r = 0, c = 0, i = 0, m = mat.length, n = mat[0].length;
        boolean goingUp = true;
        int[] ans = new int[m * n];
        while (r < m && c < n) {
            while (r >= 0 && r < m && c >= 0 && c < n) {
                ans[i] = mat[r][c];
                i++;
                r += goingUp ? -1 : 1;
                c += goingUp ? 1 : -1;
            }
            r += goingUp ? 1 : -1;
            c += goingUp ? -1 : 1;
            if (goingUp) {
                if (c != n - 1)
                    c++;
                else
                    r++;
            } else {
                if (r != m - 1)
                    r++;
                else
                    c++;
            }
            goingUp = !goingUp;
        }
        return ans;
    }
}