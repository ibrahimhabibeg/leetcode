import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        combinationSumUtil(candidates, target, 0, new ArrayList<Integer>(), answers);
        return answers;
    }

    public void combinationSumUtil(int[] nums, int target, int start, List<Integer> sol,
            List<List<Integer>> answers) {
        if (target == 0) {
            answers.add(new ArrayList<Integer>(sol));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue; 
            if (target - nums[i] < 0)
                break;
            sol.add(nums[i]);
            combinationSumUtil(nums, target - nums[i], i+1, sol, answers);
            sol.remove(sol.size() - 1);
        }
    }
}