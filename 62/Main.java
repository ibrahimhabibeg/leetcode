class Main {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        return binomialCoeff(n + m - 2, n - 1);
    }

    public int binomialCoeff(int n, int k) {
        long ans = 1;
        k = Math.min(n - k, k);
        for (int i = 0; i < k; i++) {
            ans *= (n - i);
            ans /= (i + 1);
        }
        return (int) ans;
    }
}