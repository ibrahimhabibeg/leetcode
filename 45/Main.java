class Main {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int ans = 0;
        int currentJumpsEnd = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(i + nums[i], maxReach);
            if (i == currentJumpsEnd) {
                currentJumpsEnd = maxReach;
                ans++;
            }
        }
        return ans;
    }
}