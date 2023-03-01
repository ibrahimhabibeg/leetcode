import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int left = 1;
        int right = 2;
        while (right<nums.length) {
            if(nums[left-1] != nums[right] || nums[left] != nums[right]){
                nums[left+1] = nums[right];
                left++;
            }
            right++;
        }
        return Math.min(left+1,nums.length);
    }
}