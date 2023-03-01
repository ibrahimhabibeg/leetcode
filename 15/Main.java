import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main{
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4,-1,-1,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0};
        List<List<Integer>> output = threeSum(arr);
        for (List<Integer> l1 : output) {
            System.out.print("["); 
            for (Integer n : l1) {
                System.out.print(n + ", "); 
            }
            System.out.print("]"); 
            System.out.println();
         } 
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            res.addAll(twoSum(nums, i+1, -nums[i]));
        }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int left = start;
        int right = nums.length-1;
        List<Integer> triplet = new ArrayList<Integer>();
        triplet.add(-target);
        while(left<right){
            if (nums[left]+nums[right]<target) {
                left = incrementLeftTillNewValue(nums, left);
            }else if(nums[left]+nums[right]>target){
                right = decrementRightTillNewValue(nums, right, start);
            }else{
                triplet.add(nums[left]);
                triplet.add(nums[right]);
                res.add(triplet);
                triplet = new ArrayList<Integer>();
                triplet.add(-target);
                left = incrementLeftTillNewValue(nums, left);
                right = decrementRightTillNewValue(nums, right, start);
            }
        }
        return res;
    }
    public static int decrementRightTillNewValue(int[] nums, int right, int start){
        right--;
        while (right>=start && nums[right]==nums[right+1]) {
            right--;
        }
        return right;
    }
    public static int incrementLeftTillNewValue(int[] nums, int left){
        left++;
        while (left<nums.length && nums[left]==nums[left-1]) {
            left++;
        }
        return left;
    }
}