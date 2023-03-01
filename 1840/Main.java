import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] restrictions = { { 5, 3 }, { 2, 5 }, { 7, 4 }, { 10, 3 } };
        System.out.println(main.maxBuilding(10, restrictions));
    }

    public int maxBuilding(int n, int[][] restrictions) {
        int newSize = restrictions.length + 2;
        Boolean foundN = false;
        for (int[] restriction : restrictions) {
            if (restriction[0] == n) {
                newSize--;
                foundN = true;
                break;
            }
        }
        restrictions = Arrays.copyOf(restrictions, newSize);
        int[] temp = { 1, 0 };
        restrictions[restrictions.length - 1] = temp;
        if (!foundN) {
            int[] lastBuilding = { n, n - 1 };
            restrictions[restrictions.length - 2] = lastBuilding;
        }
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < restrictions.length; i++) {
            int[] toReplace = { restrictions[i][0], Math.min(restrictions[i][1],
                    restrictions[i - 1][1] + restrictions[i][0] - restrictions[i - 1][0]) };
            restrictions[i] = toReplace;
        }
        for (int i = restrictions.length - 2; i >= 0; i--) {
            int[] toReplace = { restrictions[i][0], Math.min(restrictions[i][1],
                restrictions[i+1][1] - restrictions[i][0] + restrictions[i+1][0]) };
            restrictions[i] = toReplace;
        }
        int res = 0;
        for (int i = 1; i < restrictions.length; i++) {
            int x1 = restrictions[i - 1][0];
            int x2 = restrictions[i][0];
            int y1 = restrictions[i - 1][1];
            int y2 = restrictions[i][1];
            res = Math.max(res, Math.max(y1, y2) + (x2 - x1 - Math.abs(y1 - y2)) / 2);
        }
        return res;
    }
}