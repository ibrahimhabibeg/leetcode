import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(main.findErrorNums(nums)));
    }

    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.fill(count, 0);
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        int repeated = -1;
        int removed = -1;
        int i = 0;
        while (i < count.length && (repeated < 0 || removed < 0)) {
            if (count[i] == 0) {
                removed = i + 1;
            } else if (count[i] == 2) {
                repeated = i + 1;
            }
            i++;
        }
        int[] res = {repeated, removed};
        return res;
    }
}