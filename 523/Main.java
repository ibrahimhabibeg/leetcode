import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { 1,0,1,0,1 };
        System.out.println(main.checkSubarraySum(nums, 4));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length==1){
            return false;
        }
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        int sum = 0;
        table.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (table.get(sum%k)!=null && table.get(sum%k)+1<i) {
                return true;
            }else if(table.get(sum%k)==null){
                table.put(sum%k,i);
            }
        }
        return false;
    }
    
}