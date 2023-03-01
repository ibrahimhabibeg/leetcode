import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        Main main = new Main();
        System.out.println(main.subarraysDivByK(nums, 5));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] val = new int[k];
        val[0] = 1;
        int sum = 0, ans = 0;
        for (int i : nums) {
            sum = (sum + i % k + k) % k;
            ans += val[sum];
            val[sum]++;
        }
        return ans;
    }

    public int subarraysDivByKHashTable(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int i : nums) {
            sum = (sum + i % k + k) % k;
            ans += map.getOrDefault(sum, 0);
            map.put(sum, 1 + map.getOrDefault(sum, 0));
        }
        return ans;
    }
}