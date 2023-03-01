import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public int partitionArray(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int minInSub = nums[0];
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - minInSub > k) {
                ans++;
                minInSub = nums[i];
            }
        }
        return ans;
    }
}