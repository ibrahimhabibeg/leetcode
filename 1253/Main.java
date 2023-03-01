import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] colsum = {2,1,2,0,1,0,1,2,0,1};
        System.out.println(main.reconstructMatrix(5, 5, colsum));
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] ans = new int[2][colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            ans[0][i] = colsum[i] == 2 || (colsum[i] == 1 && upper > lower) ? 1 : 0;
            ans[1][i] = colsum[i] == 2 || (colsum[i] == 1 && upper <= lower) ? 1 : 0;
            upper -= ans[0][i];
            lower -= ans[1][i];
        }
        return upper == 0 && lower == 0 ? new ArrayList(Arrays.asList(ans[0], ans[1])) : new ArrayList();
    }
}