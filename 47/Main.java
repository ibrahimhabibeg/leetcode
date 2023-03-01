import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3 };
        Main main = new Main();
        List<List<Integer>> output = main.permuteUnique(nums);
        for (List<Integer> permutation : output) {
            System.out.print("[");
            for (Integer i : permutation) {
                System.out.print(i + ", ");
            }
            System.out.println("]");
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 1) {
            List toAdd = new ArrayList<Integer>();
            toAdd.add(nums[0]);
            List res = new ArrayList<List<Integer>>();
            res.add(toAdd);
            return res;
        }
        List res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int[] toPass = new int[nums.length - 1];
            int j = 0;
            while (j < nums.length) {
                if (j == i) {
                    j++;
                    continue;
                } else if (j > i) {
                    toPass[j - 1] = nums[j];
                } else {
                    toPass[j] = nums[j];
                }
                j++;
            }
            List<List<Integer>> permuteSmaller = permuteUnique(toPass);
            for (List<Integer> permutation : permuteSmaller) {
                permutation.add(nums[i]);
                res.add(permutation);
            }
        }
        return res;
    }
}
