class Main {
    public static void main(String[] args) {

    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++)
            res[i] = nums[n * (i % 2) + i / 2];
        return res;
    }

    public int[] shuffleInPlace(int[] nums, int n) {
        for (int i = n; i < nums.length; i++)
            nums[i] += nums[i - n] * 1024;
        int j = 0;
        for (int i = n; i < nums.length; i++, j += 2) {
            nums[j] = nums[i] / 1024;
            nums[j + 1] = nums[i] % 1024;
        }
        return nums;
    }
}