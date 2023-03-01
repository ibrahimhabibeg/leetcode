import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> ans = main.getRow(4);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        int i = 1;
        long no = 1;
        int n = rowIndex;
        while (i < 1 + rowIndex / 2) {
            no *= n - i + 1;
            no /= i;
            ans.add((int) no);
            i++;
        }
        while (i <= rowIndex) {
            ans.add(ans.get(rowIndex - i));
            i++;
        }
        return ans;
    }
}