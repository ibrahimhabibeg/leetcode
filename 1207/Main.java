import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        Main main = new Main();
        System.out.println(main.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (!set.add(count)) {
                    return false;
                }
                count = 1;
            }
        }
        if (!set.add(count)) {
            return false;
        }
        return true;
    }
}