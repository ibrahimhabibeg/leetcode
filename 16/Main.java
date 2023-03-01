import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int currentSum;
        for (int i = 0; i < nums.length - 2; i++) {
            int closestTwoSum = twoSumClosest(nums, target-nums[i], i+1);
            currentSum = closestTwoSum+nums[i];
            if(currentSum==target){
                return currentSum;
            }
            if(Math.abs(currentSum-target)<Math.abs(res-target)){
                res = currentSum;
            }
        }
        return res;
    }

    public static int twoSumClosest(int[] nums, int target, int start){
        int left = start;
        int right = nums.length-1;
        int res = nums[right] + nums[left];
        int currentSum;
        while(left<right){
            currentSum = nums[right] + nums[left];
            if(currentSum>target){
                right--;
            }else if(currentSum<target){
                left++;
            }else{
                return currentSum;
            }
            if(Math.abs(currentSum-target)<Math.abs(res-target)){
                res = currentSum;
            }
        }
        return res;
    }
}