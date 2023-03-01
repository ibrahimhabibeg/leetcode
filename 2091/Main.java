class Main {
    public static void main(String[] args) {

    }

    public int minimumDeletions(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[a])
                a = i;
            if (nums[i] > nums[b])
                b = i;
        }
        int n = nums.length;
        return Math.min(Math.min(a + 1 + n - b, n - a + b + 1), Math.min(Math.max(a, b) + 1, n - Math.min(a, b)));
    }
}