import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] intervals = {};
        int[] interval = { 16, 17 };
        System.out.println(Arrays.deepToString(main.insert(intervals, interval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<int[]>();
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            ans.add(intervals[i]);
            i++;
        }
        int start = i < intervals.length ? Math.min(intervals[i][0], newInterval[0]) : newInterval[0];
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            i++;
        }
        int end = i > 0 ? Math.max(intervals[i - 1][1], newInterval[1]) : newInterval[1];
        int[] derivedInterval = { start, end };
        ans.add(derivedInterval);
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}