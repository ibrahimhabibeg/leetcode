class Main {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        boolean isZeroFirstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isZeroFirstCol = true;
                break;
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    break;
                }
            }
        }
        for (int c = 1; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][c] == 0) {
                    for (int i = 0; i < matrix.length; i++)
                        matrix[i][c] = 0;
                    break;
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 0; c < matrix[0].length; c++)
                    matrix[r][c] = 0;
            }
        }
        if (isZeroFirstCol) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}