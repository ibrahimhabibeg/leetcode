import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        if (i >= 0) {
            digits[i] += 1;
            return digits;
        } else {
            int[] ans = new int[digits.length + 1];
            Arrays.fill(ans, 0);
            ans[0] = 1;
            return ans;
        }
    }
}