import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        Main main = new Main();
        main.rotate(nums, 8);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] theKLastVals = new int[k];
        for (int i = 0; i < k; i++) {
            theKLastVals[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < theKLastVals.length; i++) {
            nums[i] = theKLastVals[i];
        }
    }
}