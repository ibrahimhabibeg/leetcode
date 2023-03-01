import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            map.put(arr[i], 1 + map.getOrDefault(arr[i] + diff, 0));
            ans = Math.max(ans, map.get(arr[i]));
        }
        return ans;
    }
}