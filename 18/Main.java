import java.util.*;

class Main{
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> output = main.fourSum(arr,-294967296);
        for (List<Integer> l1 : output) {
            System.out.print("["); 
            for (Integer n : l1) {
                System.out.print(n + ", "); 
            }
            System.out.print("]"); 
            System.out.println();
         }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        long t = target;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            if(t-nums[i]<Integer.MIN_VALUE || t-nums[i]>Integer.MAX_VALUE){
                continue;
            }
            res.addAll(threeSum(nums, i+1, t-nums[i], nums[i]));
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums, int start, long target, int v1) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = start; i < nums.length - 2; i++) {
            if(i!=start && nums[i]==nums[i-1]){
                continue;
            }
            if(target-nums[i]<Integer.MIN_VALUE || target-nums[i]>Integer.MAX_VALUE){
                continue;
            }
            res.addAll(twoSum(nums, i+1, target-nums[i], v1, nums[i]));
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int start, long target, int v1, int v2){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int left = start;
        int right = nums.length-1;
        List<Integer> triplet = new ArrayList<Integer>();
        triplet.add(v1);
        triplet.add(v2);
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
                triplet.add(v1);
                triplet.add(v2);
                left = incrementLeftTillNewValue(nums, left);
                right = decrementRightTillNewValue(nums, right, start);
            }
        }
        return res;
    }
    public int decrementRightTillNewValue(int[] nums, int right, int start){
        right--;
        while (right>=start && nums[right]==nums[right+1]) {
            right--;
        }
        return right;
    }
    public int incrementLeftTillNewValue(int[] nums, int left){
        left++;
        while (left<nums.length && nums[left]==nums[left-1]) {
            left++;
        }
        return left;
    }
}