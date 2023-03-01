class Main {
	public static void main(String[] args) {
		Main main = new Main();
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(main.searchInsert(nums, 564));
	}

	public int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			int val = nums[m];
			if (val == target) {
				return m;
			} else if (val < target) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return nums[l] >= target ? l : l + 1;
	}
}