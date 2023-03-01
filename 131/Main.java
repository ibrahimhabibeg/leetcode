import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        int[][] memo = new int[s.length()][s.length()];
        List<List<String>> ans = new ArrayList<List<String>>();
        partitionUtil(s, new ArrayList<String>(), 0, ans, memo);
        return ans;
    }

    private void partitionUtil(String s, List<String> partition, int i, List<List<String>> ans, int[][] memo) {
        if (i >= s.length())
            ans.add(new ArrayList<String>(partition));
        for (int j = i; j < s.length(); j++) {
            if (isPalindromic(s, memo, i, j)) {
                partition.add(s.substring(i, j + 1));
                partitionUtil(s, partition, j + 1, ans, memo);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindromic(String s, int[][] memo, int i, int j) {
        if (memo[i][j] > 0)
            return memo[i][j] == 1 ? true : false;
        for (int k = 0; k < (j - i + 1) / 2; k++) {
            if (s.charAt(i + k) != s.charAt(j - k)) {
                memo[i][j] = 2;
                return false;
            }
        }
        memo[i][j] = 1;
        return true;
    }
}