class Main {
  public static void main(String[] args) {
    int[] nums = {3,2,1,0,4};
    Main main = new Main();
    System.out.println(main.canJump(nums));
  }

  public boolean canJump(int[] nums) {
    int maxReach = nums[0];
    int i = 0;
    while (i<=maxReach && maxReach<nums.length-1) {
      maxReach = Math.max(maxReach, i+nums[i]);
      i++;
    }
    return maxReach>=nums.length-1;
  }
}