import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Main main = new Main();
        List<Integer> ans = main.spiralOrder(matrix);
        ans.forEach(a->{System.out.println(a);});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int t = 0, l = 0, b = matrix.length - 1, r = matrix[0].length - 1;
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++)
                ans.add(matrix[t][i]);
            t++;
            for (int i = t; i <= b; i++)
                ans.add(matrix[i][r]);
            r--;
            if(t>b) break;
            for (int i = r; i >= l; i--)
                ans.add(matrix[b][i]);
            b--;
            if(l>r) break;
            for (int i = b; i >= t; i--)
                ans.add(matrix[i][l]);
            l++;
        }
        return ans;
    }
}