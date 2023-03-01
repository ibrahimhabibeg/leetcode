class Main {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++)
            memo[i][i] = 1;
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                memo[i][j] = Math.max(memo[i][j - 1], memo[i + 1][j]);
                if (s.charAt(i) == s.charAt(j))
                    memo[i][j] = Math.max(memo[i][j], 2 + memo[i + 1][j - 1]);
            }
        }
        return memo[0][n - 1];
    }
}