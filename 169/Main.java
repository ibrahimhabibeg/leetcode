import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
    Main main = new Main();
    System.out.println(main.majorityElement(nums));
  }

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        count++;
      } else {
        count = 1;
      }
      if (count > nums.length / 2) {
        return nums[i];
      }
    }
    return nums[0];
  }
}