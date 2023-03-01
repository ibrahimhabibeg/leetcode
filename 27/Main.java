import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(main.removeElement(arr,2));
        System.out.println(Arrays.toString(arr));
    }
    public int removeElement(int[] nums, int val) {
        int leftEmpty = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]==val){
                leftEmpty++;
            }else{
                nums[j-leftEmpty] = nums[j];
            }
        }
        return nums.length-leftEmpty;
    }
}