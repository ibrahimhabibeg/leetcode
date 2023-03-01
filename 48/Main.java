import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
    Main main = new Main();
    main.rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int j = 0; j < n / 2; j++) {
      int top = j, left = j;
      int bottom = n - 1 - j, right = n - 1 - j;
      for (int i = 0; i < n - 1 - 2 * j; i++) {
        int key = matrix[top][left + i];
        matrix[top][left + i] = matrix[bottom - i][left];
        matrix[bottom - i][left] = matrix[bottom][right - i];
        matrix[bottom][right - i] = matrix[top + i][right];
        matrix[top + i][right] = key;
      }
    }
  }
}