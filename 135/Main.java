class Main {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n], right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                left[i] = 1 + left[i - 1];
        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                right[i] = 1 + right[i + 1];
        int res = n;
        for (int i = 0; i < n; i++)
            res += Math.max(left[i], right[i]);
        return res;
    }
}