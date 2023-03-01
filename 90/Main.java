import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        subsetsWithDupUtil(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    public void subsetsWithDupUtil(int[] nums, int s, List<Integer> prefix, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(prefix));
        for (int i = s; i < nums.length; i++) {
            if (i != s && nums[i] == nums[i - 1])
                continue;
            prefix.add(nums[i]);
            subsetsWithDupUtil(nums, i + 1, prefix, ans);
            prefix.remove(prefix.size() - 1);
        }
    }
}