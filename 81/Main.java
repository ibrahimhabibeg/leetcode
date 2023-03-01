class Main {
    public static void main(String[] args) {

    }

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return true;
            if(nums[m]==nums[l] && nums[m]==nums[r]){
                l++;
                r--;
            }
            else if (nums[m] >= nums[l]) {
                if (nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }
        return false;
    }
}