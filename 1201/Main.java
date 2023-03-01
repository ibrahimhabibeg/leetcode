class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.nthUglyNumber(4, 3, 4, 2));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = Math.min(a, Math.min(b, c));
        long r = n * l, ab = LCM(a, b), ac = LCM(a, c), bc = LCM(b, c);
        long abc = LCM(ab, c);
        while (l < r) {
            long m = (l + r) / 2;
            long count = m / a + m / b + m / c - m / ab - m / ac - m / bc + m / abc;
            if (count < n)
                l = m + 1;
            else
                r = m;
        }
        return (int) l;
    }

    private long LCM(long a, long b) {
        return (a / GCD(a, b)) * b;
    }

    private long GCD(long a, long b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}