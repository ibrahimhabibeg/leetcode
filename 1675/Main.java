import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 5, 20, 3 };
        Main main = new Main();
        System.out.println(main.minimumDeviation(nums));
    }

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> orderedSet = new TreeSet<Integer>();
        for (int num : nums)
            orderedSet.add(num%2==0?num:num*2);
        int res = orderedSet.last()-orderedSet.first();
        while (orderedSet.last()%2==0) {
            orderedSet.add(orderedSet.pollLast()/2);
            res = Math.min(res, orderedSet.last()-orderedSet.first());
        }
        return res;
    }
}