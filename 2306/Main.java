import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        String[] ideas = { "coffee", "donuts", "time", "toffee" };
        Main main = new Main();
        System.out.println(main.distinctNames(ideas));
    }

    public long distinctNames(String[] ideas) {
        HashMap<Integer, HashSet<String>> map = new HashMap<Integer, HashSet<String>>();
        for (int i = 0; i < 26; i++)
            map.put(i, new HashSet<String>());
        for (String idea : ideas)
            map.get(idea.charAt(0) - 'a').add(idea.substring(1));
        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                HashSet<String> set1 = map.get(i), set2 = map.get(j);
                int k = 0;
                for (String s : set1)
                    if (set2.contains(s))
                        k++;
                res += 2 * (set1.size() - k) * (set2.size() - k);
            }
        }
        return res;
    }
}