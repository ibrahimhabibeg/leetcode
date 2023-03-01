class Main {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++)
            for (int j = 0; j < word2.length(); j++)
                dp[i][j] = -1;
        return minDistanceUtil(word1, word2, 0, 0, dp);
    }

    private int minDistanceUtil(String word1, String word2, int i, int j, int[][] dp) {
        if (i >= word1.length() || j >= word2.length())
            return Math.max(word1.length() - i, word2.length() - j);
        if(dp[i][j]>-1)
            return dp[i][j];
        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j))
            ans = minDistanceUtil(word1, word2, i + 1, j + 1, dp);
        else
            ans = 1 + Math.min(minDistanceUtil(word1, word2, i + 1, j, dp),
                    Math.min(minDistanceUtil(word1, word2, i, j + 1, dp),
                            minDistanceUtil(word1, word2, i + 1, j + 1, dp)));
        dp[i][j] = ans;
        return ans;
    }
}