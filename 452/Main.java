import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        Main main = new Main();
        System.out.println(main.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) ->Integer.compare(a[1], b[1]));
        int ans = 0;
        long end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                end = points[i][1];
                ans++;
            }
        }
        ans++;
        return ans;
    }
}