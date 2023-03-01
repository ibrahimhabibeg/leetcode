class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = { -3, -2, -3 };
        System.out.println(main.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, cMax = 0, cMin = 0;
        for (int i : nums) {
            total += i;
            if (cMax < 0)
                cMax = i;
            else
                cMax += i;
            if (cMin > 0)
                cMin = i;
            else
                cMin += i;
            max = Math.max(max, cMax);
            min = Math.min(min, cMin);
        }
        return total == min ? max : Math.max(max, total - min);
    }
}