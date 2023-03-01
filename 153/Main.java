class Main {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r])
                break;
            int m = (l + r) / 2;
            if (nums[m] > nums[r])
                l = m + 1;
            else
                r = m;
        }
        return nums[l];
    }
}