import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(main.twoSumTwoPointers(nums, 13)));
    }

    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (true) {
            if (numbers[l] + numbers[r] == target) {
                int[] ans = { l + 1, r + 1 };
                return ans;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}