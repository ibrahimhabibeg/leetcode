import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0};
        main.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i]+=count[i-1];
        }
        for (int i = 0; i < count[0]; i++) {
            nums[i]=0;
        }
        for (int i = count[0]; i < count[1]; i++) {
            nums[i]=1;
        }
        for (int i = count[1]; i < count[2]; i++) {
            nums[i]=2;
        }
    }
}