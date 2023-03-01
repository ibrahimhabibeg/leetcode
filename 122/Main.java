class Main {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length];
        profits[profits.length - 1] = 0;
        for (int i = profits.length - 2; i >= 0; i--) {
            int ans = profits[i + 1] + Math.max(0, prices[i + 1] - prices[i]);
            for (int j = i + 2; j < profits.length; j++) {
                ans = Math.max(ans, profits[j] + prices[j] - prices[i]);
            }
        }
        return profits[0];
    }

}