class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numTrees(10));
    }

    public int numTrees(int n) {
        long c = binomialCoeff(2 * n, n);
        return Math.toIntExact(c / (n + 1));
    }

    public long binomialCoeff(int n, int k) {
        long res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}