import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Main {
    public static void main(String[] args) {
        int[] nums = { 6, 7, 1, 0, 1, 3, 0, 4, 8, 9 };
        Main main = new Main();
        System.out.println(Arrays.toString(main.sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
        heapsort(nums);
        return nums;
    }

    private void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quicksort(nums, left, pivot - 1);
            quicksort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, right, ThreadLocalRandom.current().nextInt(left, right + 1));
        int i = left - 1;
        for (int j = left; j < right; j++)
            if (nums[j] <= nums[right])
                swap(nums, ++i, j);
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void heapsort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums)
            pq.add(num);
        for (int i = 0; i < nums.length; i++)
            nums[i] = pq.poll();
    }
}