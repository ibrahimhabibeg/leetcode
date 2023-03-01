import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { 1, 2, 3, 4, 5, 6, 3, 4, 5, 7, 8 };
        System.out.println(main.containsNearbyDuplicate(nums, 4));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}