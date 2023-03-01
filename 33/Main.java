class Main {
    public static void main(String[] args) {
        int[] nums = {3,1};
        Main main =new Main();
        System.out.println(main.search(nums, 1));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m])
                return m;
            else if (nums[l] <= nums[m]){
                if(nums[l]<=target&&target<nums[m])
                    r=m-1;
                else
                    l=m+1;
            }
            else
                if(nums[m]<target&&target<=nums[r])
                    l=m+1;
                else
                    r=m-1;
        }
        return -1;
    }
}