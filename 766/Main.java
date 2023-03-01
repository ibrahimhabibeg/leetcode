class Main {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 478, 5, 1, 2 }, { 189, 189, 5, 1 } };
        Main main = new Main();
        System.out.println(main.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int row = 1; row < m; row += 2) {
            for (int col = 0; col < n; col++) {
                if ((col - 1 >= 0 && matrix[row][col] != matrix[row - 1][col - 1])
                        || (col + 1 < n && row + 1 < m && matrix[row][col] != matrix[row + 1][col + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}