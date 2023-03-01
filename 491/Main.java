import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { 4, 6, 7 };
        List<List<Integer>> ans = main.findSubsequences(nums);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        helper(ans, new LinkedList<Integer>(), 0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> list, int start, int maxVal, int[] nums) {
        if (list.size() >= 2)
            ans.add(new LinkedList<Integer>(list));
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;
            if (list.isEmpty() || nums[i] >= maxVal) {
                set.add(nums[i]);
                list.add(nums[i]);
                helper(ans, list, i + 1, nums[i], nums);
                list.remove(list.size() - 1);
            }
        }
    }
}