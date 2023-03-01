import java.util.*;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] candidates = { 2, 3, 5 };
        List<List<Integer>> ans = main.combinationSum(candidates, 8);
        ans.forEach(solution -> {
            System.out.println("============================");
            solution.forEach(n -> System.out.print(n + ", "));
            System.out.println("");
            System.out.println("============================");
        });
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(candidates, target, new ArrayList<Integer>(), 0, res);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<Integer> ans, int start, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target-candidates[i]<0) break;
            ans.add(candidates[i]);
            backtrack(candidates, target-candidates[i], ans, i, res);
            ans.remove(ans.size() - 1);
        }
    }
}