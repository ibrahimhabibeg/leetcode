import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SummaryRanges {

    SortedSet<Integer> redBlackTree;

    public SummaryRanges() {
        redBlackTree = new TreeSet<Integer>();
    }

    public void addNum(int value) {
        redBlackTree.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<int[]>();
        int start = redBlackTree.first();
        int end = redBlackTree.first();
        for (int v : redBlackTree.tailSet(start + 1)) {
            if (end + 1 == v) {
                end = v;
            } else {
                int[] interval = { start, end };
                intervals.add(interval);
                start = v;
                end = v;
            }
        }
        int[] interval = { start, end };
        intervals.add(interval);
        int[][] ans = new int[intervals.size()][2];
        for (int i = 0; i < ans.length; i++)
            ans[i] = intervals.get(i);
        return ans;
    }

}
