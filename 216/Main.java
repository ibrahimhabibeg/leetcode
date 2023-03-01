import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (n > 45 || (k * (k + 1)) / 2 > n)
            return ans;
        combinationSum3Util(k, n, 1, new ArrayList<Integer>(), ans);
        return ans;
    }

    public void combinationSum3Util(int k, int t, int s, List<Integer> sum, List<List<Integer>> ans) {
        if(t==0 && sum.size()==k)
            ans.add(new ArrayList<Integer>(sum));
        if(t==0 || sum.size()==k)
            return;
        for (int i = s; i <= Math.min(9, t); i++) {
            sum.add(i);
            combinationSum3Util(k, t - i, i + 1, sum, ans);
            sum.remove(sum.size() - 1);
        }
    }
}