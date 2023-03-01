import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] nums = { 0, 0, 0, 0, 0, 0, 9 };
    Main main = new Main();
    System.out.println(main.largestNumber(nums));
  }

  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = Integer.toString(nums[i]);
    }
    Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
    if (strs[0].equals("0")) {
      return "0";
    }
    String res = strs[0];
    for (int i = 1; i < strs.length; i++) {
      res += strs[i];
    }
    return res;
  }
}