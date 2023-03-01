import java.util.Arrays;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> extra = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> needed = new HashMap<Integer, Integer>();
        int sumInMaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (needed.getOrDefault(arr[i], 0) > 0) {
                needed.put(arr[i], needed.get(arr[i]) - 1);
                sumInMaps--;
            } else {
                extra.put(arr[i], 1 + extra.getOrDefault(arr[i], 0));
                sumInMaps++;
            }
            if (extra.getOrDefault(sorted[i], 0) > 0) {
                extra.put(sorted[i], extra.get(sorted[i]) - 1);
                sumInMaps--;
            } else {
                needed.put(sorted[i], 1 + needed.getOrDefault(sorted[i], 0));
                sumInMaps++;
            }
            ans += sumInMaps == 0 ? 1 : 0;
        }
        return ans;
    }

    public int maxChunksToSortedFaster(int[] arr) {
        int ans = 1;
        int[] minRight = new int[arr.length];
        minRight[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) 
            minRight[i] = Math.min(arr[i], minRight[i+1]);
        int maxLeft = 0;
        for (int i = 0; i < minRight.length-1; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);
            if(maxLeft<=minRight[i+1])
                ans++;
        }
        return ans;
    }
}