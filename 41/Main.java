class Main {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 5, 4 };
        Main main = new Main();
        System.out.println(main.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1] && nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.length + 1;
    }
}