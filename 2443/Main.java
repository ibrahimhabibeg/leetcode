import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num / 2; i <= num; i++) {
            if (i + reverse(i) == num) {
                return true;
            }
        }
        return false;
    }

    private int reverse(int num) {
        int reverse = 0;
        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse;
    }
}