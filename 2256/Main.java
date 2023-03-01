class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { 1, 2 };
        System.out.println(main.minimumAverageDifference(nums));
    }

    public int minimumAverageDifference(int[] nums) {
        int ans = 0;
        long minDiff = Integer.MAX_VALUE;
        long lSum = 0;
        long rSum = 0;
        for (int i : nums) {
            rSum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            lSum += nums[i];
            rSum -= nums[i];
            long lAvg = lSum / (i + 1);
            long rAvg = (nums.length - i - 1) > 0 ? rSum / (nums.length - i - 1) : 0;
            long diff = Math.abs(lAvg - rAvg);
            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            }
        }
        return ans;
    }
}