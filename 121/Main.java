class Main {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int max = prices[prices.length - 1];
        int ans = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            ans = Math.max(ans, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int min = prices[0], res = 0;
        for (int price : prices) {
            res = Math.max(price - min, res);
            min = Math.min(min, price);
        }
        return res;
    }
}