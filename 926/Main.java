class Main {
    public static void main(String[] args) {

    }

    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        for (char c : s.toCharArray())
            if (c == '0')
                flips++;
        int minFlips = flips;
        for (char c : s.toCharArray()) {
            if (c == '0')
                flips--;
            else
                flips++;
            minFlips = Math.min(flips, minFlips);
        }
        return minFlips;
    }

    public int minFlipsMonoIncrDP(String s) {
        int ans = 0;
        int ones = 0;
        for (char c : s.toCharArray()) {
            if(c=='1')
                ones++;
            else
                ans = Math.min(ans+1, ones);
        }
        return ans;
    }
}