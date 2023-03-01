class Main {
    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int number = 1, t = 0, l = 0, b = n - 1, r = n - 1;
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = number;
                number++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = number;
                number++;
            }
            r--;
            if (t > b)
                break;
            for (int i = r; i >= l; i--) {
                matrix[b][i] = number;
                number++;
            }
            b--;
            if (l > r)
                break;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = number;
                number++;
            }
            l++;
        }
        return matrix;
    }
}