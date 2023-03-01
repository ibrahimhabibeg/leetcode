class Main{
  public static void main(String[] args) {
    Main main = new Main();
    int[] arr = {1,2,3};
    System.out.println(main.increasingTriplet(arr));

  }
  public boolean increasingTriplet(int[] nums) {
    int s = Integer.MAX_VALUE;
    int l = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i]<=s){
        s=nums[i];
      }else if(nums[i]<=l){
        l=nums[i];
      }else{
        return true;
      }
    }
    return false;
  }
}