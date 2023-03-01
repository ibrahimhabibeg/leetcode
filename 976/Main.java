import java.util.Arrays;


class Main{
  public static void main(String[] args) {
    int[] arr= {1,4,7,2,8,9,1,7,2,5,8,6,1,4,7,2,5,7,8,9,5,1,5,7,14,68,54,14};
    Main main = new Main();
    System.out.println(main.largestPerimeter(arr));
  }
  public int largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    for (int i = nums.length-1; i>=2; i--) {
      if(nums[i-1]+nums[i-2]>nums[i]){
        return nums[i-1]+nums[i-2]+nums[i];
      }
    }
    return 0;
  }
}