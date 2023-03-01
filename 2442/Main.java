import java.util.HashSet;

class Main {
    public static void main(String[] args) {

    }

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums){
            set.add(i);
            set.add(reverse(i));
        }
        return set.size();
    }

    private int reverse(int num) {
        int ans = 0;
        while (num != 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }
}