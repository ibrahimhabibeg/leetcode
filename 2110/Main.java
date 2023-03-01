class Main {
    public static void main(String[] args) {

    }

    public long getDescentPeriods(int[] prices) {
        long ans = 1;
        int streak = 1;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] == prices[i + 1] + 1)
                streak++;
            else
                streak = 1;
            ans += streak;
        }
        return ans;
    }
}