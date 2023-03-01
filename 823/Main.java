import java.util.Arrays;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 6 };
        Main main = new Main();
        System.out.println(main.numFactoredBinaryTrees(arr));
        System.out.print("[");
        for (int i = 0; i < 1000; i++)
            System.out.print(100000000 - i + ",");
        System.out.print("]");
    }

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);
        long res = 0, mod = 1000000007;
        long[] memo = new long[arr.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j]))
                    memo[i] = (memo[i] + (memo[j] * memo[map.get(arr[i] / arr[j])]) % mod) % mod;
            res = (res + memo[i]) % mod;
        }
        return (int) res;
    }

}