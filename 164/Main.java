import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] nums = { 10 };
    Main main = new Main();
    System.out.println(main.maximumGap(nums));
  }

  public int maximumGap(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    nums = radixSortArray(nums);
    int maxDifference = 0;
    for (int i = 1; i < nums.length; i++) {
      maxDifference = Math.max(maxDifference, nums[i] - nums[i - 1]);
    }
    return maxDifference;
  }

  public int[] radixSortArray(int[] nums) {
    for (int i = 0; i < 10; i++) {
      nums = countingSort(nums, i);
    }
    return nums;
  }

  public int[] countingSort(int[] nums, int digit) {
    int[] count = new int[10];
    for (int i = 0; i < nums.length; i++) {
      count[getDigit(nums[i], digit)]++;
    }
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }
    int[] res = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int digitVal = getDigit(nums[i], digit);
      res[count[digitVal] - 1] = nums[i];
      count[digitVal]--;
    }
    return res;
  }

  public int getDigit(int num, int digit) {
    int tenToDigitPlusOne = (int) Math.pow(10, digit + 1);
    int tenToDigitPlus = (int) Math.pow(10, digit);
    return (num % tenToDigitPlusOne) / tenToDigitPlus;
  }
}