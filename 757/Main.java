import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[][] intervalls = { { 1, 3 }, { 3, 7 }, { 5, 7 }, { 7, 8 } };
        Main main = new Main();
        System.out.println(main.intersectionSizeTwo(intervalls));
    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int big = -1, small = -1, res = 0;
        for (int[] interval : intervals) {
            if (interval[0] > big) {
                small = interval[1] - 1;
                big = interval[1];
                res += 2;
            } else if (interval[0] > small) {
                small = big;
                big = interval[1];
                res++;
            }
        }
        return res;
    }
}