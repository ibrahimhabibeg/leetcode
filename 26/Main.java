import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,2,2,2,2,2,3,4,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right<nums.length) {
            if(nums[left] != nums[right]){
                nums[left+1] = nums[right];
                left++;
                right++;
            }else{
                right++;
            }
        }
        return left+1;
    }
}