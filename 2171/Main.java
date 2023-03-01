import java.util.Arrays;

class Main {
    public static void main(String[] args) {
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long totalyRemoved = 0;
        for (int i : beans)
            totalyRemoved += i;
        totalyRemoved -= beans[beans.length - 1];
        long decreased = 0, ans = totalyRemoved;
        for (int i = beans.length - 2; i >= 0; i--) {
            if(Long.MAX_VALUE-decreased<(beans[i + 1] - beans[i]) * (beans.length - i - 1))
                decreased = Long.MAX_VALUE;
            else
                decreased += (beans[i + 1] - beans[i]) * (beans.length - i - 1);
            totalyRemoved -= beans[i];
            ans = Math.min(Long.MAX_VALUE-decreased<totalyRemoved?Long.MAX_VALUE:totalyRemoved+decreased, ans);
        }
        return ans;
    }
}