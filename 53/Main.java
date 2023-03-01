class Main {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}