import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] nums = { 8, 1, 2, 2, 3, 0, 0, 0, 4, 5, 6 };
        Main main = new Main();
        System.out.println(Arrays.toString(main.smallerNumbersThanCurrent(nums)));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] c = new int[101];
        for (int i : nums)
            c[i]++;
        for (int i = 1; i < c.length; i++)
            c[i] += c[i - 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] = c[nums[i] - 1];
            }
        }
        return nums;
    }
}