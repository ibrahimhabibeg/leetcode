import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        Main main = new Main();
        System.out.println(Arrays.deepToString(main.flipAndInvertImage(image)));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for (int[] row : image) {
            for (int i = 0; i < n / 2; i++) {
                int temp = row[i];
                row[i] = row[n - 1 - i] == 0 ? 1 : 0;
                row[n - 1 - i] = temp == 0 ? 1 : 0;
            }
            if (n % 2 == 1)
                row[n / 2] = row[n / 2] == 0 ? 1 : 0;
        }
        return image;
    }
}