class Main {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 8, 10 };
        Main main = new Main();
        System.out.println(main.addRungs(nums, 2));
    }

    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        double d = dist;
        for (int i = 0; i < rungs.length; i++) {
            ans += i > 0 ? (int) Math.ceil((rungs[i] - rungs[i - 1]) / d) - 1 : (int) Math.ceil(rungs[i] / d) - 1;
        }
        return ans;
    }
}