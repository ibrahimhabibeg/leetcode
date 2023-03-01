class Main {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Main main = new Main();
        System.out.println(main.shipWithinDays(weights, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i : weights) {
            left = Math.max(left, i);
            right += i;
        }
        while (left < right) {
            int mid = (left + right) / 2, daysNeeded = 1, currBelt = 0;
            for (int i : weights) {
                if (currBelt + i > mid) {
                    daysNeeded += 1;
                    currBelt = 0;
                }
                currBelt += i;
            }
            if (daysNeeded > days)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}