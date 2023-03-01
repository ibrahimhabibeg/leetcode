class Main {
    public static void main(String[] args) {
    
    }

    public int countSpecialSubsequences(int[] nums) {
        int[] ans = new int[3];
        for (int i : nums)
            ans[i] = ((2 * ans[i]) % 1000000007 + (i == 0 ? 1 : ans[i - 1])) % 1000000007;
        return ans[2];
    }
}