import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        int[] boxes = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
        System.out.println(Arrays.toString(boxes));
        Main main = new Main();
        System.out.println(main.removeBoxes(boxes));
    }

    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[boxes.length][boxes.length][boxes.length];
        return removeBoxesUtil(boxes, 0, boxes.length - 1, 0, dp);
    }

    private int removeBoxesUtil(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j][k] > 0)
            return dp[i][j][k];
        int i0 = i, j0 = j, k0 = k;
        while (i < j && boxes[i + 1] == boxes[i]) {
            i++;
            k++;
        }
        int ans = (k + 1) * (k + 1) + removeBoxesUtil(boxes, i + 1, j, 0, dp);
        for (int a = i + 1; a <= j; a++)
            if (boxes[a] == boxes[i])
                ans = Math.max(ans,
                        removeBoxesUtil(boxes, i + 1, a - 1, 0, dp) + removeBoxesUtil(boxes, a, j, k + 1, dp));
        dp[i0][j0][k0] = ans;
        return ans;
    }
}