import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        int c = 0, i = num.length - 1;
        LinkedList<Integer> res = new LinkedList<Integer>();
        while (k > 0 || i >= 0 || c > 0) {
            int sum = c + k % 10 + (i >= 0 ? num[i] : 0);
            res.addFirst(sum % 10);
            c = sum / 10;
            i--;
            k /= 10;
        }
        return res;
    }
}