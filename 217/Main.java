import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] nums = { 4, 5, 8, 12, 0, 3, -7, 1, 8, 63 };
    Main main = new Main();
    System.out.println(main.containsDuplicate(nums));
  }

  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }
    return false;
  }
}