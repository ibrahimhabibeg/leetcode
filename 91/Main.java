import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public int numDecodings(String s) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return numDecodingsUtil(s, 0, map);
    }

    private int numDecodingsUtil(String s, int i, HashMap<Integer, Integer> map) {
        if (map.containsKey(i))
            return map.get(i);
        if (i >= s.length())
            return 1;
        int ans = 0;
        if (s.charAt(i) - '0' == 0) {
            ans = 0;
        } else if ((s.charAt(i) - '0' == 1 && i + 1 < s.length())
                || (s.charAt(i) - '0' == 2 && i + 1 < s.length() && s.charAt(i + 1) - '0' <= 6)) {
            ans = numDecodingsUtil(s, i + 1, map) + numDecodingsUtil(s, i + 2, map);
        } else {
            ans = numDecodingsUtil(s, i + 1, map);
        }
        map.put(i, ans);
        return ans;
    }
}