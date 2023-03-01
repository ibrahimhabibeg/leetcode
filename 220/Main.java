import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        System.out.println((-1 + 1) / 4 - 1);
        Main main = new Main();
        int[] nums = { -78, 45, -1, 1815, -41954487, 41897897, -49854, 5454446, -4564574, 0, 8789797, -54665456, 489789,
                -5464564 };
        System.out.println(main.containsNearbyAlmostDuplicate(nums, 2, 1));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Hashtable<Integer, Integer> buckets = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= indexDiff + 1) {
                int keyToRemove = nums[i - indexDiff - 1] >= 0 ? nums[i - indexDiff - 1] / (valueDiff + 1)
                        : (nums[i - indexDiff - 1] + 1) / (valueDiff + 1) - 1;
                buckets.remove(keyToRemove);
            }
            int key = nums[i] >= 0 ? nums[i] / (valueDiff + 1) : (nums[i] + 1) / (valueDiff + 1) - 1;
            if (buckets.containsKey(key)
                    || (buckets.containsKey(key - 1) && nums[i] - buckets.get(key - 1) <= valueDiff)
                    || (buckets.containsKey(key + 1) && buckets.get(key + 1) - nums[i] <= valueDiff)) {
                return true;
            } else {
                buckets.put(key, nums[i]);
            }
        }
        return false;
    }
}