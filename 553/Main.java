class Main {
    public static void main(String[] args) {
        int[] nums = { 1000, 100, 10, 2 };
        Main main = new Main();
        System.out.println(main.optimalDivision(nums));
    }

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        double[][] memo = new double[n][n];
        int[][] choice = new int[n][n];
        for (int i = 0; i < n; i++)
            memo[i][i] = nums[i] + 0.0;
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                memo[i][j] = memo[i][i] / memo[i + 1][j];
                choice[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    if (memo[i][j] < memo[i][k] / memo[k + 1][j]) {
                        memo[i][j] = memo[i][k] / memo[k + 1][j];
                        choice[i][j] = k;
                    }
                }
            }
        }
        return print(0, n - 1, nums, choice);
    }

    private String print(int i, int j, int[] nums, int[][] choice) {
        if (i == j)
            return Integer.toString(nums[i]);
        StringBuilder sb = new StringBuilder();
        int k = choice[i][j];
        sb.append('(');
        sb.append(print(i, choice[i][j], nums, choice));
        sb.append(")/(");
        sb.append(print(choice[i][j] + 1, j, nums, choice));
        sb.append(')');
        return sb.toString();
    }
}