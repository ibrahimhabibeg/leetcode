import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) {
        int[] nums = { 7, -9, 15, -2 };
        Main main = new Main();
        System.out.println(main.minAbsDifference(nums, -5));
    }

    public int minAbsDifference(int[] nums, int goal) {
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        generate(0, nums.length / 2 - 1, 0, nums, left);
        generate(nums.length / 2, nums.length - 1, 0, nums, right);
        Collections.sort(left);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < right.size(); i++) {
            int r = right.get(i);
            int l = findClosest(left, goal - r);
            if (l + r == goal)
                return 0;
            res = Math.min(res, Math.abs(l + r - goal));
        }
        return res;
    }

    private int findClosest(List<Integer> list, int target) {
        int n = list.size();
        if (target <= list.get(0))
            return list.get(0);
        if (target >= list.get(n - 1))
            return list.get(n - 1);
        int l = 0, r = n, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            int val = list.get(mid);
            if (target == val)
                return val;
            if (target < val) {
                int preVal = mid > 0 ? list.get(mid - 1) : val;
                if (target > preVal)
                    return target - preVal >= val - target ? val : preVal;
                r = mid;
            } else {
                int postVal = mid < n - 1 ? list.get(mid + 1) : val;
                if (target < postVal)
                    return postVal - target >= target - val ? val : postVal;
                l = mid + 1;
            }
        }
        return list.get(mid);
    }

    private void generate(int i, int end, int sum, int[] nums, List<Integer> list) {
        if (i > end) {
            list.add(sum);
            return;
        }
        generate(i + 1, end, sum, nums, list);
        generate(i + 1, end, sum + nums[i], nums, list);
    }
}