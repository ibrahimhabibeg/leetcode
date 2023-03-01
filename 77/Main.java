import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<List<Integer>> ans = main.combine(5, 3);
        ans.forEach((comination) -> {
            comination.forEach((i) -> {
                System.out.print(i + ", ");
            });
            System.out.println("");
        });
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combineUtil(n, k, new ArrayList<Integer>(), ans, 1);
        return ans;
    }

    private void combineUtil(int n, int k, List<Integer> ans, List<List<Integer>> answers, int start) {
        if (ans.size() == k) {
            answers.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = start; i <= n - (k - (ans.size() + 1)); i++) {
            ans.add(i);
            combineUtil(n, k, ans, answers, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}