import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    Main main = new Main();
    List<List<Integer>> output = main.permute(nums);
    for (List<Integer> permutation : output) {
      System.out.print("[");
      for (Integer i : permutation) {
        System.out.print(i + ", ");
      }
      System.out.println("]");
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 1) {
      List toAdd = new ArrayList<Integer>();
      toAdd.add(nums[0]);
      List res = new ArrayList<List<Integer>>();
      res.add(toAdd);
      return res;
    }
    List res = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length; i++) {
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
      List<List<Integer>> permuteSmaller = permute(toPass);
      for (List<Integer> permutation : permuteSmaller) {
        permutation.add(nums[i]);
        res.add(permutation);
      }
    }
    return res;
  }
}