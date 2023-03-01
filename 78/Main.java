import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> ans = main.subsets(nums);
        ans.forEach((comination) -> {
            comination.forEach((i) -> {
                System.out.print(i + ", ");
            });
            System.out.println("");
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < Math.pow(2, nums.length); i++)
            ans.add(subsetMaker(i, nums));
        return ans;
    }

    private List<Integer> subsetMaker(int n, int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        String s = Integer.toBinaryString(n);
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '1')
                ans.add(nums[s.length()-1-i]);
            i--;
        }
        return ans;
    }
}