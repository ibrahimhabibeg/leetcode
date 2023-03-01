import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] nums = { 1, -5, 78, 45, 90, -47, 57, 26, 48 };
        Main main = new Main();
        main.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int noOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (nums[i] == 0) {
                noOfZeros++;
            } else {
                nums[i] = 0;
                nums[i - noOfZeros] = val;
            }
        }
    }
}