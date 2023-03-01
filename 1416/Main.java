class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numberOfArrays("1317", 2000));
    }  

    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////            Wrong Answer            ////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    public int numberOfArrays(String s, int k) {
        int[][] ans = new int[s.length()][s.length()];
        int d = (int) (Math.log10(k) + 1);
        return numberOfArraysUtil(s, k, d, 0, s.length() - 1, ans);
    }

    public int numberOfArraysUtil(String s, int k, int d, int i, int j, int[][] ans) {
        if (ans[i][j] != 0)
            return ans[i][j];
        int res = 0;
        for (int l = i; l < j; l++)
            if (s.charAt(l + 1) - '0' != 0)
                res += numberOfArraysUtil(s, k, d, i, l, ans) + numberOfArraysUtil(s, k, d, l + 1, j, ans);
        res += isSBigger(s, i, j - i + 1, d, k) ? 0 : 1;
        ans[i][j] = res;
        return res;
    }

    public boolean isSBigger(String s, int i, int L, int d, int k) {
        if (L != d)
            return L > d;
        int pow = 1;
        for (int j = 1; j < d; j++)
            pow *= 10;
        int no = k;
        int digit = no / pow;
        int j = i;
        while (j <= i + L - 1) {
            if (s.charAt(j) - '0' != digit)
                return (s.charAt(j) - '0') > digit;
            no = no % pow;
            pow /= 10;
            digit = no / pow;
        }
        return false;
    }
}