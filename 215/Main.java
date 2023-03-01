import java.util.concurrent.ThreadLocalRandom;

class Main {
  public static void main(String[] args) {
    Main main = new Main();
    int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    System.out.println(main.findKthLargest(nums, 4));
  }

  public int findKthLargest(int[] nums, int k) {
    return findKthSmallest(nums, nums.length - k + 1, 0, nums.length - 1);
  }

  public int findKthSmallest(int[] nums, int k, int start, int end) {
    if (start == end) {
      return nums[start];
    }
    int i = randomPartition(nums, start, end);
    int r = i - start + 1;
    if (k == r) {
      return nums[i];
    } else if (k < r) {
      return findKthSmallest(nums, k, start, i - 1);
    } else {
      return findKthSmallest(nums, k - r, i + 1, end);
    }
  }

  public int randomPartition(int[] nums, int start, int end) {
    int rand = ThreadLocalRandom.current().nextInt(start, end + 1);
    int pivot = nums[rand];
    nums[rand] = nums[end];
    int i = start - 1;
    for (int j = start; j < end; j++) {
      if (nums[j] <= pivot) {
        i++;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    nums[end] = nums[i + 1];
    nums[i + 1] = pivot;
    return i + 1;
  }
}