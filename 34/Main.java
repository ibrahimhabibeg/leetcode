import java.lang.annotation.Target;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        Main main = new Main();
        System.out.println(Arrays.toString(main.searchRange(nums, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = { getFirstPos(nums, target), getLatPos(nums, target) };
        return ans;
    }

    public int getFirstPos(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == t)
                ans = m;
            if (nums[m] >= t)
                r = m - 1;
            else
                l = m + 1;
        }
        return ans;
    }

    public int getLatPos(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == t)
                ans = m;
            if (nums[m] > t)
                r = m - 1;
            else
                l = m + 1;
        }
        return ans;
    }
}