import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Main{
    public static void main(String[] args) {
        Main main = new Main();
        int[][] arr = {{1,3}}; 
        System.out.println(Arrays.deepToString(main.merge2(arr)));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((x)->x[0]));
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i<intervals.length-1 && end>=intervals[i+1][0]){
                i++;
                end = Math.max(end, intervals[i][1]);
            }
            int[] interval = {start, end};
            merged.add(interval);
        }
        int[][] res = merged.toArray(new int[merged.size()][2]);
        return res;
    }
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((x)->x[0]));
        List<int[]> merged = new ArrayList<int[]>();
        int i=1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        while(i<intervals.length){
            if(end>=intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }else{
                int[] interval = {start, end};
                merged.add(interval);
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        int[] interval = {start, end};
        merged.add(interval);
        int[][] res = merged.toArray(new int[merged.size()][2]);
        return res;
    }
}