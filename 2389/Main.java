import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21, -45, 45645 };
        Main main = new Main();
        System.out.println(Arrays.toString(main.answerQueries(nums, queries)));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        for (int i = 0; i < queries.length; i++)
            queries[i] = findSubSequenceSize(nums, queries[i]);
        return queries;
    }

    private int findSubSequenceSize(int[] nums, int query) {
        int ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= query) {
                ans = m + 1;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}