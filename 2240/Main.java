class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.waysToBuyPensPencils(21, 10, 5));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; i <= total/cost1; i++) {
            ans += (total - i * cost1) / cost2 + 1;
        }
        return ans;
    }
}