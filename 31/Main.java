class Main {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reorder(nums, i + 1, nums.length - 1);
    }

    public void reorder(int[] nums, int s, int e) {
        for (int i = 0; i < (e - s + 1) / 2; i++) {
            int temp = nums[s + i];
            nums[s + i] = nums[e - i];
            nums[e - i] = temp;
        }
    }
}