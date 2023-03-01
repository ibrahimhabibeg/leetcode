import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] scores = { 596, 277, 897, 622, 500, 299, 34, 536, 797, 32, 264, 948, 645, 537, 83, 589, 770 };
        int[] ages = { 18, 52, 60, 79, 72, 28, 81, 33, 96, 15, 18, 5, 17, 96, 57, 72, 72 };
        Main main = new Main();
        System.out.println(main.bestTeamScore(scores, ages));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] teams = new int[scores.length][2];
        for (int i = 0; i < teams.length; i++) {
            teams[i][0] = scores[i];
            teams[i][1] = ages[i];
        }
        Arrays.sort(teams, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int ans = 0;
        int[] dp = new int[scores.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = teams[i][0];
            for (int j = 0; j < i; j++)
                if (teams[j][0] <= teams[i][0])
                    dp[i] = Math.max(dp[i], teams[i][0] + dp[j]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}