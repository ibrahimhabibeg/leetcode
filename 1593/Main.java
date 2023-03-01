import java.util.HashSet;

class Main {
    public static void main(String[] args) {

    }

    int res = 0;

    public int maxUniqueSplit(String s) {
        bactrack(s, 0, new HashSet<String>());
        return res;
    }

    private void bactrack(String s, int i, HashSet<String> set) {
        res = Math.max(res, set.size());
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            sb.append(s.charAt(j));
            if (set.add(sb.toString())) {
                bactrack(s, j + 1, set);
                set.remove(sb.toString());
            }
        }
    }
}