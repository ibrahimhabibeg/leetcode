class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.mySqrt(2147483647));
    }

    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int l = 0;
        int r = x / 2;
        int ans = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            long square = m * m;
            if (square == x)
                return (int) m;
            else if (square < x) {
                ans = (int) m;
                l = (int) m + 1;
            } else
                r = (int) m - 1;
        }
        return ans;
    }
}