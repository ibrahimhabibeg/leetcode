import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { 1,2,3,4,5,6,7,8 };
        System.out.println(Arrays.toString(main.getAverages(nums, 4)));
    }

    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        if (2 * k >= nums.length) {
            Arrays.fill(nums, -1);
            return nums;
        }
        int[] res = new int[nums.length];
        long sum = 0;
        for (int i = 0; i < k; i++) {
            res[i] = -1;
            sum += nums[i];
        }
        for (int i = k; i < 2 * k; i++) {
            sum += nums[i];
        }
        for (int i = k; i <= nums.length - 1 - k; i++) {
            sum += nums[i + k];
            long temp = sum / (2 * k + 1);
            res[i] = (int) temp;
            sum -= nums[i - k];
        }
        for (int i = nums.length - k; i < nums.length; i++) {
            res[i] = -1;
        }
        return res;
    }
}