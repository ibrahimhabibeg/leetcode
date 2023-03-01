import java.util.HashSet;

class Main {
    public static void main(String[] args) {

    }

    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        HashSet<Integer> extra = new HashSet<Integer>();
        HashSet<Integer> needed = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!needed.remove(arr[i]))
                extra.add(arr[i]);
            if (!extra.remove(i))
                needed.add(i);
            ans += extra.isEmpty() && needed.isEmpty() ? 1 : 0;
        }
        return ans;
    }
}