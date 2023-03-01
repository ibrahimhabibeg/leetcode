class Main {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int rSum = 0, lSum = 0;
        for (int i = 1; i < nums.length; i++)
            rSum += nums[i];
        for (int i = 0; i < nums.length; i++) {
            if (lSum == rSum)
                return i;
            lSum += nums[i];
            rSum -= i + 1 < nums.length ? nums[i + 1] : 0;
        }
        return -1;
    }
}