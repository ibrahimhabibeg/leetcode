import java.lang.reflect.Array;
import java.util.*;

class Main {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int num = nums[0];
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                if (count > nums.length / 3) {
                    res.add(num);
                }
                num = nums[i];
                count = 1;
            }
        }
        if (count > nums.length / 3) {
            res.add(num);
        }
        return res;
    }
}