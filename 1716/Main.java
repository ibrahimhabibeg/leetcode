class Main {
    public static void main(String[] args) {

    }

    public int totalMoney(int n) {
        int d = n / 7;
        int r = n % 7;
        return 28 * d + 7 * d * (d - 1) / 2 + ((d + r) * (d + r + 1) - d * (d + 1)) / 2;
    }
}