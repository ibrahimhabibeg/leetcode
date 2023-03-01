import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getPermutation(3, 2));
    }

    public String getPermutation(int n, int k) {
        k--;
        List<Integer> numbers = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 0; i < n - 1; i++) {
            numbers.add(i + 1);
            fact *= (i + 1);
        }
        numbers.add(n);
        String ans = "";
        while (n > 0) {
            int toAdd = k / fact;
            ans += Integer.toString(numbers.get(toAdd));
            numbers.remove(toAdd);
            k = k % fact;
            if (n > 1)
                fact /= (n - 1);
            n--;
        }
        return ans;
    }
}