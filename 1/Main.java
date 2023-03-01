import java.util.*;

class Main{
    public static void main(String[] args) {
        int[] exampleNums = {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
        int exampleTarget = 11;
        System.out.println(Arrays.toString(twoSum(exampleNums,exampleTarget)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        double T = target;
        double halfT = T/2;
        double[][] newNums = new double[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i][0] = i;
            newNums[i][1] = nums[i]-halfT;
        }
        Arrays.sort(newNums, Comparator.comparingDouble(a->Math.abs(a[1])));
        for (int i = 0; i < newNums.length-1; i++) {
            if(newNums[i][1] == -newNums[i+1][1]){
                result[0] = (int) (newNums[i][0]);
                result[1] = (int) (newNums[i+1][0]);
                break;
            }
        }
        return result;
    }
}