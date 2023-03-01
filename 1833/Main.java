import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int i = 0;
        while (i < costs.length && coins >= costs[i]) {
            coins -= costs[i];
            ans++;
            i++;
        }
        return ans;
    }
}